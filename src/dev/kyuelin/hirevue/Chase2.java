package dev.kyuelin.hirevue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;

/**
 * Created by linken on 7/3/16.
 */
public class Chase2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = in.readLine()) != null) {
            //System.out.println(s);
            isOverlap1(s);
            //isOverlap2(s);
        }
    }

    /*
-1 -1 2 2 1 1 1 1
true
1 1 1 1 -1 -1 2 2
true
-1 -1 1 1 1 1 1 1
false
1 1 1 1 -1 -1 3 3
true
1 1 1 1 -1 -1 3 1
false
1 1 1 1 -1 -1 2 1
false
0 0 1 1 -1 -1 1 1
true
     */

    // bad solution
    public static void isOverlap2(String input) {
        String sa[] = input.split(" ");
        int x1 = Integer.valueOf(sa[0]);
        int y1 = Integer.valueOf(sa[1]);
        int w1 = Integer.valueOf(sa[2]);
        int h1 = Integer.valueOf(sa[3]);
        int x2 = Integer.valueOf(sa[4]);
        int y2 = Integer.valueOf(sa[5]);
        int w2 = Integer.valueOf(sa[6]);
        int h2 = Integer.valueOf(sa[7]);

        int x1c = x1+w1/2;
        int y1c = y1+h1/2;
        int x2c = x2+w2/2;
        int y2c = x2+h2/2;

        double distance = Math.sqrt(Math.pow(x1c-x2c,2) + Math.pow(y1c-y2c, 2));
        double max_dis = (Math.sqrt(Math.pow(w1,2) +  Math.pow(h1,w1)) + Math.sqrt(Math.pow(w2,2)+ Math.pow(h2,w2)))/2;
        if (distance <= max_dis) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }

    }

    public static void isOverlap1(String input) {
        String sa[] = input.split(" ");
        int w1 = Integer.valueOf(sa[2]);
        int h1 = Integer.valueOf(sa[3]);
        int w2 = Integer.valueOf(sa[6]);
        int h2 = Integer.valueOf(sa[7]);

        int largeX1=0, largeX2=0, largeY1=0, largeY2=0;
        int smallX1=0, smallX2=0, smallY1=0, smallY2=0;
        if (w1*h1 >= w2*h2) {
            largeX1 = Integer.valueOf(sa[0]);
            largeX2 = largeX1 + w1;
            largeY1 = Integer.valueOf(sa[1]);
            largeY2 = largeY1 + h1;
            smallX1 = Integer.valueOf(sa[4]);
            smallX2 = smallX1 + w2;
            smallY1 = Integer.valueOf(sa[5]);
            smallY2 = smallY1 + h2;
        }
        else {
            largeX1 = Integer.valueOf(sa[4]);
            largeX2 = largeX1 + w2;
            largeY1 = Integer.valueOf(sa[5]);
            largeY2 = largeY1 + h2;
            smallX1 = Integer.valueOf(sa[0]);
            smallX2 = smallX1 + w1;
            smallY1 = Integer.valueOf(sa[1]);
            smallY2 = smallY1 + h1;
        }

        if ( ((largeX1 <= smallX1 && smallX1 <= largeX2) || (largeX1 <= smallX2 && smallX2 <= largeX2))
                &&
                (largeY1 <= smallY1 && smallY1 <= largeY2) || (largeY1<= smallY2 && smallY2 <= largeY2))
            System.out.println("true");
        else {
            System.out.println("false");
        }

    }
}
