package dev.kyuelin.coding;

/**
 * Created by kennethlin on 7/9/17.
 */
class Parent {
    private final String name;
    private final Integer age;
    Parent(String name, Integer age) {
        this.name=name;
        this.age=age;
    }
}

class Children extends Parent {
    Children(String name, Integer age) {
        super(name, age);
    }
}