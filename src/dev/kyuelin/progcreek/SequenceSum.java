package dev.kyuelin.progcreek;

import dev.kyuelin.utilities.IntGenerator;

import java.util.Arrays;

/**
 * Created by kennethlin on 4/25/16.
 */
public class SequenceSum {
    public static void findSeq(int[] input, int sumcheck) {
        int j=0,sum=0;
        for(int i=0; i<input.length; i++) {
            sum+=input[i];
            if(sum == sumcheck) {
                System.out.format("[%d,%d]\n", j,i);
                sum-=input[j];
                j++;
            }
            else if (sum > sumcheck) {
                sum -= input[j];
                j++;
            }
        }
    }
    public static void main(String[] args) {
        int[] input = IntGenerator.genIntArray(20,100);
        System.out.println(Arrays.toString(input));
        findSeq(input, 100);
    }
}
