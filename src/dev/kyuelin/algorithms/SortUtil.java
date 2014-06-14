package dev.kyuelin.algorithms;

import java.util.ArrayList;
import java.util.Random;

public class SortUtil {

	private static int threshold = 5;

	/**
	 * This is the public driver method for mergesort which performs a mergesort
	 * on the generic ArrayList given as input and switches to insertionsort
	 * when array size reaches a certain threshold.
	 * 
	 * @param array
	 */
	public static <T extends Comparable<? super T>> void mergesort(
			ArrayList<T> array) {
		if (array == null || array.size() <= 1)
			return;
		if (array.size() <= threshold) {
			insertionSort(array, 0, array.size());
			return;
		}

		ArrayList<T> tmpArray = new ArrayList<T>(array.size());
		T val = null;
		for (int g = 1; g <= array.size(); g++)
			tmpArray.add(val);
		mergeSort(array, tmpArray, 0, array.size() - 1);

	}

	/**
	 * Internal mergesort method that makes recursive calls.
	 * 
	 * @param a
	 *            an array of Comparable items.
	 * @param tmpArray
	 *            an array to place the merged result.
	 * @param left
	 *            the left-most index of the subarray.
	 * @param right
	 *            the right-most index of the subarray.
	 */
	private static <T extends Comparable<? super T>> void mergeSort(
			ArrayList<T> a, ArrayList<T> tmpArray, int left, int right) {

		if ((right - left) < threshold) {
			insertionSort(a, left, right);
		} else if (left < right) {

			int center = (left + right) / 2;
			mergeSort(a, tmpArray, left, center);
			mergeSort(a, tmpArray, center + 1, right);
			merge(a, tmpArray, left, center + 1, right);
		}
	}

	/**
	 * Merges the array and the temparray together after they have been sorted.
	 * 
	 * @param <T>
	 * @param a
	 *            the array to be sorted
	 * @param tmpArray
	 *            the temp array to put sorted items in while sorting
	 * @param leftPos
	 * @param rightPos
	 * @param rightEnd
	 */
	private static <T extends Comparable<? super T>> void merge(ArrayList<T> a,
			ArrayList<T> tmpArray, int leftPos, int rightPos, int rightEnd) {
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos + 1;

		// Main loop
		while (leftPos <= leftEnd && rightPos <= rightEnd)
			if (a.get(leftPos).compareTo(a.get(rightPos)) <= 0)
				tmpArray.set(tmpPos++, a.get(leftPos++));
			else
				tmpArray.set(tmpPos++, a.get(rightPos++));

		while (leftPos <= leftEnd)
			// Copy rest of first half
			tmpArray.set(tmpPos++, a.get(leftPos++));

		while (rightPos <= rightEnd)
			// Copy rest of right half
			tmpArray.set(tmpPos++, a.get(rightPos++));
		// Copy tmpArray back
		for (int i = 0; i < numElements; i++, rightEnd--)
			a.set(rightEnd, tmpArray.get(rightEnd));

	}

	/**
	 * Driver method for quicksort
	 * 
	 * @param array
	 */
	public static <T extends Comparable<? super T>> void quicksort(
			ArrayList<T> array) {
		if (array == null || array.size() <= 1)
			return;
		quicksort(array, 0, array.size() - 1);
	}

	/**
	 * This method performs a quicksort (median of 3 pivot) on the generic
	 * ArrayList given as input.
	 * 
	 * @param array
	 * @param low
	 * @param high
	 */
	private static <T extends Comparable<? super T>> void quicksort(
			ArrayList<T> array, int low, int high) {

		if (low < high) {
			// sort low, middle, high
			int middle = (low + high) / 2;
			if (array.get(middle).compareTo(array.get(low)) < 0)
				swapReferences(array, middle, low);
			if (array.get(high).compareTo(array.get(low)) < 0)
				swapReferences(array, high, low);
			if (array.get(high).compareTo(array.get(middle)) < 0)
				swapReferences(array, high, middle);

			// place pivot at high-1
			swapReferences(array, middle, high - 1);
			T pivot = array.get(high - 1);

			// partitioning begins
			int i = low, j;
			for (i = low, j = high - 1; i < j;) {
				while (array.get(++i).compareTo(pivot) < 0)
					;
				while (pivot.compareTo(array.get(--j)) < 0)
					;
				if (i >= j)
					break;
				swapReferences(array, i, j);
			}
			// move pivot back
			swapReferences(array, i, high - 1);

			quicksort(array, low, i - 1);
			quicksort(array, i + 1, high);

		}// end if
	}

