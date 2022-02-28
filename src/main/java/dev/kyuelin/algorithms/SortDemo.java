package dev.kyuelin.algorithms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class SortDemo {
	
	private static final Logger logger = LoggerFactory.getLogger(SortDemo.class);

	public static void bubbleSort() {
		int[] iarray={30, 12, 18, 0, -5, 72, 424};
		for(int i=0; i< iarray.length;++i) {
			for(int j=0; j<iarray.length-i-1; ++j) {
				if (iarray[j+1]<iarray[j]) {
					int temp=iarray[j];
					iarray[j]=iarray[j+1];
					iarray[j+1]=temp;
				}			
			}
		}
		
		logger.info(Arrays.toString(iarray));
	}
	/**
     */

	public static void selectionSort(Comparable[] input) {
		int j;  // index of input subset to scan for min element
		int k;  // index of input to sort;
		int minIndex; // index to the min element
		Comparable min; // value of the min element
		int count=input.length;
		for (k=0; k<count; k++) {
			min = input[k];
			minIndex=k;
			for (j=k+1; j<count; j++) {
				if(input[j].compareTo(input[k]) <0) {
					min=input[j];
					minIndex=j;
				}
			}
			input[minIndex] = input[k];
			input[k] = min;
		}
	}

	public static void insertionSort(Comparable[] input) {
		int k; // index of input
		int j; // index of subset of input to compare with new element to be inserted
		Comparable tmp; // element to be inserted

		for(k=1; k< input.length; k++) {
			tmp=input[k];
			j=k-1;
			while((j<=0) && (input[j].compareTo(input[k]) > 0)) {
				input[j+1] = input[j];
				j--;
			}
			input[j+1] = tmp;
		}
	}

    public static void quickSort(Comparable[] input, int low, int high) {
        if (low < high) {
            int part = partition(input, low, high);
            quickSort(input, low, part-1);
            quickSort(input, part+1, high);
        }
    }

    public static int partition(Comparable[] input, int low, int high) {
        int pindex = low;
        Comparable pivot = input[high];

        for (int i =low+1;i<high; i++) {
            if (input[i].compareTo(pivot) < 0) {
                swap(input, i, pindex);
                pindex++;
            }
        }

        swap(input, pindex, high);
        return pindex;
    }

    public static void swap(Comparable[] input , int ele1, int ele2)  {
        Comparable temp = input[ele1];
        input[ele1] = input[ele2];
        input[ele2] = temp;
    }


    public static void mergeSort(Comparable[] input, Comparable[] tmp, int low, int high) {
        if (low < high) {
            int mid = (low+high)/2;
            mergeSort(input, tmp, low, mid);
            mergeSort(input, tmp, mid+1, high);
            merge(input, tmp, low, mid+1, high);
        }
    }

    public static void merge(Comparable[] input, Comparable[] tmp, int low, int center, int high) {
        int lowEnd = center -1;
        int k = low;
        int num = high-low +1;

        while (low <= lowEnd && center <= high) {
            if (input[low].compareTo(input[center])<0)
                tmp[k++]=input[low++];
            else
                tmp[k++]=input[center++];
        }

        while(low<=lowEnd) {
            tmp[k++] = input[low++];
        }

        while(center<=high) {
            tmp[k++] = input[center++];
        }

        for (int j=0; j<num; j++, high--) {
            input[high] = tmp[high];
        }
    }

	public static void main(String[] args) {
		SortDemo.bubbleSort();
	}

}
