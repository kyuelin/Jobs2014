package dev.kyuelin.twos.powerof4;

public class Demo {
	public static boolean isPowerOf4(int num) {
		int c0=0;
		int c1=0;
		
		while(num > 0) {
			if ((num & 1) == 1) {
				++c1;
			}
			if ((num & 1) == 0) {
				++c0;
			}
			num >>=1;
		}
		//return (c1 ==1) && (c0%2==0) && (c0 > 1);
		return (c1 ==1) && (c0%4==0) && (c0 > 1);

	}
	
	public static void main(String[] args) {
		for (int i=0; i<2000; i++) {
			if (isPowerOf4(i)) {
				System.out.println(i);							
			}
		}
	}
}
