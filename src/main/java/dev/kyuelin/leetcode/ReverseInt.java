package dev.kyuelin.leetcode;

import java.math.BigInteger;

public class ReverseInt {

    public int reverse(int x) {
        if (x == 0) return x;
        boolean positive = true;
        if (x < 0) {
            positive = false;
            x *= -1;
        }


        String xs = new Double(x).toString();
        StringBuilder sb = new StringBuilder();
        for (int i = xs.length() - 1; i >= 0; i--) {
            sb.append(xs.charAt(i));
        }
        double r = Double.valueOf(sb.toString()).doubleValue();
        if (positive == false) {
            r *= -1;
        }

        if (r < Math.pow(-2, 31) || r > Math.pow(2, 31) - 1)
            return 0;

        return (int)r;
    }


    public static void main(String[] args) {
        ReverseInt reverseInt = new ReverseInt();
        System.out.println(reverseInt.reverse(1534236469));
    }
}
