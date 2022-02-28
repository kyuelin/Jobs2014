package dev.kyuelin.java8;

import java.util.function.Function;
import java.util.function.IntConsumer;

public class FunctorDemo {

    @FunctionalInterface
    public interface Foo {
        String method(String string);
    }

    public static String add1(String s1, Function<String, String> fn) {
        return fn.apply(s1);
    }

    public static String add2(String s2, Foo foo) {
        return foo.method(s2);
    }

    public interface Func {
        String execute(String input);
    }

    public static String add3(String s3, Func func) { return (func.execute(s3)) ;}

    public static void main(String[] args) {
        Function<String, String> fn = input -> input + "something" ;
        System.out.println(add1("input1 ", fn));

        //Foo foo = input -> input + "something" ;
        System.out.println(add2("input2 ", input -> input + "something" ));

        IntConsumer add = a1 -> a1 += 123;
        IntConsumer mul = a2 -> a2 *= 3;
        IntConsumer dpl = a3 -> System.out.println(a3);
        IntConsumer chain = dpl.andThen(mul);
        chain.accept(4);

        System.out.println(add3("input3 ", input -> input + "something"));
    }

}
