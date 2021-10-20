package com.zhangxx.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringComparator {

  public static void main(String[] args) {
    List<String> name = Arrays.asList("zhang", "lisi", "wangwu", "zhangliu");


    Collections.sort(name, (o1, o2) -> 0);
    System.out.println(name);

  }
}
