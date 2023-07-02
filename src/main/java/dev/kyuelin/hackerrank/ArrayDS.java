package dev.kyuelin.hackerrank;

import java.util.Scanner;

/**
 * Created by linken on 6/17/16.
 */
public class ArrayDS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        for (int i=n;i>0;i--) {
            System.out.print(arr[i-1]);
            System.out.print(" ");
        }
        System.out.println();
    }
}
