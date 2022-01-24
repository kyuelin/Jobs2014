package dev.kyuelin.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> results = new ArrayList();
        int mdigit = new Integer(low).toString().length(); //3
        int xdigit = new Integer(high).toString().length(); //3
        System.out.format("%d, %d\n", mdigit, xdigit);

        for (int i = mdigit; i <= xdigit; i++) {
            List<Integer> numbers = makeNumber(i);
            for (Integer number : numbers) {
                System.out.println(number);
                if (number <= high && number >= low) {
                    results.add(number);
                }
            }
        }
        return results;
    }

    public List<Integer> makeNumber(int digit) {
        List<Integer> results = new ArrayList();
        int begin = 1; //
        int end = 10 - digit; //7
        for (int j = begin; j <= end; j++) {
            int number = 0;
            int j1 = j;
            for (int i = digit - 1; i >= 0; i--) {
                number += j1 * Math.pow(10, i);
                j1++;
            }
            System.out.println(number);
            results.add(new Integer(number));
        }
        return results;
    }

    public static void main(String[] args) {
        SequentialDigits sequentiamdigits = new SequentialDigits();
        int low = 1000;
        int high = 13000;
        List<Integer> results = sequentiamdigits.sequentialDigits(low, high);

        System.out.println(results);

    }
}