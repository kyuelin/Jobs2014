package dev.kyuelin.progcreek;

import dev.kyuelin.utility.IntGenerator;

import java.util.Arrays;

/**
 * Created by kennethlin on 4/28/16.
 */
public class ContainerMostWater {
    public static void find(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length-1;
        while(left<right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            System.out.format("[%d,%d]: %d\n", left, right, max);
            if (height[left] > height[right]) right--;
            else left++;
        }
        System.out.println("max = " + max);
    }
    public static void main(String[] args) {
        int[] input = IntGenerator.genIntArray(10,10);
        System.out.println(Arrays.toString(input));
        find(input);
    }
}
