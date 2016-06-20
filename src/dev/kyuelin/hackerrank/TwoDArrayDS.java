package dev.kyuelin.hackerrank;

import dev.kyuelin.utilities.IntGenerator;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by linken on 6/18/16.
 */
public class TwoDArrayDS {

    public static void main(String[] args) {
        /*
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int arr_i=0; arr_i < 6; arr_i++){
            for(int arr_j=0; arr_j < 6; arr_j++){
                arr[arr_i][arr_j] = in.nextInt();
            }
        }
        int arr[][] = IntGenerator.genFixedIntMatrix(6,6,2);

        for(int i=0; i<arr.length;i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        */
        int arr[][] = {
                {-1, 1, -1, 0, 0, 0},
                {0, -1, 0, 0, 0, 0},
                {-1, -1, -1, 0, 0, 0},
                {0, -9, 2, -4, -4, 0},
                {-7, 0, 0, -2, 0, 0},
                {0, 0, -1, -2, -4, 0}
        };
        System.out.println(getLargestSum(arr));
    }

    private static int getLargestSum(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                int top = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
                int bottom = arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                sum = Math.max(sum, top + bottom + arr[i + 1][j + 1]);
            }
            System.out.println(sum);
        }
        return sum;
    }
}
