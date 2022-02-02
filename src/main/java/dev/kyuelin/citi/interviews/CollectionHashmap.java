package dev.kyuelin.citi.interviews;

import java.util.HashMap;
import java.util.Set;

public class CollectionHashmap {
    // Hashmap < Integer, String >
    // Odd Keys

    public static void main(String[] args) {
        HashMap<Integer, String> isMap = new HashMap<>();
        isMap.put(1, "one");
        isMap.put(2, "two");

        Set<Integer> kset = isMap.keySet();

        for (Integer in : isMap.keySet()) {
            System.out.println(in + ":" + isMap.get(in));
        }

        for (Integer in : kset) {
            if (in.intValue() % 2 == 1) {
                isMap.remove(in);
            }
        }

        for (Integer in : isMap.keySet()) {
            System.out.println(in + ":" + isMap.get(in));
        }
    }
}

