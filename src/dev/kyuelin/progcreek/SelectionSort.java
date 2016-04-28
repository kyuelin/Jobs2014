package dev.kyuelin.progcreek;

import java.util.Arrays;

/**
 * Created by linken on 4/23/16.
 */
public class SelectionSort {
    public static void sort(int[] in) {
        for(int i=0; i<in.length; i++) {
            int mindex = i;
            for (int j=i; j<in.length; j++) {
                if (in[j] < in[mindex]) {
                    mindex=j;
                }
            }
            if (i != mindex) {
                TestUtilities.swapIntInArray(in, mindex, i);
            }
        }
    }

    public static void main(String[] args) {
        int[] input = TestUtilities.genRandIntArray(23, 100) ;
        System.out.println(Arrays.toString(input));
        sort(input);
        System.out.println(Arrays.toString(input));
    }
}
