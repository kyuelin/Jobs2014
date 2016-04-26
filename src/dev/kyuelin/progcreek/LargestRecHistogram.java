package dev.kyuelin.progcreek;

import dev.kyuelin.utilities.IntGenerator;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by kennethlin on 4/25/16.
 */
public class LargestRecHistogram {
    public static void findLargRect(int[] input, int width) {
        int max=0;
        int[] intval= new int[2];
        for (int i=0; i<input.length; i++) {
            int j=i, min=input[i];
            while(j>=0) {
                min = Math.min(input[j], min);
                if(width*min*(i-j+1) > max) {
                    max=width*min*(i-j+1);
                    intval[0]=j;
                    intval[1]=i;
                }
                j--;
            }
        }
        System.out.format("max area = %d\n", max);
        System.out.format("inter val [%d,%d]\n", intval[0],intval[1]);
    }
    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();

        int max = 0;
        int i = 0;

        while (i < height.length) {
            //push index to stack when the current height is larger than the previous one
            if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                //calculate max value when the current height is less than the previous one
                int p = stack.pop();
                int h = height[p];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(h * w, max);
            }

        }

        while (!stack.isEmpty()) {
            int p = stack.pop();
            int h = height[p];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(h * w, max);
        }

        return max;
    }
    public static void main(String[] args) {
        //int[] input = IntGenerator.genIntArray(20,10);
        int[] input = {1, 5, 1, 1, 5, 2, 9, 1, 5, 10, 4};
        System.out.println(Arrays.toString(input));
        findLargRect(input, 1);
        System.out.println(largestRectangleArea(input));
    }
}
