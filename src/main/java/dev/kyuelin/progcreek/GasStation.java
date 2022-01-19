package dev.kyuelin.progcreek;

import java.util.Arrays;

/**
 * Created by kennethlin on 4/26/16.
 */
public class GasStation {
    public static void find (int[] gas, int[] cost) {
        for (int i = 0; i<gas.length; i++) {
            int j = i;
            int k = 0;
            int sum = 0;
            boolean flag = true;
            while (k<gas.length) {
                sum += gas[j];
                sum -= cost[j];
                if (sum < 0) {
                    flag = false;
                    break;
                }
                k++;
                j = (j+1)%gas.length;
            }
            if (flag) {
                System.out.println("starting from " + j);
            }
        }
    }
    public static void canCompleteCircuit(int[] gas, int[] cost) {
        int sumRemaining = 0; // track current remaining
        int total = 0; // track total remaining
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int remaining = gas[i] - cost[i];

            //if sum remaining of (i-1) >= 0, continue
            if (sumRemaining >= 0) {
                sumRemaining += remaining;
                //otherwise, reset start index to be current
            } else {
                sumRemaining = remaining;
                start = i;
            }
            total += remaining;
        }

        if (total >= 0){
            System.out.println("starting from " + start);
        } else{
            System.out.println("starting from " + -1);
        }
    }

    public static void main(String[] args) {
        //int[] gas = IntGenerator.genFixedSizeIntArray(5,10);
        //int[] cost = IntGenerator.genFixedSizeIntArray(5,10);
        int[] gas = {1, 2, 4, 3, 5};
        int[] cost = {1, 3, 4, 2, 5};
        System.out.println(Arrays.toString(gas));
        System.out.println(Arrays.toString(cost));
        find(gas, cost);
        System.out.format("-------------\n");
        canCompleteCircuit(gas, cost);
    }
}
