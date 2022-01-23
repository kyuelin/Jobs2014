package dev.kyuelin.citi.mthread;

public class MTAtomicInc {

    class MyRunnable implements Runnable {
        private int count=0;
        //private AtomicInteger count= new AtomicInteger();

        @Override
        public void run() {
            int i=0;
            while (i < 50) {
                try {
                    Thread.sleep(10);
                    //count.incrementAndGet();
                    synchronized(this) {
                        count++;
                    }
                    i++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main (String[] args) throws InterruptedException {
        MyRunnable myRunnable = (new MTAtomicInc()).new MyRunnable();
        Thread thread1 = new Thread(myRunnable);
        thread1.start();

        Thread thread2 = new Thread(myRunnable);
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(myRunnable.count);
    }

}
