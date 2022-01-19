package dev.kyuelin.progcreek;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by linken on 4/10/16.
 */
public class LongestValidParentheses {
    public static int getMaxLength(String input) {
        int maxlength=0;
        int tmplength=0;
        Stack<Character> tmpStack = new Stack<>();
        Map<Character,Character> cmap = new HashMap<>();

        cmap.put('{', '}');
        cmap.put('(', ')');
        cmap.put('[', ']');

        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);

            if(cmap.keySet().contains(c)) {
                if(tmpStack.isEmpty()) {
                    tmplength++;
                    tmpStack.add(c);
                }
                else {
                    tmplength=1;
                }
            }
            else if (cmap.values().contains(c)) {
                if (!tmpStack.isEmpty()) {
                    char c1 = tmpStack.peek();
                    if (c == cmap.get(c1)) {
                        tmplength++;
                        maxlength = Math.max(maxlength, tmplength);
                        tmpStack.pop();
                    }
                }
                else {
                    tmplength=0;
                }
            }
        }

        return maxlength;
    }


    public static void main(String[] args) {
        String s = "{{}}{{{}{}{}{}{}}{{}{}{}{}{}}";
        System.out.println(LongestValidParentheses.getMaxLength(s));

    }
}
