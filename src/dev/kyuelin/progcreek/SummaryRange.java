package dev.kyuelin.progcreek;

import dev.kyuelin.utilities.IntGenerator;

import java.util.Arrays;

/**
 * Created by kennethlin on 4/28/16.
 */
public class SummaryRange {
    public static void summarize(int[] input) {
        int j=0;
        for(int i=0; i<input.length-1; i++) {
            if (input[i+1] != (input[i]+1)) {
                System.out.format("[%d,%d]", j, i);
                j = i+1;
            }
        }
        System.out.format("[%d,%d]", j, input.length-1);
    }

    public static void main(String[] args) {
        int[] input = IntGenerator.genUniqIntArray(23,100);
        Arrays.sort(input);
        System.out.println(Arrays.toString(input));
        summarize(input);
    }
}
