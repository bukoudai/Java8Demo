package com.zhangxx.java8.leetcode;

public class Solution7 {

    /**
     * 343. 整数拆分
     * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 2
     * 输出: 1
     * 解释: 2 = 1 + 1, 1 × 1 = 1。
     * 示例 2:
     * <p>
     * 输入: 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
     * 说明: 你可以假设 n 不小于 2 且不大于 58。
     * <p>
     * 3
     * 1 +1 +1 1*1*1
     * 1+2 1*2
     * 4
     * 2*2
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/integer-break
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public static int integerBreak(int n) {

        switch (n) {
            case 0:
                return 0;
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 4;
            case 5:
                return 6;
            case 6:
                return 9;
            default:
                break;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        dp[5] = 6;
        dp[6] = 9;
        for (int i = 7; i < n + 1; i++) {
            dp[i] = dp[i - 3] * 3;
        }
        return dp[n];
    }

    public static int integerBreak2(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int x = n / 3, y = n % 3;
        //整除属于情况1，直接返回3的x次方
        if (y == 0) {
            return (int) Math.pow(3, x);
        }
        //余数为1属于情况2，相当于余数是4=2*2组合，返回3的x-1次方*2*2
        if (y == 1) {
            return (int) Math.pow(3, x - 1) * 4;
        }
        //余数是2属于情况3，直接返回3和2的组合
        return (int) (Math.pow(3, x) * 2);
    }
}
