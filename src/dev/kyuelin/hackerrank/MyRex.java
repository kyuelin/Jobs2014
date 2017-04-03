package dev.kyuelin.hackerrank;

/**
 * Created by linken on 11/5/15.
 */
public class MyRex {

    public static String pattern = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    public static void main(String[] args) {
        System.out.println("10.2.34.2".matches(pattern));
    }
}
