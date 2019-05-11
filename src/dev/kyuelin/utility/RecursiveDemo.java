package dev.kyuelin.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecursiveDemo {

	private static Logger logger = LoggerFactory.getLogger(RecursiveDemo.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		logger.info(Integer.toString(numBitSet(23)));
		
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
