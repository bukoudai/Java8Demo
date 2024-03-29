package com.zhangxx.java8;

import java.util.function.Function;

public class FunctionTest {
  public static void main(String[] args) {

    FunctionTest test = new FunctionTest();

    System.out.println(test.compute(1, value -> 2 * value));
    System.out.println(test.compute(5, value -> 2 * value));
  }

  public int compute(int a, Function<Integer, Integer> function) {

    return function.apply(a);
  }
}

