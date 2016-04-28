package dev.kyuelin.progcreek;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by linken on 4/23/16.
 */
public class SearchRotatedSortedArray {
    public static int search(int[] input, int target) {
        if (input == null || input.length <1) return -1;

        //return rec_search(input, 0, input.length-1, target);
        return bin_search(input, 0, input.length-1, target);
    }
    public static int rec_search(int[] input, int begin, int end, int target) {
        if (begin>end) return -1;
        if (begin == end && input[begin] != target)  return -1;
        int mid= (begin+end)/2;
        if (input[mid] == target) return mid;

        if (input[begin] < input[mid])  {
            for(int i=begin; i<=mid; i++) {
                if (input[i]==target) return i;
            }
            return rec_search(input, mid+1, end, target);
        }
        else {
            for (int i=mid+1; i<=end; i++) {
                if (input[i] == target) return i;
            }
            return rec_search(input, begin, mid, target);
        }
    }

    public static int bin_search(int[] input,int begin, int end, int target) {
        if (begin > end) return -1;
        int mid=(begin+end)/2;
        if (input[mid]== target) return mid;

        if (input[begin] < input[end]) {
            if (input[begin] <= target && target < input[mid]) {
                return bin_search(input, begin, mid-1, target);
            }
            else
                return bin_search(input, mid+1, end, target);
        }
        else if (input[begin] > input[end]){
            if (input[mid]<target && target <=input[end]) {
                return bin_search(input, mid+1, end, target) ;
            }
            else
                return bin_search(input, begin, mid-1, target);
        }
        else {
            return bin_search(input, ++begin, end, target);
        }
    }

    public static void main(String[] args) {
        int[] input = TestUtilities.genRandIntArray(20,40);
        Arrays.sort(input);
        int target = new Random().nextInt(40);
        System.out.println(Arrays.toString(input));
        System.out.println("target=" +target);
        System.out.println(search(input, target));
    }
}
