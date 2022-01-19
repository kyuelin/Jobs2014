package dev.kyuelin.hackerrank;

import java.util.Scanner;

/**
 * Created by linken on 10/30/15.
 */
public class DataByteSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            try {
                long x = sc.nextLong();
                System.out.println(x + " can be fitted in:");
                if (x >= -Math.pow(2, 8 - 1) && x <= (Math.pow(2, 8 - 1) - 1)) System.out.println("* byte");
                if (x >= -Math.pow(2, 16 - 1) && x <= (Math.pow(2, 16 - 1) - 1)) System.out.println("* short");
                if (x >= -Math.pow(2, 32 - 1) && x <= (Math.pow(2, 32 - 1) - 1)) System.out.println("* int");
                if (x >= -Math.pow(2, 64 - 1) && x <= (Math.pow(2, 64 - 1) - 1)) System.out.println("* long");
                //Complete the code
            } catch (Exception e) {
                System.out.println(sc.next() + " can't be fitted anywhere.");
            }

        }
    }
}
