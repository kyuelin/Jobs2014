package dev.kyuelin.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by linken on 11/1/15.
 */
public class StringAnagrams {
    static boolean isAnagram(String A, String B) {
        char[] aArr = A.toLowerCase().toCharArray();
        Arrays.sort(aArr);
        String aStr = String.valueOf(aArr);
        char[] bArr = B.toLowerCase().toCharArray();
        Arrays.sort(bArr);
        String bStr = String.valueOf(bArr);
        return aStr.compareTo(bStr) == 0;
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        boolean ret=isAnagram(A,B);
        if(ret)System.out.println("Anagrams");
        else System.out.println("Not Anagrams");

    }
}
