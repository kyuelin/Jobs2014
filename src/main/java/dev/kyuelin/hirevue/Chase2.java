package dev.kyuelin.hirevue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
            isOverlap2(s);
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
1 1 1 1 -1 -1 2 1
true
     */

    public static void isOverlap2(String input) {
        String sa[] = input.split(" ");
        int xbl1 = Integer.valueOf(sa[0]);
        int ybl1 = Integer.valueOf(sa[1]);
        int w1 = Integer.valueOf(sa[2]);
        int h1 = Integer.valueOf(sa[3]);
        int xbl2 = Integer.valueOf(sa[4]);
        int ybl2 = Integer.valueOf(sa[5]);
        int w2 = Integer.valueOf(sa[6]);
        int h2 = Integer.valueOf(sa[7]);

        int xtr1 = xbl1 + w1;
        int ytr1 = ybl1 + h1;
        int xtr2 = xbl2 + w2;
        int ytr2 = ybl2 + h2;

        if (xbl1 > xtr2 || xtr1 < xbl2) {
            System.out.println("false");
        }
        else if (ybl1 > ytr2 || ytr1 < ybl2) {
            System.out.println("false");
        }
        else {
            System.out.println("true");
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
