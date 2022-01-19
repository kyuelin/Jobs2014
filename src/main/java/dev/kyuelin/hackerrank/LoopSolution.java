package dev.kyuelin.hackerrank;

import java.util.Scanner;

/**
 * Created by linken on 10/30/15.
 */
public class LoopSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        int[][] testArray = new int[t][];
        for (int i=0; i<t; ++i) {
            testArray[i] = new int[3];
            testArray[i][0] = sc.nextInt(); // a
            testArray[i][1] = sc.nextInt(); // b
            testArray[i][2] = sc.nextInt(); // n
            sc.nextLine();
        }

        for (int j=0; j<t; ++j) {
            int sum=testArray[j][0];
            for (int n=1; n<=testArray[j][2]; ++n) {
                sum += Math.pow(2, n-1) * testArray[j][1];
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}
