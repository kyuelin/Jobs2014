package dev.kyuelin.utilities;

import java.util.*;

/**
 * Created by kennethlin on 4/25/16.
 */
public class IntGenerator {
    public static int[] genIntArray(int size_range, int value_range) {
        Random randgen = new Random(System.nanoTime());
        int size = randgen.nextInt(size_range)+1;
        int[] output = new int[size];
        for(int i=0; i<size;i++) {
            output[i] = randgen.nextInt(value_range)+1;
        }
        return output;
    }
    public static int[] genFixedSizeIntArray(int size, int value_range) {
        Random randgen = new Random(System.nanoTime());
        int[] output = new int[size];
        for(int i=0; i<size;i++) {
            output[i] = randgen.nextInt(value_range)+1;
        }
        return output;
    }
    public static int[] genUniqIntArray(int size_range, int value_range) {
        Random randgen = new Random(System.nanoTime());
        int size = randgen.nextInt(size_range)+1;
        if (value_range < size) value_range=size;

        Set<Integer> numSet = new HashSet<>();
        while(numSet.size()<size) {
            int num = randgen.nextInt(value_range);
            while(numSet.contains(num)) num = randgen.nextInt(value_range);
            numSet.add(num);
        }
        int[] intArray = new int[size];
        int i = 0;
        for (Object o :  numSet.toArray()) {
            intArray[i++] = ((Integer) o).intValue();
        }
        return intArray;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(genUniqIntArray(23,100)));
    }
}
