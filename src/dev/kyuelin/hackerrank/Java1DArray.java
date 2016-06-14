package dev.kyuelin.hackerrank;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by linken on 6/10/16.
 */
public class Java1DArray {
    public static void playGame(int[] input, int m) {
        //int pos = 0;
        //System.out.println(Arrays.toString(input));
        //System.out.println(m);
        if (checkWin(input, 0, m)) {
            System.out.println("YES");
        } else {
            System.out.println(("NO"));
        }
    }

    public static boolean checkWin(int[] input, int pos, int m) {
        Queue<Integer> iq = new LinkedList<>();
        iq.add(pos);
        //System.out.println(Arrays.toString(iq.toArray()));
        while (!iq.isEmpty()) {
            int curr = iq.poll();
            if (curr >= input.length) return true;
            if (checkZero(input, curr, m, iq)) return true;
            if (checkZero(input, curr, 1, iq)) return true;
            if (checkZero(input, curr, -1, iq)) return true;
            //System.out.println(Arrays.toString(iq.toArray()));
        }
        return false;
    }

    public static boolean checkZero(int[] input, int curr, int off, Queue<Integer> iq) {
        int newpos = curr+off;
        if (newpos >= input.length) return true;
        if ( newpos < input.length && newpos >= 0 && input[newpos] == 0) {
            iq.add(newpos);
            input[newpos] = 1;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases;
        cases = Integer.valueOf(scan.nextLine());
        for (; cases > 0; cases--) {
            int n, m;
            String parameters = scan.nextLine();
            int i = 0;
            for (; i < parameters.length() && parameters.charAt(i) != ' '; i++) ;
            n = Integer.valueOf(parameters.substring(0, i));
            m = Integer.valueOf(parameters.substring(i + 1, parameters.length()));

            int[] input = new int[n];
            int k = 0;
            String arr = scan.nextLine();
            int begin = 0;
            System.out.println(arr.length());
            for (int j = 0; j < arr.length(); j++) {
                if (arr.charAt(j) == ' ') {
                    //System.out.print(begin);
                    //System.out.println(j);
                    input[k] = Integer.valueOf(arr.substring(begin, j));
                    //System.out.println(input[k]);
                    k++;
                    begin = j + 1;
                }
            }
            input[k] = Integer.valueOf(arr.substring(begin, arr.length()));

            //System.out.println(Arrays.toString(input));
            playGame(input, m);
        }
    }
}
