package dev.kyuelin.algorithms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReverseDemo {

	private static Logger logger = LoggerFactory.getLogger(ReverseDemo.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		logger.info(reverseString("kd8324ldclcbk1231"));
	}

	public static String reverseString(final String input) {
		StringBuilder output = new StringBuilder();
		String temp = null; 
		for(int i=input.length()-1; i>=0; --i) {
			temp=input.substring(i,i+1);
			output.append(temp);
			logger.info(output.toString());
		}
		return output.toString();
	}
	
}
