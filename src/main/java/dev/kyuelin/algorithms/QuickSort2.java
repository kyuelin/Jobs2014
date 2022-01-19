package dev.kyuelin.algorithms;

/**
 * Created by linken on 12/19/15.
 */
public class QuickSort2 {
    public static void quickSort(int[] arr, int low, int high) {
        if (low<high) {
            int part = partition(arr, low, high);
            quickSort(arr, low, part-1);
            quickSort(arr, part + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pindex=low-1;
        int pivot = arr[high];
        for(int i=low; i<high; i++) {
            if(arr[i] <= pivot) {
                pindex++;
                swap(arr, i, pindex);
            }
        }
        pindex++;
        swap(arr, pindex, high);
        return pindex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}

class QuickSortTest
{
    public static void main(String[] args)
    {
        QuickSort2 qsort = new QuickSort2();
        int[] array = {5, 4, 7, 2, 1, 9, 3, 6, 10, 8};

        System.out.print("Original  Array : ");
        for(int i=0; i<array.length;i++)
        {
            System.out.print(array[i] + " ");
        }

        int length = array.length;

        qsort.quickSort(array, 0, length-1);

        System.out.print("Sorted  Array : ");
        for(int i=0; i<array.length;i++)
        {
            System.out.print(array[i] + " ");
        }
    }
}
