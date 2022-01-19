package dev.kyuelin.hackerrank;

import java.util.Scanner;

/**
 * Created by linken on 6/27/16.
 */
public class UtopiaTree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] results = new int[t];
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            results[a0] = calHeight(n);
        }

        for(int r : results) {
            System.out.println(r);
        }
    }

    private static int calHeight(int n) {
        int height=1;
        for(int i=0; i<n; i++) {
            height = (i%2 == 0) ? height*2: height+1;
        }
        return height;
    }
}
