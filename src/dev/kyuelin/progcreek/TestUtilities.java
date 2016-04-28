package dev.kyuelin.progcreek;

import java.util.Random;

/**
 * Created by linken on 4/22/16.
 */
public class TestUtilities {
    public static int[] genRandIntArray(int sz_bound, int vl_bound) {
        Random rand = new Random(System.nanoTime());
        int size = rand.nextInt(sz_bound);
        while (size < 1) rand.nextInt(sz_bound);
        int[] output = new int[size];
        for (int i = 0; i<size; i++) {
            output[i]=rand.nextInt(vl_bound);
        }
        return output;
    }
    public static void swapIntInArray(int[] input, int i1, int i2) {
        int temp = input[i1];
        input[i1] = input[i2];
        input[i2] = temp;
    }
}
