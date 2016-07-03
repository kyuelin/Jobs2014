package dev.kyuelin.crackingcoding;

import java.math.BigDecimal;

/**
 * Created by linken on 12/20/15.
 */
public class Temp {
    public static int bitCount(int input)
    {
        if (input<1) return 0;
        return input%2+bitCount(input/2);
    }

    public static void main(String[] args) {
        double d1 = 2.15;
        double d2 = 1.10;
        System.out.println("double : " + (d1-d2));
        System.out.println("BigDecimal : " + (new BigDecimal("2.15")).subtract(new BigDecimal("1.10")));

        System.out.println(bitCount(17));
    }
}
