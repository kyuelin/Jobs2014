package dev.kyuelin.leetcode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ArrayReOrderredByDefinedArray {

    // arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]

    public  static int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, AtomicInteger> integerHashMap = new HashMap<>();

        for(int i: arr1) {
            if (integerHashMap.containsKey(i)) integerHashMap.get(i).incrementAndGet();
            else integerHashMap.put(i,new AtomicInteger(1));
        }

        List<Integer> arr4 = new ArrayList<>();
        HashSet<Integer> integerHashSet = new HashSet<Integer>();
        for(int i2: arr2) {
            if(integerHashMap.containsKey(i2)) {
                int i3=0;
                while(i3++ < integerHashMap.get(i2).intValue()) {
                    arr4.add(i2);
                }
            }
            integerHashSet.add(i2);
        }

        List<Integer> arr3 = new ArrayList<>();
        for(int i6: arr1) {
            if(!integerHashSet.contains(i6))
                arr3.add(i6);
        }

        Collections.sort(arr3);

        arr4.addAll(arr3);

        int[] arr5 = new int[arr4.size()];
        for(int i7=0; i7<arr4.size(); i7++) {
            arr5[i7] = arr4.get(i7);
        }
        return arr5;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};

        int[] arr3 = ArrayReOrderredByDefinedArray.relativeSortArray(arr1, arr2);

        System.out.println(Arrays.toString(arr3));
    }
}
