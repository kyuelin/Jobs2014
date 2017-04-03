package dev.kyuelin.hackerrank;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by linken on 11/6/15.
 */
public class JavaBigDec {
    public static void main(String[] argh) {
        //Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n + 2];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }

        //Write your code here
        Map<BigDecimal, String> bigDecimalMap = new HashMap<>();
        List<BigDecimal> bigDecimalList = new ArrayList<>();
        for(int k=0; k < n; k++) {
            bigDecimalMap.put(new BigDecimal(s[k]), s[k]);
            bigDecimalList.add(new BigDecimal(s[k]));
        }

        Collections.sort(bigDecimalList);

        int j=n-1;
        for(BigDecimal value : bigDecimalList) {
            s[j--] = bigDecimalMap.get(value);
        }

        //Output
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }

    }

}
