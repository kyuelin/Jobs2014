package dev.kyuelin.twos.widecardmatch;

import java.util.Scanner;

public class MatchDemo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNextLine()) {
			String input = scan.nextLine();
			String pattern = scan.nextLine();

			System.out.println(isMatch3(input, pattern));
			//System.out.println(isMatch2(input, pattern));
			//System.out.println(isMatch(input, pattern));

		}
	}

	public static boolean isMatch(String s, String p) {
		/*
		 * char cs = s.charAt(0); char p.charAt(pi) = p.charAt(0);
		 * 
		 * if(cs != p.charAt(pi) && p.charAt(pi) != '?' && p.charAt(pi) != '*') return false;
		 */
		int si = 0;
		boolean wflag = false;
		int pi = 0;
		while (si < s.length()) {
			if (pi < p.length() && (p.charAt(pi) == '?' || s.charAt(si) == p.charAt(pi))) {
				si++;
				pi++;
				wflag = false;
				//System.out.println("l1");
			} else if ( pi < p.length() && p.charAt(pi) == '*') {
				pi++;
				wflag = true;
				//System.out.println("l2");
			} else if (wflag) {
				//System.out.println("l4");
				si++;
			}
			else {
				return false;
			}
		}

		while (pi < p.length() && p.charAt(pi) == '*') {
			++pi;
		}

		return  pi == p.length();
	}

	public static boolean isMatch2(String s, String p) {
		int i = 0;
		int j = 0;
		int starIndex = -1;
		int iIndex = -1;

		while (i < s.length()) {
			if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
				++i;
				++j;
			} else if (j < p.length() && p.charAt(j) == '*') {
				starIndex = j;
				iIndex = i;
				j++;
			} else if (starIndex != -1) {
				j = starIndex + 1;
				//i++;
				
				i = iIndex + 1;
				iIndex++;
				
			} else {
				return false;
			}
		}

		while (j < p.length() && p.charAt(j) == '*') {
			++j;
		}

		return j == p.length();
	}
	
	
	public static boolean isMatch3(String s, String p) {
		int i = 0;
		int j = 0;
		int jTemp = -1;
		
		while( i< s.length()) {
			if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
				++i;
				++j;
			}
			else if (j < p.length() && p.charAt(j) == '*' ) {
				jTemp = j;
				++j;
			}
			else if (jTemp != -1 ) {
				j = jTemp+1;
				++i;
			}
			else {
				return false;
			}
		}
		
		while(j < p.length() && p.charAt(j) == '*') {
			++j;
		}
		
		return (j == p.length());
	}
}
