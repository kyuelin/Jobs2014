package dev.kyuelin.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linken on 7/1/16.
 */
public class Generics {
    public static void main(String[] args) {
        //generic
        List<Driver> ld = new ArrayList<>();
        List<? extends  Person> lp = ld;
        List<?> lp2 = ld;

        // downcast/upcast
        Person d = new Person();
        Driver p = (Driver) d;

        Object[] oa = new Object[100];

        final List<String> ls = new ArrayList<>();
        ls.add("test");

    }

    static class Driver extends Person {

    }

    static class Person {

    }

    //accessing nested classes in main
}

