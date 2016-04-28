package dev.kyuelin.progcreek;

/**
 * Created by linken on 4/12/16.
 */
public class ValidPalindrome {
    public static boolean isValidPalindrome(String input) {
        input = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = input.length()-1;
        while (left <= right) {
            if (input.charAt(left) != input.charAt(right)) return false;
            left++ ; right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";

        System.out.println(isValidPalindrome(str));
    }
}
