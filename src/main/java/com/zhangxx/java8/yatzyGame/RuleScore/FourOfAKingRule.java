package com.zhangxx.java8.yatzyGame.RuleScore;

import java.util.List;

public class FourOfAKingRule extends BaseRuleScore {


  Integer maxValue = 0;


  /**
   * 判断是否符合规则
   *
   * @param integerList
   * @return
   */
  @Override
  public boolean checked(List<Integer> integerList) {


    int[] counts = new int[7];
    //[0]{},[1]{1},[2]{1},[3]{1},[4]{1},[5]{1},[6]{1}
    for (int i = 0; i < integerList.size(); i++) {
      counts[integerList.get(i)]++;

    }
    for (int i = 1; i < counts.length; i++) {
      if ((counts[i] >= 4)) {
        maxValue = i;
        return true;
      }
    }

    return false;
  }

  /**
   * 计算得分
   *
   * @param integerList
   * @return
   */
  @Override
  public Integer calulate(List<Integer> integerList) {
    int i = checked(integerList) ? maxValue * 4 : 0;
    System.out.println(this.getClass().toString() + "===" + i);
    return i;
  }


}
