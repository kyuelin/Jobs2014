package dev.kyuelin.hackerrank;

import java.util.Scanner;

/**
 * Created by linken on 10/31/15.
 */
public class StringIntro {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String A = scan.nextLine();
        String B = scan.nextLine();

        System.out.println(A.length() + B.length());
        System.out.println((A.compareTo(B) > 0) ? "Yes" : "No");
        System.out.println(A.replace(A.charAt(0), Character.toUpperCase(A.charAt(0))) + " " + B.replace(B.charAt(0), Character.toUpperCase(B.charAt(0))));
    }
}
