package dev.kyuelin.progcreek;

import dev.kyuelin.CrackingCoding.IntervalDemo;

/**
 * Created by kennethlin on 4/26/16.
 */
public class CompareVersionNumber {
    public static int compareVersion(String v1, String v2) {
        int minlen = Math.min(v1.length(), v2.length());
        int i = 0;
        int j = 0;
        while (i<minlen) {

            if (v1.charAt(i) == '.' && v2.charAt(i) == '.' || i == minlen-1) {
                int i1 = Integer.valueOf(v1.substring(j, i));
                int i2 = Integer.valueOf(v2.substring(j, i));
                if (i1 != i2) {
                    return i1 - i2;
                } else {
                    i++;
                    j = i;
                }
            }
            else if (v1.charAt(i) != '.' && v2.charAt(i) != '.') {
                i++;
            }
            else {
                if (v2.charAt(i) != '.') return 1; // v2 longer than v1 (>)
                else return -1;
            }

        }
        return (v1.length()-v2.length());
    }

    public static int compareVersion2(String v1, String v2) {
        int minlen = Math.min(v1.length(), v2.length());
        int i = 0;
        while (i < minlen) {
            char c1 = v1.charAt(i);
            char c2 = v2.charAt(i);
            if (c1==c2) i++;
            else {
                if (c1 == '.' || c2 == '.') {
                    if (c1 == '.') return -1;
                    else return 1;
                }
                else {
                    return c1-c2;
                }
            }
        }
        return v1.length()-v2.length();
    }

    public static void main(String[] args) {
        String s1 = "12.1";
        String s2 = "12.10";
        //System.out.println(compareVersion(s1,s2));
        System.out.println(compareVersion2(s1,s2));

    }
}
