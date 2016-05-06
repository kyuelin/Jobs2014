package dev.kyuelin.utilities;

import java.util.*;

/**
 * Created by kennethlin on 4/25/16.
 */
public class IntGenerator {
    public static int[] genIntArray(int size_range, int value_range) {
        Random randgen = new Random(System.nanoTime());
        int size = randgen.nextInt(size_range);
        int[] output = new int[size];
        for(int i=0; i<size;i++) {
            output[i] = randgen.nextInt(value_range);
        }
        return output;
    }
    public static int[] genFixedSizeIntArray(int size, int value_range) {
        Random randgen = new Random(System.nanoTime());
        int[] output = new int[size];
        for(int i=0; i<size;i++) {
            output[i] = randgen.nextInt(value_range);
        }
        return output;
    }
    public static int[] genUniqIntArray(int size_range, int value_range) {
        Random randgen = new Random(System.nanoTime());
        int size = randgen.nextInt(size_range);
        if (value_range < size) value_range=size;

        Set<Integer> numSet = new HashSet<>();
        while(numSet.size()<size) {
            int num = randgen.nextInt(value_range);
            while(numSet.contains(num)) num = randgen.nextInt(value_range);
            numSet.add(num);
        }
        int[] intArray = new int[size];
        int i = 0;
        for (Object o :  numSet.toArray()) {
            intArray[i++] = ((Integer) o).intValue();
        }
        return intArray;
    }
    public static int[][] genIntMatrix(int row_range, int column_range, int value_range) {
        Random random = new Random(System.nanoTime());
        int row = random.nextInt(row_range);
        int col = random.nextInt(column_range);
        int [][] intMat = new int[row][col];
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                intMat[i][j] = random.nextInt(value_range);
            }
        }
        return intMat;
    }

    public static void printMatrix(int[][] input) {
        for(int i=0; i<input.length; i++) {
            System.out.println(Arrays.toString(input[i]));
        }
    }

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(genUniqIntArray(23,100)));
        /*
        int[][] mat = genIntMatrix(9,13,2);
        for (int i=0; i<mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
        */
        int[] wb = genUniqIntArray(6,70);
        while(wb.length != 5) {
            wb = genUniqIntArray(6,70);
        }
        Arrays.sort(wb);
        System.out.println(Arrays.toString(wb));
        System.out.println((new Random(System.nanoTime())).nextInt(27));
    }

}
