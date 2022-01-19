package dev.kyuelin.roar;

import java.util.Scanner;

public class MultiplicationTable {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int _max = 5, _min = 1;

    while (true) {
      int m1 = (int) (Math.random() * _max) + _min;
      int m2 = (int) (Math.random() * _max) + _min;
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
