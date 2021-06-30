package com.zhangxx.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {

    /**
     * 关于函数式接口:
     * 1如果一个接口只有一个抽象方法,那么该接口就是函数接口
     * 2如果声明 FunctionInterface 注解
     * 3对满足函数式接口定义 编译器依旧会看作函数式接口
     */


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));

        }
        Map<String, Object> map = new HashMap<>();
        map.put("1", "2");


        map.forEach((String, Object) -> System.out.println(String + Object));
        System.out.println("---------------------");
        list.forEach(System.out::println);
    }
}
