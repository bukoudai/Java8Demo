package com.zhangxx.java8.yatzyGame;

import com.zhangxx.java8.yatzyGame.RuleScore.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameMain {


    public static void main(String[] args) throws Exception {
        //1,掷色子
        // List<Integer> init = init();
        //2.计算得分
        calculateScore(Stream.of(1, 1, 1, 1, 1).collect(Collectors.toList()));

        calculateScore(Stream.of(1, 1, 1, 2, 1).collect(Collectors.toList()));

        calculateScore(Stream.of(1, 1, 6, 2, 6).collect(Collectors.toList()));

        calculateScore(Stream.of(3, 3, 3, 4, 1).collect(Collectors.toList()));

        calculateScore(Stream.of(1, 1, 3, 3, 2).collect(Collectors.toList()));

        calculateScore(Stream.of(2, 2, 2, 2, 1).collect(Collectors.toList()));

        calculateScore(Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList()));

        calculateScore(Stream.of(2, 3, 4, 5, 6).collect(Collectors.toList()));

        calculateScore(Stream.of(1, 2, 2, 2, 1).collect(Collectors.toList()));


    }

    public static Integer calculateScore(List<Integer> init) throws Exception {
        System.out.println("骰子:" + init.toString());
        if (init.size() != 5) {
            throw new Exception("次数错误");
        }
        if (init.stream().filter(integer -> integer > 0 && integer < 7).count() != 5) {
            throw new Exception("骰子范围错误");

        }
        //1/计算基础分
        Integer baseScore = calulateBaseScore(init);
        System.out.println("基础得分:" + baseScore);
        //2.计算规则得分
        Integer ruleScore = calulateRuleScore(init);
        System.out.println("规则得分:" + ruleScore);
        //3.相加
        int score = baseScore + ruleScore;
        System.out.println("总分:" + score);
        System.out.println("=========================================");
        return score;
    }

    /**
     * 计算基础得分
     *
     * @param init
     * @return
     * @throws Exception
     */
    private static Integer calulateBaseScore(List<Integer> init) throws Exception {
        Optional<Integer> baseScoreO = init.parallelStream().reduce(Math::addExact);
        return baseScoreO.orElseThrow(() -> new Exception("数据错误"));
    }

    /**
     * 规则得分
     *
     * @param init
     * @return
     */
    private static Integer calulateRuleScore(List<Integer> init) throws Exception {

        //记录分数
        List<Integer> scores = Stream.of(0).collect(Collectors.toList());
        //规则判断
        scores.add(new FullHouseRule().calulate(init));

        scores.add(new FourOfAKingRule().calulate(init));

        scores.add(new ThreeOfAKingAndPairsRull().calulate(init));

        scores.add(new ThreeOfAKingRule().calulate(init));

        scores.add(new LargeStraightRule().calulate(init));

        scores.add(new SmallStraightRule().calulate(init));

        scores.add(new TwoPairRule().calulate(init));

        scores.add(new PairsRule().calulate(init));

        //取得分最大的

        return scores.parallelStream().max(Integer::compareTo).orElseThrow(() -> new Exception("数据错误"));

    }


    /**
     * 初始化骰子
     *
     * @return
     */
    public static List<Integer> init() {
        ArrayList<Integer> list = new ArrayList<Integer>(6);
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            list.add(r.nextInt(5) + 1);
        }
//       return  list;
        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(1);
        integers.add(4);
        integers.add(4);
        integers.add(3);
        integers.add(3);
        return integers;
    }
}
