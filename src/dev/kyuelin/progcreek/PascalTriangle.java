package dev.kyuelin.progcreek;

import java.util.Arrays;

/**
 * Created by kennethlin on 4/26/16.
 */
public class PascalTriangle {
    public static void pascal (int rows) {
        int [][] res = new int [rows][rows];
        res[0][0] = 1;
        for (int i = 1 ; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if(j == 0) {
                    res[i][j] = res[i-1][j];
                }
                else {
                    res[i][j] = res[i-1][j] + res[i-1][j-1];
                }
            }
        }

        for (int i=0; i< rows; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
    public static void main(String[] args) {
        pascal(5);
    }
}
