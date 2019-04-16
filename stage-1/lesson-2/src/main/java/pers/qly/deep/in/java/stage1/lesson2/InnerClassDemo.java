package pers.qly.deep.in.java.stage1.lesson2;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 22:09 2019/1/17
 */
public class InnerClassDemo {

    private int data;

    private C c;

    public static class A {

    }

    public /*static*/ interface B {

    }

    public class C {
        private int data;

    }

    public void setData(){
        c.data = data;
    }

    public static void main(String[] args) {
        A a = null;
        B b = null;
        C c = null;
    }
}
