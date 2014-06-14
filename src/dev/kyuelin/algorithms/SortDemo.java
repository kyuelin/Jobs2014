package algorithm;

import java.util.Arrays;

import languages.MySuper;

public class SortDemo {

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
		
		MySuper.myPrint(Arrays.toString(iarray));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SortDemo.bubbleSort();
	}

}
