package com.zhangxx.java8;
@FunctionalInterface
interface MyInteface {
    void test();
    String toString();
}
public class Test2{

    void myTest(MyInteface myInteface){
        System.out.println(1);
        myInteface.test();
        System.out.println(2);
    }

    public static void main(String[] args) {
        Test2 test2 =new Test2();


        test2.myTest(()-> System.out.println(1.5));


        MyInteface myInteface =()-> System.out.println(2.5);

        test2.myTest(myInteface);
        System.out.println(myInteface.getClass());
        System.out.println(myInteface.getClass().getSuperclass());
        System.out.println(myInteface.getClass().getInterfaces()[0]);
    }
}