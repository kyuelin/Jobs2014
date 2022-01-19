package dev.kyuelin.progcreek;

import dev.kyuelin.utility.IntGenerator;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by kennethlin on 4/28/16.
 */
public class SearchForARange {
    public static void search(int[] input, int target) {
        int[] res = bsearch(input, 0, input.length-1, target);
        System.out.println(Arrays.toString(res));
    }

    public static int[] bsearch(int[] input, int left, int right, int target) {
        int[] res = new int[2];
        if (left >= right) return res;
        int mid = (left + right)/2;
        if (input[mid] == target) {
            int l = mid-1;
            int r = mid+1;
            while (input[l] == target) l--;
            while (input[r] == target) r++;
            res[0] = l+1;
            res[1] = r-1;
        }
        else if (input[mid] > target) {
            res=bsearch(input, left, mid-1, target);
        }
        else {
            res=bsearch(input, mid+1, right, target);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = IntGenerator.genIntArray(53,10);
        int target = new Random(System.nanoTime()).nextInt(10);
        Arrays.sort(input);
        System.out.println(Arrays.toString(input));
        System.out.println("target=" + target);
        search(input,target);
    }
}
