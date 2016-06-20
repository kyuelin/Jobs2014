package dev.kyuelin.hackerrank;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by linken on 6/19/16.
 */
public class LargestRectangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        int[] h = new int[N];
        int i=0;
        while(i<N) {
            h[i++]=scan.nextInt();
        }

        //System.out.println(findLarget(h));
        System.out.println(findLargest2(h));
    }

    private static int findLargest2(int[] h) {
        Stack<Integer> s = new Stack<>();

        int max_area = 0;
        int tp;
        int top_area;

        int i=0;
        while(i<h.length) {
            if(s.empty() || h[s.peek()] <= h[i])
                s.push(i++);
            else {
                tp = s.peek();
                s.pop();
                top_area = h[tp]*(s.empty()?i:i-s.peek()-1);

                max_area = Math.max(max_area, top_area);
            }
        }

        while(!s.empty()) {
            tp = s.peek();
            s.pop();
            top_area = h[tp]*(s.empty() ? i : i-s.peek()-1);
            max_area = Math.max(max_area, top_area);
        }

        return max_area;

    }

    private static int findLarget(int[] h) {
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<h.length; i++) {
            int j = i+1;
            int minh = h[i];
            while(j<h.length) {
                minh=Math.min(h[j],minh);
                largest = Math.max(largest, (j-i+1)*minh);
                j++;
                //System.out.print(largest + " ");
            }
            //System.out.println();
        }
        return largest;
    }
}
