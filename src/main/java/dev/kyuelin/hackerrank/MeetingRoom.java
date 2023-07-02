package dev.kyuelin.hackerrank;

import org.slf4j.LoggerFactory;

import java.util.*;

public class MeetingRoom {

    static class Event implements Comparable<Event> {
        int arrival;
        int duration;
        int end;

        Event(int arrival, int duration, int end) {
            this.arrival = arrival;
            this.duration = duration;
            this.end = end;
        }

        @Override
        public int compareTo(Event e) {
            if (this.arrival < e.arrival)
                return -1;
            else if (this.arrival == e.arrival) {
                if (this.duration < e.duration) return -1;
                else if (this.duration == e.duration) return 0;
                else return 1;
            }
            return 1;
        }

        @Override
        public String toString() {
            return "Event{" +
                    "arrival=" + arrival +
                    ", duration=" + duration +
                    ", end=" + end +
                    '}';
        }
    }

    public static Integer maxEvents(List<Integer> arrivals, List<Integer> durations) {

        List<Event> events = new ArrayList<Event>();
        for (int i = 0; i < arrivals.size(); i++) {
            events.add(new Event(arrivals.get(i), durations.get(i), arrivals.get(i) + durations.get(i)));
        }
        Collections.sort(events);
//        System.out.println(events);

        List<Event> resEvents = new ArrayList<Event>();
        Event current_i = events.get(0);
        Event current_j = null;
        resEvents.add(current_i);
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).arrival == current_i.arrival) continue;
            for (int j = i; j < events.size(); j++) {
                current_j = events.get(j);
                if (current_i.compareTo(current_j) == 0) continue;
                else if (current_j.arrival >= current_i.end) {
                    current_i = current_j;
                    resEvents.add(current_i);
                }
            }
        }
        Integer maxCount = resEvents.size();
        System.out.println(resEvents);
//        events.forEach(System.out::println);
        return maxCount;
    }

    public static List<Integer> genIntList(int size, int upperbound) {
        List<Integer> retList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Random rand = new Random();
            retList.add(rand.nextInt(upperbound));
        }
        return retList;
    }

    public static void main(String[] args) {
        int runs = 111;
        for (int i = 0; i < runs; i++) {
            System.out.format("====== Test[%d] ======\n", i);
            runTest(runs);
        }
    }

    public static void runTest(int runs) {
//        List<Integer> arr = Arrays.asList(1, 1, 6);
//        List<Integer> dur = Arrays.asList(4, 0, 3);
        int size = 3;
        int bound = 11;
        List<Integer> arr = genIntList(size, bound);
        List<Integer> dur = genIntList(size, bound);

        System.out.println("Arrivals :" + arr);
        System.out.println("Durations:" + dur);
        System.out.format("Max number of events is : %d\n", maxEvents(arr, dur));
    }
}
