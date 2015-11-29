package dev.kyuelin.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by linken on 11/6/15.
 */
public class JavaBigInt {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        BigInteger bigInteger1 = scan.nextBigInteger();
        BigInteger bigInteger2 = scan.nextBigInteger();

        System.out.println(bigInteger1.add(bigInteger2));
        System.out.println(bigInteger1.multiply(bigInteger2));

    }
}
