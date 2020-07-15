package com.zhangxx.java8.leetcode;


public class Solution2 {
    /**
     * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
     * <p>
     * 示例:
     * <p>
     * 输入: 3
     * 输出: 5
     * 解释:
     * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:  1 1              1   2  3         4      4
     * <p>
     * 1         3     3      2      1        1       2      1            1          3    3
     * \       /     /      / \      \        \     /                              2    1
     * 3     2     1      1   3      2        2    1                       3      1    2
     * /     /       \     /    /      \
     * 2     1         2    4   4          3                                2
     * 1 3 2 2  1*5*2   2*2   13 22 31
     * 28 14                          00
     * 1    2   3   4   5       6
     * 1    2   5   14  42    132    84 48
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {

            for (int j = 0; j < i; j++) {
                dp[i] = dp[i] + dp[j] * dp[i - 1 - j];
            }

        }
        return dp[n];
    }


}





