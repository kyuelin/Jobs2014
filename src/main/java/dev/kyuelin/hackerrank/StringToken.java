package dev.kyuelin.hackerrank;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by linken on 11/3/15.
 */
public class StringToken {
    public static void main(String[] args)
    {
        //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
        Scanner scan = new Scanner(System.in);
        String s=scan.nextLine();
        StringTokenizer st = new StringTokenizer(s," !,?._'@",false);
        System.out.println(st.countTokens());
        while(st.hasMoreElements()) {
            System.out.println(st.nextElement());
        }

    }
}
