package dev.kyuelin.codejam;

import java.util.Scanner;

/**
 * Created by linken on 12/18/15.
 */
public class ReverseWordCase {
    public static String reverse_head(String input) {
        if(input.length() == 1) return input;
        return input.charAt(input.length()-1)+reverse_head(input.substring(0, input.length() - 1));
    }//

    public static String reverse_tail(String input) {
        if(input.length()==1) return input;
        return reverse_tail(input.substring(1)) + input.charAt(0);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String casesStr=scan.nextLine();
        int cases =  Integer.parseUnsignedInt(casesStr);
        for(int i =0; i<cases; i++) {
            String test = scan.nextLine();
            System.out.println(reverse_head(test));
            System.out.println(reverse_tail(test));
        }
    }
}
