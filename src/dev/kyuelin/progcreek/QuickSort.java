package dev.kyuelin.progcreek;

import java.util.Arrays;

/**
 * Created by linken on 4/22/16.
 */
public class QuickSort {
    public static void sort (int[] input) {
        qsort(input,0, input.length-1);
    }

    public static void qsort(int[] in, int left, int right) {
        int l=left;
        int r=right;
        int pivot = in[right];

        if (in == null || in.length < 2) return;
        if (l >= r) return;

        while (l<=r) {
            while(in[l] < pivot) {l++;};
            while(in[r] > pivot) {r--;}

            if (l<=r) {
                //swap
                int t = in[l];
                in[l] = in[r];
                in[r]=t;
                l++;
                r--;
                System.out.println(Arrays.toString(in));
            }
        }
        if (left < r) {
            qsort(in, left, r);
        }
        if (l < right) {
            qsort(in, l, right);
        }
    }

    public static void main(String[] args) {
        int size_bound = 20;
        int value_bound = 100;
        int[] input = TestUtilities.genRandIntArray(size_bound, value_bound);
        System.out.println(Arrays.toString(input));
        sort(input);
        System.out.println(Arrays.toString(input));
    }
}
