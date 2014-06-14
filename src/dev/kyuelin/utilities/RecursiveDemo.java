package utilities;

import languages.MySuper;

public class RecursiveDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MySuper.myPrint(Integer.toString(numBitSet(23)));
		
		Object o = new Object();
		try {
			o.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int numBitSet(int number) {
		int temp;
		if (number == 0) return 0;
		else {
			temp=(int) (Math.log(number)/Math.log(2));
			temp=(int) Math.pow(2,temp);
		}
		return numBitSet(number-temp)+1;
	}
}
