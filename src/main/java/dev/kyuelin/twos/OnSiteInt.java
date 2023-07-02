package dev.kyuelin.twos;

import java.util.Scanner;
import java.util.Stack;

public class OnSiteInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(calFibonacci(6));
		reversePolishNotiation();

	}

	public static void findVowels () {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		char[] sa = input.toCharArray();
		int count=0;
		for(char c: sa) {
			if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
				count++;
			}
		}
		System.out.println("count=" + count);
	}
	
	public static int calFibonacci(int n) {
		if (n<=1) return n;
		return calFibonacci(n-1)+calFibonacci(n-2);
	}
	
	public static void reversePolishNotiation() {
		String input = "2 1 + 3 *";
		String[] ins = input.split(" ");
		Stack<Integer> numbers = new Stack<Integer>();
		int i = 0;
		int result = 0;
		while(i<ins.length) {
			String s = ins[i];
			if(isInteger(s)) {
				numbers.push(Integer.parseInt(s));
			}
			else {
				Operator op = (new OnSiteInt()).new OperatorFactory().getOperator(s);
				result = op.operate(numbers.pop(),numbers.pop());
				/*
				switch(s) {
				case "+":
					result = numbers.pop()+numbers.pop();
					break;
				case "-":
					result = numbers.pop()-numbers.pop();
					break;
				case "*":
					result = numbers.pop()*numbers.pop();
					break;
				case "/":
					result = numbers.pop()/numbers.pop();
					break;					
				}
				*/
				
				numbers.push(result);
			}
			i++;
		}
		System.out.print(result);
	}
	
	interface Operator {
		int operate(int i1, int i2);
	}
	
	class AddOperator implements Operator {
		@Override
		public int operate(int i1, int i2) {
			return i1+i2;
		}
	}
	
	class SubOperator implements Operator {
		@Override
		public int operate(int i1, int i2) {
			return i1-i2;
		}
	}
	
	class MulOperator implements Operator {
		@Override
		public int operate(int i1, int i2) {
			return i1*i2;
		}
	}
	
	class DivOperator implements Operator {
		@Override
		public int operate(int i1, int i2) {
			return i1/i2;
		}
	}
	class OperatorFactory {
		public Operator getOperator(String s) {
			Operator op = null;
			switch(s) {
			case "+":
				op = new AddOperator();
				break;
			case "-":
				op = new SubOperator();
				break;
			case "*":
				op = new MulOperator();
				break;
			case "/":
				op = new DivOperator();
				break;								
			}
			return op;
		}		
	}
	
	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}

	public static void deleteSubTrees() {
		
	}
	
	public static void wildcardMatch() {
		
	}
	
	public static void powerOf4ByRecursive() {
		
	}
	
	public static void powerOf4ByBitMani() {
		
	}
	
	public static void iteratorMod5Filter() {
		
	}
	
	public static void gameOfLife() {
		//multi-thread
		//distributed
	}
	
	public static void designTextEditor() {
		//rope
		//2 buffers with cursor
		
	}

	public static void createTestCase() {
		
	}

	public static void debugCodes() {
		
	}
	
	public static void immutablize() {
		
	}
	
	public static void blockingStream() {
		
	}
	
	public static void compareTimeStampIn2Queues() {
		
	}
	
	
}
