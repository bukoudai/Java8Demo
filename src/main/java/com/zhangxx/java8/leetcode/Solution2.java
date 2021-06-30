package com.zhangxx.java8.leetcode;


import java.util.ArrayList;

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

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * <p>
     * 问总共有多少条不同的路径？
     * <p>
     * <p>
     * <p>
     * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/unique-paths
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        dp[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                //判断左和上是否有边界
                if (j + 1 < n) {
                    dp[i][j] = dp[i][j + 1];
                }
                if (i + 1 < m) {
                    dp[i][j] = dp[i][j] + dp[i + 1][j];
                }
            }
        }

        return dp[0][0];
    }

    /**
     * 4. 寻找两个正序数组的中位数
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
     * <p>
     * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * <p>
     * 你可以假设 nums1 和 nums2 不会同时为空。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * nums1 = [1, 3]
     * nums2 = [2]
     * <p>
     * 则中位数是 2.0
     * 示例 2:
     * <p>
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * <p>
     * 则中位数是 (2 + 3)/2 = 2.5
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a = 0;
        int b = 0;
        int z = (nums1.length + nums2.length) / 2;
        int z2 = (nums1.length + nums2.length) % 2;
        boolean isEven = z2 == 0;
        int[] all = new int[z + 1];
        for (int i = 0; i < all.length; i++) {
            if (b == nums2.length) {
                all[i] = nums1[a];
                a++;
                continue;
            }
            if (a == nums1.length) {
                all[i] = nums2[b];
                b++;
                continue;
            }
            if (nums1[a] >= nums2[b]) {
                all[i] = nums2[b];
                b++;
                continue;
            }
            if (nums1[a] < nums2[b]) {
                all[i] = nums1[a];
                a++;
                continue;
            }
        }

        if (isEven) {
            return (all[all.length - 1] + all[all.length - 2]) / 2.0;

        } else {
            return all[all.length - 1];
        }

    }


    /**
     * 5. 最长回文子串
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * <p>
     * 示例 1：
     * <p>
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     * <p>
     * 输入: "cbbd" c b b d  cd bb bd  cbb bbd
     * 输出: "bb"
     * <p>
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        String max = "";
        for (int i = 0; i < s.length(); i++) {

            for (int j = 0; j <= i; j++) {
                String test = s.substring(j, s.length() - (i - j));
                if (isPalindrome(test)) {
                    return test;
                }
            }

        }


        return max;
    }

    /**
     * 9. 回文数
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 121
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3:
     * <p>
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        String xx = "" + x;
        for (int s = 0, e = xx.length() - 1; s <= e; s++, e--) {
            if ((xx.charAt(s) != xx.charAt(e))) {
                return false;
            }


        }
        return true;

    }

    public static boolean isPalindrome(String xx) {

        for (int s = 0, e = xx.length() - 1; s <= e; s++, e--) {
            if ((xx.charAt(s) != xx.charAt(e))) {
                return false;
            }


        }
        return true;

    }

    /**
     * 6. Z 字形变换
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     * <p>
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     * <p>
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     * <p>
     * 请你实现这个将字符串进行指定行数变换的函数：
     * <p>
     * string convert(string s, int numRows);
     * 示例 1:
     * <p>
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     * 示例 2:
     * <p>
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     * <p>
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zigzag-conversion
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 10/2n-1 * n-1  +10%2n-1
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {

        if (numRows == 1 || numRows == 0) {
            return s;
        }

        int length = s.length();

        ArrayList<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        for (int i = 0; i < length; i++) {
            int count = (i + 1) / (2 * numRows - 2);
            int count2 = (i + 1) % (2 * numRows - 2);
            if (count2 == 0) {
                rows.set(1, rows.get(1).append(s.charAt(i)));
            } else {
                int count3 = count2 % numRows;
                int count4 = count2 / numRows;
                if (count4 == 0) {
                    if (count3 == 0) {
                        rows.set(numRows - 1, rows.get(numRows - 1).append(s.charAt(i)));
                    } else {
                        rows.set(count3 - 1, rows.get(count3 - 1).append(s.charAt(i)));

                    }
                } else {
                    if (count3 == 0) {
                        rows.set(numRows - 1, rows.get(numRows - 1).append(s.charAt(i)));
                    } else {
                        rows.set(numRows - 1 - count3, rows.get(numRows - 1 - count3).append(s.charAt(i)));

                    }
                }


            }
        }

        StringBuilder re = new StringBuilder();
        for (StringBuilder row : rows) {
            re.append(row);

        }


        return re.toString();
    }

    public static String convert2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        if (numRows == 0) {
            return "";
        }
        ArrayList<ArrayList<String>> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new ArrayList<>());
        }

        for (int i = 0; i < s.length(); i++) {


        }

        StringBuilder re = new StringBuilder();
        for (ArrayList<String> row : rows) {
            for (String s1 : row) {
                re.append(s1);
            }
        }
        return re.toString();
    }

    /**
     * 7. 整数反转
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 123
     * 输出: 321
     *  示例 2:
     * <p>
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * <p>
     * 输入: 120
     * 输出: 21
     * 注意:
     * <p>
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param x
     * @return
     */
    public static int reverse2(int x) {

        String xString = Integer.toString(x);
        String string = xString;
        int flag = 1;
        if (x < 0) {
            flag = -1;
            string = xString.substring(1);
        }
        try {
            return Integer.parseInt((new StringBuilder(string)).reverse().toString()) * flag;
        } catch (Exception e) {
            return 0;
        }
    }

    public static int reverse(int x) {

        String a = "" + x;
        if (a.startsWith("-")) {
            a = a.substring(1);
            int l = a.length();
            char[] newstr = a.toCharArray();
            for (int i = 0; i <= l / 2; i++) {
                newstr[i] = a.charAt(l - 1 - i);
                newstr[l - 1 - i] = a.charAt(i);
            }
            a = "-" + new String(newstr);

        } else {
            int l = a.length();
            char[] newstr = a.toCharArray();
            for (int i = 0; i <= l / 2; i++) {
                newstr[i] = a.charAt(l - 1 - i);
                newstr[l - 1 - i] = a.charAt(i);
            }
            a = new String(newstr);
        }

        long i = Long.parseLong(a);


        return (int) i == i ? (int) i : 0;
    }

    public static int reverse3(int x) {

        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }

    /**
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     * <p>
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
     * <p>
     * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
     * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
     * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
     * <p>
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
     * <p>
     * 提示：
     * <p>
     * 本题中的空白字符只包括空格字符 ' ' 。
     * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: "42"
     * 输出: 42
     * 示例 2:
     * <p>
     * 输入: "   -42"
     * 输出: -42
     * 解释: 第一个非空白字符为 '-', 它是一个负号。
     *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
     * 示例 3:
     * <p>
     * 输入: "4193 with words"
     * 输出: 4193
     * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
     * 示例 4:
     * <p>
     * 输入: "words and 987"
     * 输出: 0
     * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     * 因此无法执行有效的转换。
     * 示例 5:
     * <p>
     * 输入: "-91283472332"
     * 输出: -2147483648
     * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     *      因此返回 INT_MIN (−231) 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * 这道题太蠢了  不停地出现特殊情况..
     *
     * @param str
     * @return
     */
    public static int myAtoi(String str) {

        str = str.trim();

        int l = str.length();
        if (l == 0) {
            return 0;
        }
        int en;
        int st = 0;
        char[] val = str.toCharArray();
        int flag = 1;
        if (val[0] == '-') {
            flag = -1;
        } else if (val[0] == '+') {

        } else if (!Character.isDigit(val[0])) {
            return 0;
        }

        while ((st < l) && (!Character.isDigit(val[st]))) {
            st++;
        }
        en = st;
        while ((en < l) && (Character.isDigit(val[en]))) {
            en++;
        }
        if (st >= l || st > 1) {
            return 0;
        }
        String substring = str.substring(st, en);
        try {
            return Integer.parseInt(substring) * flag;

        } catch (Exception e) {
            return flag > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }


    }

    /**
     * 给定一个无向图graph，当这个图为二分图时返回true。
     * <p>
     * 如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
     * <p>
     * graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。
     * <p>
     * <p>
     * 示例 1:
     * 输入: [[1,3], [0,2], [1,3], [0,2]]
     * 输出: true
     * 解释:
     * 无向图如下:
     * 0----1
     * |    |
     * |    |
     * 3----2
     * 我们可以将节点分成两组: {0, 2} 和 {1, 3}。
     * <p>
     * 示例 2:
     * 输入: [[1,2,3], [0,2], [0,1,3], [0,2]]
     * 输出: false
     * 解释:
     * 无向图如下:
     * 0----1
     * | \  |
     * |  \ |
     * 3----2
     * 我们不能将节点分割成两个独立的子集。
     * 注意:
     * <p>
     * graph 的长度范围为 [1, 100]。
     * graph[i] 中的元素的范围为 [0, graph.length - 1]。
     * graph[i] 不会包含 i 或者有重复的值。
     * 图是无向的: 如果j 在 graph[i]里边, 那么 i 也会在 graph[j]里边。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/is-graph-bipartite
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param graph
     * @return
     */
    //无色
    private static final int UNCOLORED = 0;
    //红
    private static final int RED = 1;
    //绿
    private static final int GREEN = 2;


    public static boolean isBipartite(int[][] graph) {
        int length = graph.length;
        //节点颜色
        int[] color = new int[length];
        //已被访问
//          Boolean valid=false;

        for (int i = 0; i < length; i++) {
            if (color[i] == UNCOLORED) {

                if (!dfs(i, RED, graph, color)) {
                    return false;
                }
            }


        }


        return true;
    }

    private static boolean dfs(int node, int c, int[][] graph, int[] color) {

        color[node] = c;
        //相连节点颜色
        int cNei = c == RED ? GREEN : RED;
        for (int neighbor : graph[node]) {
            if (color[neighbor] == UNCOLORED) {
                if (!dfs(neighbor, cNei, graph, color)) {
                    return false;
                }
            } else if (color[neighbor] != cNei) {
                return false;

            }
        }
        return true;
    }

}





