package dev.kyuelin.progcreek;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by kennethlin on 4/25/16.
 */
public class SimplifyPath {
    public static String simplify(String path) {
        Stack<String> stack = new Stack();

        StringTokenizer tokenizer = new StringTokenizer(path, "/");

        while(tokenizer.hasMoreElements()) {
            String s = tokenizer.nextToken();
            if (s.compareTo(".") != 0 && !s.isEmpty()) {
                if (s.compareTo("..") == 0) {
                    stack.pop();
                }
                else {
                    stack.push(s);
                }
            }

        }

        StringBuilder builder = new StringBuilder();
        while (!stack.empty()) {
            builder.append('/');
            builder.append(stack.pop());
        }
        return builder.toString();
    }
}
