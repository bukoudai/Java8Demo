package com.zhangxx.java8;

import java.util.HashSet;
import java.util.Set;

public class Test4 {

    public static void main(String[] args) {


        Test4 a =new Test4();
        a.test4();
    }
    public static void test1(){

        //双目数值类型提升
        Object i = 1 == 1 ? new Integer(3) : new Float(1);
        System.out.println(i);
    }
    public static void test2(){

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            set.add(i);
            set.remove(i-1);
        }

        System.out.println(set.size());


    }
    public static void test3(){
        //类型转换
        Set<Short> set = new HashSet<>();
        for (short i = 0; i < 100; i++) {
            set.add(i);
            set.remove(i-1);
        }
        System.out.println(set.size());

    }

    public void test4() {
        try {
            new Object().wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
