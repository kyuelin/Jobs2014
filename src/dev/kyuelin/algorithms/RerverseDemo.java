package algorithm;

import languages.MySuper;

public class RerverseDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MySuper.myPrint(reverseString("kd8324ldclcbk1231"));
	}

	public static String reverseString(final String input) {
		StringBuilder output = new StringBuilder();
		String temp = null; 
		for(int i=input.length()-1; i>=0; --i) {
			temp=input.substring(i,i+1);
			output.append(temp);
			MySuper.myPrint(output.toString());
		}
		return output.toString();
	}
	
}
