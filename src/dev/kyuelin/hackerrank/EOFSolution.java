package dev.kyuelin.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by linken on 10/30/15.
 */
public class EOFSolution {

    public static void main(String[] args) {

        List<String> listStrings = new ArrayList<String>();
        Scanner cons = new Scanner(System.in);
        while (cons.hasNext()) {
            listStrings.add(cons.nextLine());
        }

        int i = 1;
        for (String str : listStrings) {
            System.out.println(i++ + " " + str);
        }
    }
}
