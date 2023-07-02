package dev.kyuelin.hackerrank;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by linken on 6/18/16.
 */
public class BalancedParentheses {

    static HashMap<Character, Character> pmap = new HashMap<>();

    public static void main(String[] args) {
        pmap.put('(',')');
        pmap.put('[',']');
        pmap.put('{','}');
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        scan.nextLine();
        boolean[] results = new boolean[T];
        int i=0;
        while(i < T) {
            String input = scan.nextLine();
            results[i]=checkBalanced(input);
            i++;
        }
        for(boolean b:results) {
            if (b) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }

    private static boolean checkBalanced(String input) {
        Stack<Character> s = new Stack<>();
        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            if (pmap.containsKey(c)) {
                s.push(c);
            }
            else if (s.empty()) {
                return false;
            }
            else if (c != pmap.get(s.pop())) {
                return false;
            }
        }
        return s.empty();
    }
}
