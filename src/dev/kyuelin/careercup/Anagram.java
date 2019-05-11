package dev.kyuelin.careercup;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

  static int count = 0;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter 2 strings to compare : ");
    String input1 = scanner.nextLine();
    String input2 = scanner.nextLine();
    System.out.println("matched : " + match(input1, input2));

    //recursive("", input);
  }

  public static void recursive(String leftover, String remaining) {
    if (remaining.length() == 0) {
      System.out.println("[" + ++count + "]" + leftover);
    }
    for (int i = 0; i < remaining.length(); i++) {
      recursive(leftover + remaining.charAt(i),
          remaining.substring(0, i) + remaining.substring(i + 1));
    }
  }

  public static boolean match(String input1, String input2) {
    Arrays.sort(input1.toCharArray());
    Arrays.sort(input2.toCharArray());
    return (Arrays.equals(input1.toCharArray(), input2.toCharArray()));
  }

}
