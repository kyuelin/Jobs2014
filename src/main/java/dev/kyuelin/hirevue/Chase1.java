package dev.kyuelin.hirevue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by linken on 7/3/16.
 */
public class Chase1 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = in.readLine()) != null) {
            String[] sa = s.split(" ");
            int i1 = Integer.parseInt(sa[0],2);
            int i2 = Integer.parseInt(sa[1],2);
            System.out.println(Integer.toBinaryString(i1+i2));
        }
    }
}
