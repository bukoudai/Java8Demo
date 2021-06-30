package com.zhangxx.java8.yatzyGame.RuleScore;

import java.util.List;

public abstract class BaseRuleScore {


    /**
     * 判断是否符合规则
     *
     * @param integerList
     * @return
     */
    abstract boolean checked(List<Integer> integerList);

    /**
     * 计算得分
     *
     * @param integerList
     * @return
     */
    abstract Integer calulate(List<Integer> integerList);

}