	// ////////////quicksort2 uses First item as pivot strategy
	public static <T extends Comparable<? super T>> void quicksort2(
			ArrayList<T> array) {
		if (array == null || array.size() <= 1)
			return;
		quicksort2(array, 0, array.size() - 1);
	}

	private static <T extends Comparable<? super T>> void quicksort2(
			ArrayList<T> array, int low, int high) {
		if (low < high) {

			int pivotIdx = (low);
			int pivotNewIdx;
			pivotNewIdx = partition(array, low, high, pivotIdx);
			quicksort2(array, low, pivotNewIdx - 1);
			quicksort2(array, pivotNewIdx + 1, high);

		}// end else
	}

	// //////////////////////////////////////////////////////////////////////////////////////
	// Quicksort3

	// ////////////quicksort3 use middle pivot
	public static <T extends Comparable<? super T>> void quicksort3(
			ArrayList<T> array) {
		if (array == null || array.size() <= 1)
			return;
		quicksort3(array, 0, array.size() - 1);
	}

	private static <T extends Comparable<? super T>> void quicksort3(
			ArrayList<T> array, int low, int high) {
		if (low < high) {

			int pivotIdx = (low + high) / 2;
			int pivotNewIdx;
			pivotNewIdx = partition(array, low, high, pivotIdx);
			quicksort3(array, low, pivotNewIdx - 1);
			quicksort3(array, pivotNewIdx + 1, high);

		}// end else
	}

	private static <T extends Comparable<? super T>> int partition(
			ArrayList<T> array, int low, int high, int pvtIdx) {
		T pivot = array.get(pvtIdx);
		swapReferences(array, pvtIdx, high);
		int first = low;
		for (int i = low; i < high; i++) {

			if (array.get(i).compareTo(pivot) <= 0) {
				swapReferences(array, first, i);
				first++;
			}
		}
		swapReferences(array, first, high);
		return first;

	}

	/**
	 * Swaps references of two items within the passed in array
	 * 
	 * @param <T>
	 * @param array
	 * @param right
	 * @param left
	 */
	public static <T extends Comparable<? super T>> void swapReferences(
			ArrayList<T> array, int right, int left) {
		T temp = array.get(right);
		array.set(right, array.get(left));
		array.set(left, temp);
		System.out.println(array.toString() + " ");
	}

	/**
	 * Puts the ArrayList objects in sorted order.
	 * 
	 * @param size
	 * @return sorted array
	 */
	public static ArrayList<Integer> generateBestCase(int size) {
		ArrayList<Integer> best = new ArrayList<Integer>(size);

		for (int g = 1; g <= size; g++)
			best.add(g);

		return best;

	}

	/**
	 * Puts the ArrayList objects in a random order
	 * 
	 * @param size
	 * @return random array
	 */
	public static ArrayList<Integer> generateAverageCase(int size) {
		ArrayList<Integer> average = new ArrayList<Integer>(size);
		Random rand = new Random();
		for (int g = 1; g <= size; g++) {
			average.add(g);
		}
		for (int i = 0; i < average.size(); i++) {
			int randIdx = rand.nextInt(average.size() - 1);

			// swap number at index i with some random number in the arrayList
			Integer temp = average.get(i);
			average.set(i, average.get(randIdx));
			average.set(randIdx, temp);
		}

		return average;

	}

	/**
	 * Puts the ArrayList objects in reverse-sorted order.
	 * 
	 * @param size
	 * @return reverse sorted array
	 */
	public static ArrayList<Integer> generateWorstCase(int size) {
		ArrayList<Integer> worst = new ArrayList<Integer>(size);
		for (int g = size; g >= 1; g--)
			worst.add(g);
		return worst;

	}

	/**
	 * This method performs an insertion sort on the generic ArrayList given as
	 * input.
	 * 
	 * @param ArrayList
	 *            <T> array
	 * @param low
	 * @param high
	 */
	public static <T extends Comparable<? super T>> void insertionSort(
			ArrayList<T> array, int low, int high) {
		if (array == null)
			return;

		// loop through the array and set the item into the correct position
		for (int i = low; i < high + 1; i++) {
			T val = array.get(i);
			int j;
			for (j = i - 1; j >= 0 && array.get(j).compareTo(val) > 0; j--)
				array.set(j + 1, array.get(j));
			array.set(j + 1, val);

		}

	}
	
	public static void bubbleSort() {
		int[] iarray={30, 12, 18, 0, -5, 72, 424};
		for(int i=0; i< iarray.length;++i) {
			for(int j=i; j<iarray.length-1; ++j) {
				if (iarray[j+1]<iarray[j]) {
					int temp=iarray[j];
					iarray[j]=iarray[j+1];
					iarray[j+1]=temp;
				}			
			}
		}		 
	}

}// end class
