package dev.kyuelin.progcreek;

import java.util.Arrays;

/**
 * Created by linken on 4/22/16.
 */
public class MergeSort {
    public static void sort(int[] input) {
        int left=0;
        int right=input.length-1;
        if (input == null || input.length<2) return;
        msort(input, left, right);
    }

    public static void msort(int[] in, int left, int right) {
        if (left >= right) return;
        int mid = (left+right)/2;
        msort(in, left, mid);
        msort(in, mid+1, right);
        merge(in, left, mid, right);
    }

    public static void merge(int[] in, int left, int mid, int right) {
        int l=left;
        int r=mid+1;
        int[] temp = Arrays.copyOf(in, in.length);
        int k = l;
        while(l <= mid && r <=right) {
            if (temp[l] < temp[r]) {
                in[k] = temp[l];
                l++;
            }
            else {
                in[k] = temp[r];
                r++;
            }
            System.out.println(Arrays.toString(in));
            k++;
        }
        while(l <= mid) {
            in[k++] = temp[l++];
        }
    }

    public static void main(String[] args) {
        int[] input = TestUtilities.genRandIntArray(23,100);
        System.out.println(Arrays.toString(input));
        sort(input);
        System.out.println(Arrays.toString(input));
    }
}
