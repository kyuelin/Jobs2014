package dev.kyuelin.hackerrank;

import java.util.Scanner;

/**
 * Created by linken on 11/1/15.
 */
public class StringReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.nextLine();
        boolean flag=true;
        int half_len = (A.length()-1)/2;
        for (int i=0; i <=half_len; i++) {
            if (A.charAt(i) != A.charAt(A.length()-1-i)) {
                flag=false;
                break;
            }
        }
        if (flag == true) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
