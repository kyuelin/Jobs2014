package dev.kyuelin.utilities;

import java.util.Random;

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
}
