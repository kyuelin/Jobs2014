package dev.kyuelin.citi.dstructure;

import java.util.ArrayList;
import java.util.List;

public class CBlockingQueue {
    private int capacity = 16;
    private List boundedQueue = new ArrayList(capacity);

    public synchronized Object dequeue() throws InterruptedException {
        while (boundedQueue.size() == 0) {
            wait();
        }
        // notify producer waiting for the filled queue to be drained
        if (capacity == boundedQueue.size()) {
            notifyAll();;
        }
        return boundedQueue.remove(0);
    }

    public synchronized void enqueue(Object o) throws InterruptedException {
        while (boundedQueue.size() == capacity) {
            wait();
        }
        boundedQueue.add(o);
        // notify consumer to pick up items from the empty queue
        if (1 == boundedQueue.size()) {
            notifyAll();;
        }
    }

}
