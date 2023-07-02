package dev.kyuelin.citi.interviews;

import java.util.ArrayList;
import java.util.List;

public class BlockingQ {
    List<String> stringList;
    int max_capacity;

    BlockingQ(int i) {
        this.max_capacity=i;
        stringList = new ArrayList<>(max_capacity);
    }

    public synchronized void enqueue(String s) throws InterruptedException {
        // sporious wakeup
        while (stringList.size() == max_capacity) {
            wait();
        }
        stringList.add(s);
        if (stringList.size() == 1) {
            notifyAll();
        }
    }

    public synchronized String dequeue() throws InterruptedException {
        while (stringList.size() == 0) {
            wait();
        }
/*
        if (stringList.size() == max_capacity) {
            notifyAll();
        }
        return stringList.remove(0);
*/
        String s = stringList.remove(0);
        if (stringList.size() == max_capacity-1) {
            notifyAll();
        }
        return s;
    }
}

