package dev.kyuelin.progcreek;

import java.util.Arrays;

/**
 * Created by linken on 6/7/16.
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] input = new int[] {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(input));
        //shiftRotate(input, 3);
        bubbleRotate(input, 3);
        //input = naturalRotate(input, 3);
        System.out.println(Arrays.toString(input));
    }

    public static int[] naturalRotate(int[] arr, int order) {
        int res[] = new int[arr.length];
        for(int i = 0; i < order; i++) {
            res[i] = arr[arr.length-order+i];
        }

        int j=0;
        for (int i=order; i<arr.length; i++) {
            res[i] = arr[j++];
        }
        return res;
    }

    public static void shiftRotate(int[] arr, int order) {
        for (; order>0; order--) {
            int shift = arr[arr.length-1];
            for (int i=arr.length-2; i>=0; i--) {
                arr[i+1] =arr[i];
            }
            arr[0]=shift;
        }
    }

    public static void bubbleRotate(int[] arr, int order) {
        if (arr == null || order <0)
            return;
        for(;order>0; order--){
            for (int i=arr.length-1; i>0; i--) {
                int temp = arr[i];
                arr[i]=arr[i-1];
                arr[i-1]=temp;
            }
        }
    }
}
