package com.zhangxx.java8.yatzyGame.RuleScore;

import java.util.List;

public class FullHouseRule extends BaseRuleScore {
    /**
     * 判断是否符合规则
     *
     * @param integerList
     * @return
     */
    @Override
    public boolean checked(List<Integer> integerList) {
        final Integer integer1 = integerList.get(0);
        return integerList.parallelStream().allMatch(integer -> integer.equals(integer1));
    }

    /**
     * 计算得分
     *
     * @param integerList
     * @return
     */
    @Override
    public Integer calulate(List<Integer> integerList) {
        int i = checked(integerList) ? 50 : 0;
        System.out.println(this.getClass().toString() + "===" + i);
        return i;
    }
}
