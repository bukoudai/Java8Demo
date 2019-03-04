package com.zhangxx.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Test3 {


    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello","world","hello world");


        //list.forEach((String)-> System.out.println(String.toUpperCase()));
        List<String> list2 = new ArrayList<>();

//        list.forEach(String->list2.add(String .toUpperCase()));
//
//
//         list.stream().map(item->item.toUpperCase()).forEach(item->list2.add(item +2));
//
//        list.stream().map(String::toUpperCase).forEach(item->list2.add(item +2));
//        list2.forEach(System.out::println);


//        Function<Object,String> function = Object::toString;
//        System.out.println(function.getClass().getInterfaces()[0]);


    }
}
