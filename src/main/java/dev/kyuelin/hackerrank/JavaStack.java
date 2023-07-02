package dev.kyuelin.hackerrank;

import java.util.*;

/**
 * Created by linken on 6/17/16.
 */
public class JavaStack {
    public static boolean validate(String input, Map<Character, Character> dict) {
        Stack<Character> s = new Stack<>();
        int i=0;
        while(i<input.length()) {
            char c = input.charAt(i);
            if(dict.containsKey(c)) {
                s.push(c);
            }
            else {
                if (s.empty()) return false;
                char left = s.pop();
                if (dict.get(left) != c) {
                    return false;
                }
            }
            i++;
        }
        return s.empty();
    }

    public static void main(String []argh)
    {
        Map<Character, Character> pmap = new HashMap<Character, Character>();
        pmap.put('(',')');
        pmap.put('[',']');
        pmap.put('{','}');

        Scanner sc = new Scanner(System.in);

        List<String> results = new ArrayList<String>();

        while (sc.hasNext()) {
            String input=sc.next();
            results.add(String.valueOf(validate(input, pmap)));
        }
        for(String s: results) {
            System.out.println(s);
        }

    }
}
