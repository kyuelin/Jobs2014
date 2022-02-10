package dev.kyuelin.leetcode;

import java.util.Arrays;

public class TrimMean {
    public double trimMean(int[] arr) {
        double mean=0;
        Arrays.sort(arr);
        int sum=0;
        for(int i = (int) (arr.length*.05); i<arr.length*(1-0.05); i++) {
            sum+=arr[i];
        }
        mean = sum/(arr.length*(1-2*0.05));
        return mean;
    }
}
