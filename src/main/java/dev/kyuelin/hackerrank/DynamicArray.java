package dev.kyuelin.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by linken on 6/18/16.
 */
public class DynamicArray {
    static int lastAns = 0;
    static ArrayList<Integer> results = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int Q = scan.nextInt();
        scan.nextLine();
        ArrayList<Integer> S[] = new ArrayList[N];
        for (int n=0; n<N; n++) {
            S[n]=new ArrayList<>();
        }
        for (;Q>0;Q--) {
            int t = scan.nextInt();
            int x = scan.nextInt();
            int y = scan.nextInt();

            getAnswer(N, S, t, x, y);
            //scan.next();
        }

        for (Integer s:results) {
            System.out.println(s);
        }

    }

    private static void getAnswer(int n, ArrayList<Integer>[] S, int t, int x, int y) {
        int seq = (x^lastAns)%n;
        switch(t) {
            case 1:
                S[seq].add(y);
                break;
            case 2:
                int value = S[seq].get(y%S[seq].size());
                lastAns=value;
                results.add(lastAns);
                break;
        }
        //System.out.format("n=%d, t=%d, x=%d, y=%d, seq=%d, lastAns=%d\n", n,t,x,y, seq, lastAns);
        for(ArrayList<Integer> ai:S) {
            System.out.println(Arrays.toString(ai.toArray()));
        }
    }
}
