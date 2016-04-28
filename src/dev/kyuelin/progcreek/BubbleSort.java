package dev.kyuelin.progcreek;

import java.util.Arrays;

/**
 * Created by linken on 4/13/16.
 */
public class BubbleSort {
    public static void bubbleSort(int[] i) {
        boolean flag = true;
        while (flag) {
            flag=false;
            for(int j=0;j<i.length-1;j++) {
                if(i[j]>i[j+1]) {
                    int t = i[j+1];
                    i[j+1] = i[j];
                    i[j]=t;
                    flag=true;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] input = {22, 23, 14, 8, 16, 29, 19, 26, 5, 9};
        System.out.println(Arrays.toString(input));
        bubbleSort(input);
        System.out.println(Arrays.toString(input));
    }
}
