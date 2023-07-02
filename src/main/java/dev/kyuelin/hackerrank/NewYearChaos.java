package dev.kyuelin.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by linken on 6/27/16.
 */
public class NewYearChaos {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        List<String> results = new ArrayList<>();
        for (int a0 = 0; a0 < T; a0++) {
            int n = in.nextInt();
            int[] q = new int[n];
            for (int q_i = 0; q_i < n; q_i++) {
                q[q_i] = in.nextInt();
            }
            results.add(findMinBribes(q, n));
            // your code goes here
        }
        for (String s : results) {
            System.out.println(s);
        }
    }

    private static String findMinBribes(int[] q, int n) {
        int distance = 0;
        int bnum = 0;
        for (int k = 0; k < 2; k++) {
            distance = 0;
            for (int j = 0; j < n - 1; j++) {
                int curr = Math.abs(q[j] - j - 1) + Math.abs(q[j + 1] - (j + 1) - 1);
                int post = Math.abs(q[j + 1] - j - 1) + Math.abs(q[j] - (j + 1) - 1);
                if (post < curr) {
                    int t = q[j];
                    q[j] = q[j + 1];
                    q[j + 1] = t;
                    bnum++;
                    System.out.println(Arrays.toString(q));
                }
            }
            for (int i = 0; i < n; i++) {
                distance += Math.abs(q[i] - i - 1);
            }
            if (distance == 0) {
                return Integer.toString(bnum);
            }
        }

        System.out.println(Arrays.toString(q));
        for (int i = 0; i < n; i++) {
            distance += Math.abs(q[i] - i - 1);
        }
        if (distance == 0) {
            return Integer.toString(bnum);
        } else {
            return "Too chaotic";
        }

    }
}
