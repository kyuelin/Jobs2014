package dev.kyuelin.citi.mthread;

public class MTSyncCounter {
    private int counter;
    private static int staticCounter;

    public MTSyncCounter(int c) {
        counter = c;
    }

    public int getCounter() {
        return counter;
    }

    public void add(int value) {
        // The synchronized keyword changes that. When a thread enters a synchronized block
        // it will refresh the values of all variables visible to the thread.
        // When a thread exits a synchronized block all changes to variables visible to the thread will be committed to main memory.
        // This is similar to how the volatile keyword works.
        synchronized (this)
        {
            this.counter += value;
        }
    }

    public synchronized static void sadd(int value) {
        staticCounter += value;
    }

    class CounterRunnable implements Runnable {

        private final MTSyncCounter myCounter;
        private final int myTimes;

        public CounterRunnable(MTSyncCounter mtSyncCounter, int times) {
            this.myCounter = mtSyncCounter;
            this.myTimes = times;
        }

        @Override
        public void run() {
            for (int i = 0; i < this.myTimes; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myCounter.add(1);
            }
        }
    }

    public static void printTStatus (Thread[] threads) {
        for(int i=0; i<threads.length; i++) {
            System.out.format("%d, thread[%s], %s\n", i, threads[i].getName(), threads[i].getState());
        }
    }

    public static void main(String[] args) throws InterruptedException {

        int expected = 20;

        for (int i = 0; i < 100; i++) {

            MTSyncCounter mtSyncCounter = new MTSyncCounter(0);

            CounterRunnable counterRunnable = mtSyncCounter.new CounterRunnable(mtSyncCounter, 10);

            Thread[] threads = new Thread[2];

            for (int i2 = 0; i2 < 2; i2++) {
                Thread thread = new Thread(counterRunnable);
                threads[i2] = thread;
                threads[i2].start();
            }
            printTStatus(threads);
            for (int i3 = 0; i3 < 2; i3++) {
                threads[i3].join();
            }
            printTStatus(threads);

/*
            Thread thread1 = new Thread(counterRunnable);
            Thread thread2 = new Thread(counterRunnable);

            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();
*/

            if (expected != mtSyncCounter.getCounter()) {
                System.out.format("%d, counter=%d\n", i, mtSyncCounter.getCounter());
            }
        }
    }
}
