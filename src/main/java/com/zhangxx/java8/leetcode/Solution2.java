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


    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * <p>
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     * 网格中的障碍物和空位置分别用 1 和 0 来表示。
     * <p>
     * 说明：m 和 n 的值均不超过 100。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * [
     *   [0,0,0],
     *   [0,1,0],
     *   [0,0,0]
     * ]
     * 输出: 2
     * 解释:
     * 3x3 网格的正中间有一个障碍物。
     * 从左上角到右下角一共有 2 条不同的路径：
     * 1. 向右 -> 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右 -> 向右
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/unique-paths-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];

        if (obstacleGrid[n - 1][m - 1] == 0) {
            dp[n - 1][m - 1] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                //判断左和上是否有障碍物或边界

                if (obstacleGrid[i][j] == 1) {
                    continue;
                }

                if (j + 1 < m) {
                    dp[i][j] = dp[i][j + 1];
                }

                if (i + 1 < n) {
                    dp[i][j] = dp[i][j] + dp[i + 1][j];
                }

            }
        }

        return dp[0][0];
    }
}





