package dev.kyuelin.progcreek;

/**
 * Created by linken on 4/13/16.
 */
public class LengthOfLastWord {
    public static int getLengthOLW(String s) {
        int l = s.length();
        int len =0;
        boolean found = false;
        while (l>=0) {
            char c = s.charAt(l-1);
            if ((c >= 'a' &&  c<='z' )|| (c >='A' && c <='Z')) {
                len++;
                found = true;
            }
            else if (found == true) {
                return len;
            }
            l--;
        }
        return len;
    }

    public static void main(String[] args) {
        String input ="random_list(list_length,values_range)";
        System.out.println(getLengthOLW(input));

    }
}
