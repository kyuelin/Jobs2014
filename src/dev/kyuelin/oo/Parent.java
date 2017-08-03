package dev.kyuelin.oo;

/**
 * Created by kennethlin on 8/3/17.
 */
public class Parent {
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer age;

    @Override
    public String toString() {
        return "Parent{" +
                "age=" + age +
                '}';
    }

    Parent() {
        this.age=40;
    }
}
