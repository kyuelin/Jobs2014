package dev.kyuelin.concurrency;

import java.util.ArrayList;
import java.util.List;

public class MyBlockingQueue {

    private List<Object> queue = new ArrayList<>();
    private int limit = 10;

    public MyBlockingQueue(int limit) {
        this.limit = limit;
    }

    public synchronized void enqueue(Object item) throws InterruptedException {
        while (this.queue.size() == this.limit) {
            wait();
        }
        this.queue.add(item);
        if (this.queue.size() == 1) {
            notifyAll();
        }
    }

    public synchronized Object dequeue() throws InterruptedException {
        while (this.queue.size() == 0) {
            wait();
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }
        return this.queue.remove(0);
    }

}
