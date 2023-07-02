package dev.kyuelin.citi.interviews;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CollectionHashmap {
    // Hashmap < Integer, String >
    // Odd Keys

    public static void main(String[] args) {
        HashMap<Integer, String> isMap = new HashMap<>();
        isMap.put(1, "one");
        isMap.put(2, "two");

        Set<Integer> kset = isMap.keySet();

        System.out.println(isMap);

        System.out.println(kset);

/*
        for (Integer in : kset) {
            if (in.intValue() % 2 == 1) {
                String retstr = isMap.remove(in.intValue());
                System.out.println(retstr);
            }
        }
*/
        Iterator iterator = kset.iterator();
        while(iterator.hasNext()) {
            Integer ik = (Integer) iterator.next();
            if (ik%2==1) {
                iterator.remove();
            }
        }

        System.out.println(isMap);
    }
}

