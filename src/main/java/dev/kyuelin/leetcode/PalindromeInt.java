package dev.kyuelin.leetcode;

public class PalindromeInt {

    public PalindromeInt() {};

    public static void main(String[] args) {
	// write your code here
    }

    public boolean isPalindrome (int x) {
        if (x<0) return false;
        if (x<10) return true;
        if (x < -1 * Math.pow(2,31) || x > (Math.pow(2,31)-1) ) return false;

        String temp = String.valueOf(x);

        // xxx xxx
        // xxx x xxx
        int ilen = temp.length();
        int ilenindex = ilen/2;
        for (int i=0; i<ilenindex; i++) {

            // ilenindex = 3
            // 6
            // i, 0, 1, 2
            // ilen-i, 5, 4, 3
            // 7
            // i, 0, 1, 2
            // ilen-i, 6, 5, 4
            if (temp.charAt(i) != temp.charAt(ilen-i-1))
                return false;
        }
        return true;
    }
}
