package com.zhangxx.java8.yatzyGame.RuleScore;

import java.util.List;
import java.util.stream.Collectors;

public class SmallStraightRule extends BaseRuleScore {
  /**
   * 判断是否符合规则
   *
   * @param integerList
   * @return
   */
  @Override
  public boolean checked(List<Integer> integerList) {
    //排序
    List<Integer> sortList = integerList.parallelStream().sorted().collect(Collectors.toList());
    if ((1 != sortList.get(0))) {
      return false;
    }
    for (int i = 0; i < sortList.size() - 1; i++) {
      if (sortList.get(0) + 1 != sortList.get(1)) {
        return false;
      }


    }


    return true;
  }

  /**
   * 计算得分
   *
   * @param integerList
   * @return
   */
  @Override
  public Integer calulate(List<Integer> integerList) {
    int i = checked(integerList) ? 15 : 0;
    System.out.println(this.getClass().toString() + "===" + i);
    return i;
  }
}
