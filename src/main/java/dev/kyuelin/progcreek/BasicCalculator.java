package dev.kyuelin.progcreek;

import java.util.Stack;

/**
 * Created by kennethlin on 4/28/16.
 */
public class BasicCalculator {
    public static int calculate(String input) {
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();
        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            if(c >= '0' && c <= '9') {
                numbers.push(Integer.valueOf(String.valueOf(c)));
            }
            else if (c == ')') {
                if (operators.isEmpty()) {
                    continue;
                }
                char o = operators.pop();
                int i2 = numbers.pop();
                int i1 = numbers.pop();
                switch(o) {
                    case '+':
                        numbers.push(i1+i2);
                    case '-':
                        numbers.push(i1-i2);
                }
            }
            else if (c == '+' || c == '-'){
                operators.push(c);
            }
        }
        while (!operators.isEmpty()) {
            char o = operators.pop();
            int i2 = numbers.pop();
            int i1 = numbers.pop();
            switch(o) {
                case '+':
                    numbers.push(i1+i2);
                    break;
                case '-':
                    numbers.push(i1-i2);
            }
        }

        return numbers.pop();
    }

    public static void main(String[] args) {
        String input = "(1-(4-5))";//"(1)" ; //"1 + 1" ;
        System.out.println(input + "=" + calculate(input));
    }
}
