package dev.kyuelin.progcreek;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by linken on 4/17/16.
 */
public class BinarySearch {
    public static int search(int[] i, int target) {
        return binSearch(i, 0, i.length-1, target);
    }

    public static int binSearch(int[] i, int left, int right, int target) {
        int mid = (left + right)/2;
        if (left>right) return -1;
        else if (i[mid]==target) return mid;
        else if (i[mid]>target) return binSearch(i, left, mid-1, target);
        else return binSearch(i, mid+1, right, target);
    }

    public static void main(String[] args) {
        int size = new Random().nextInt(20);
        int range = new Random().nextInt(40);
        int[] input=genRandomIntList(size, range);
        Arrays.sort(input);
        int target = new Random().nextInt(40);
        System.out.println(Arrays.toString(input));
        System.out.println("target=" + target);

        System.out.println("index="+search(input, target));
    }

    public static int[] genRandomIntList(int n, int range) {
        int[] ret = new int[n];
        for (int i=0; i<n; i++ ) {
           ret[i]=new Random().nextInt(range);
        }
        return ret;
    }
}
