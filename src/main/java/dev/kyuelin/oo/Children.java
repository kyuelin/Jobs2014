package dev.kyuelin.oo;

/**
 * Created by kennethlin on 8/3/17.
 */
public class Children extends Parent {
    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer age;

    @Override
    public String toString() {
        return "Children{" +
                "age=" + age +
                '}' + "\n" + super.toString();
    }

    Children(Integer age) {
        this.age=age;
    }

    public static void main (String[] args) {
        Children children = new Children(15);
        System.out.println(children);
    }
}
