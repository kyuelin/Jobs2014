package dev.kyuelin.progcreek;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by linken on 4/25/16.
 */
public class MajorityElement {
    public static void find(int[] input) {
        Map<Integer, Integer> majEleMap = new HashMap<>();
        for (int i : input){
            int e = input[i];
            if (majEleMap.containsKey(e)) {
                majEleMap.put(e, majEleMap.get(e) + 1);
            } else {
                majEleMap.put(e, 1);
            }
        }
        for (Map.Entry entry : majEleMap.entrySet()) {
            if ((Integer)entry.getValue() > input.length / 2 ) {
                System.out.println("Majority Element: " + entry.getKey() );
            }

        }
    }

    public static void main(String[] args) {
        int[] input = TestUtilities.genRandIntArray(50, 3);
        System.out.println(Arrays.toString(input));
        find(input);
    }
}
