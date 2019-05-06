package dev.kyuelin.roar;

import java.util.Scanner;

public class MultiplicationTable {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      int m1 = (int) (Math.random() * 10);
      int m2 = (int) (Math.random() * 10);
      System.out.println(m1 + "x" + m2 + "=");
      int result = scanner.nextInt();
      if (result != m1 * m2) {
        System.out.println("Wrong Answer! Correct answer is " + m1 * m2);
      } else {
        System.out.println("This is correct!");
      }
    }
  }

}
