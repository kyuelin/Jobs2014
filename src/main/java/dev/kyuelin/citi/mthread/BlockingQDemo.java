package dev.kyuelin.citi.mthread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class BlockingQDemo {

    // https://docs.oracle.com/javase/specs/jls/se8/html/jls-17.html

    public static void main(String[] args) throws InterruptedException {
        int capacity = 16;
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(capacity);

        BlockingQDemo blockingDemo = new BlockingQDemo();

        ConsumerRunnable[] consumerRunnables = new ConsumerRunnable[2];

        ConsumerRunnable consumerRunnable1 = blockingDemo.new ConsumerRunnable(blockingQueue);
        consumerRunnables[0]=consumerRunnable1;
        ConsumerRunnable consumerRunnable2 = blockingDemo.new ConsumerRunnable(blockingQueue);
        consumerRunnables[1]=consumerRunnable2;

        ConsumerNotifier consumerNotifier = blockingDemo.new ConsumerNotifier(consumerRunnables);

        ProducerRunnable producerRunnable = blockingDemo.new ProducerRunnable(blockingQueue, consumerNotifier);


        Thread thread1 = new Thread(producerRunnable);
        thread1.start();
        Thread thread2 = new Thread(consumerRunnable1);
        thread2.start();
        Thread thread3 = new Thread(consumerRunnable2);
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

    }

    class ConsumerNotifier {
        ConsumerRunnable[] consumerRunnables;

        ConsumerNotifier(ConsumerRunnable[] crs) {
            this.consumerRunnables = crs;
        }
        public void stop() {
            for(int i=0; i<consumerRunnables.length; i++) {
                consumerRunnables[i].stop();
            }
        }
    }

    class ProducerRunnable implements Runnable {

        BlockingQueue blockingQueue;
        ConsumerNotifier consumerNotifier;

        ProducerRunnable(BlockingQueue bq, ConsumerNotifier cn) {
            this.blockingQueue = bq;
            this.consumerNotifier = cn;
        }

        public void run() {
            for(int i=0; i < 1_000; i++) {
                try {
                    blockingQueue.put("item_" + i);
                    System.out.format("%s puts %s\n", Thread.currentThread().getName(), "item_" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            consumerNotifier.stop();
            System.out.format("%s ended\n", Thread.currentThread().getName());
        }
    }

    class ConsumerRunnable implements Runnable {

        BlockingQueue blockingQueue;
        AtomicBoolean stopFlag = new AtomicBoolean(false);

        ConsumerRunnable(BlockingQueue bq) {
            this.blockingQueue = bq;
        }

        public void run() {
            while (getStopFlag() == false){
                String item = null;
                try {
                    item = (String) blockingQueue.take();
                    System.out.format("T0 [%s] : %s\n", Thread.currentThread().getName(), item);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String item2;
            while (!blockingQueue.isEmpty()) {
                try {
                    item2 = (String) blockingQueue.take();
                    System.out.format("T1 [%s] : %s\n", Thread.currentThread().getName(), item2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.format("%s ended\n", Thread.currentThread().getName());
        }

        public synchronized void stop() {
            stopFlag.set(true);
            System.out.format("stop() %s\n", Thread.currentThread().getName());
        }

        public synchronized boolean getStopFlag() {
            System.out.format("getStopFlag() %s\n", Thread.currentThread().getName());
            return stopFlag.get();
        }
    }

}