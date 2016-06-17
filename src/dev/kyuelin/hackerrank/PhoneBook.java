package dev.kyuelin.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by linken on 6/17/16.
 */
public class PhoneBook {
    public static void main(String []argh)
    {
        Map<String, Integer> phonebook = new HashMap<>();

        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        for(int i=0;i<n;i++)
        {
            String name=in.nextLine();
            int phone=in.nextInt();
            phonebook.put(name, phone);
            in.nextLine();
        }
        ArrayList<String> results = new ArrayList<>();
        while(in.hasNext())
        {
            String s=in.nextLine();
            if (!phonebook.containsKey(s)) {
                results.add("Not found");
            }
            else {
                results.add(s+"="+phonebook.get(s).toString());
            }
        }
        for(String s:results) {
            System.out.println(s);
        }
    }
}
