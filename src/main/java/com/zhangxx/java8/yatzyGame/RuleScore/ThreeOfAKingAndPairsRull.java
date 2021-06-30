package com.zhangxx.java8.yatzyGame.RuleScore;

import java.util.List;
import java.util.stream.Collectors;

public class ThreeOfAKingAndPairsRull extends BaseRuleScore {

    int oneCount = 1;
    int twoCount = 1;

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
        int count = 1;
        for (int i = 0; i < sortList.size() - 1; i++) {
            Integer num1 = sortList.get(i);
            if (num1.equals(sortList.get(i + 1))) {
                count++;
                oneCount = count > oneCount ? count : oneCount;
            } else {
                count = 1;
                twoCount = oneCount;
                oneCount = 1;
            }

        }
        return (twoCount == 2 && oneCount == 3) || (twoCount == 3 && oneCount == 2);


    }

    /**
     * 计算得分
     *
     * @param integerList
     * @return
     */
    @Override
    public Integer calulate(List<Integer> integerList) {
        int i = checked(integerList) ? integerList.parallelStream().reduce(0, Math::addExact) : 0;
        System.out.println(this.getClass().toString() + "===" + i);
        return i;
    }
}
