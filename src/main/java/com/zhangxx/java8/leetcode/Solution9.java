package com.zhangxx.java8.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution9 {

    /**
     * 198. 打家劫舍
     * 你是一个专业的小偷，计划偷窃沿街的房屋。
     * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * <p>
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     * 示例 2：
     * <p>
     * 输入：[2,7,9,11,1]
     * 输出：12
     * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     *  
     * <p>
     * 提示：
     * <p>
     * 0 <= nums.length <= 100
     * 0 <= nums[i] <= 400
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/house-robber
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int ans = nums[0];
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);
        ans = Math.max(ans, dp[2]);
        for (int i = 3; i < dp.length; i++) {
            dp[i] = Math.max(nums[i - 1] + dp[i - 2], nums[i - 1] + dp[i - 3]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    /**
     * 213. 打家劫舍 II
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
     * 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
     * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * <p>
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [2,3,2]
     * 输出: 3
     * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     * 示例 2:
     * <p>
     * 输入: [1,2,3,1]
     * 输出: 4
     * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/house-robber-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static int rob_2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        //不算最后一个
        int ans1 = nums[0];
        int[] dp1 = new int[nums.length + 1];
        dp1[1] = nums[0];
        dp1[2] = Math.max(nums[0], nums[1]);
        ans1 = Math.max(ans1, dp1[2]);
        for (int i = 3; i < dp1.length - 1; i++) {
            dp1[i] = Math.max(nums[i - 1] + dp1[i - 2], nums[i - 1] + dp1[i - 3]);
            ans1 = Math.max(ans1, dp1[i]);
        }

        //不算第一个
        int ans2 = nums[0];
        int[] dp2 = new int[nums.length + 1];
        dp2[1] = 0;
        dp2[2] = nums[1];
        ans2 = Math.max(ans2, dp2[2]);
        for (int i = 3; i < dp2.length; i++) {
            dp2[i] = Math.max(nums[i - 1] + dp2[i - 2], nums[i - 1] + dp2[i - 3]);
            ans2 = Math.max(ans2, dp2[i]);
        }

        //比较两次大小
        return Math.max(ans2, ans1);
    }

    /**
     * 337. 打家劫舍 III
     * <p>
     * 真是道高一尺魔高一丈啊...
     * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
     * 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
     * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
     * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
     * <p>
     * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [3,2,3,null,3,null,1]
     * <p>
     * 3
     * / \
     * 2   3
     * \   \
     * 3  3
     * \   \
     * 3   1
     * <p>
     * 输出: 7
     * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
     * 示例 2:
     * <p>
     * 输入: [3,4,5,1,3,null,1]
     * <p>
     *      3
     * / \
     * 4    5
     * / \   \
     * 1   3   1
     * <p>
     * 输出: 9
     * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/house-robber-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    private static HashMap<TreeNode, Integer> rob = new HashMap<>();

    private static int rob(TreeNode root) {
        if (rob.get(root) != null) {
            return rob.get(root);
        }
        if (root == null) {
            rob.put(root, 0);
            return 0;
        }
        rob.put(root, Math.max(rob_no_select(root), rob_select(root)));
        return rob.get(root);
    }

    /**
     * 不选择根节点 的最大值
     *
     * @param root
     * @return
     */
    private static int rob_no_select(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        if (root.right != null) {
            ans = ans + rob(root.right);
        }
        if (root.left != null) {
            ans = ans + rob(root.left);
        }
        return ans;
    }

    /**
     * 选择根节点的最大值
     *
     * @param root
     * @return
     */
    private static int rob_select(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return root.val + rob_no_select(root.left) + rob_no_select(root.right);
    }


    public static int rob2(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    // 返回数组 0 保存不选根节点 1 保存选择根节点
    private static int[] robInternal(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] result = new int[2];

        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;

        return result;
    }

    /**
     * 336. 回文对
     * 给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
     * <p>
     * 示例 1:
     * <p>
     * 输入: ["abcd","dcba","lls","s","sssll"]
     * 输出: [[0,1],[1,0],[3,2],[2,4]]
     * 解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
     * 示例 2:
     * <p>
     * 输入: ["bat","tab","cat"]
     * 输出: [[0,1],[1,0]]
     * 解释: 可拼接成的回文串为 ["battab","tabbat"]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-pairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param words
     * @return
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        //暴力算法超时   题解的字典树 哈希表 和Manacher 还没看懂T.T
        List<List<Integer>> ans = new ArrayList<>();
        if (words.length < 2) {
            return ans;
        }
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPalindrome(words[i] + words[j])) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
                if (isPalindrome(words[j] + words[i])) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(j);
                    list.add(i);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public static boolean isPalindrome(String xx) {
        for (int s = 0, e = xx.length() - 1; s <= e; s++, e--) {
            if ((xx.charAt(s) != xx.charAt(e))) {
                return false;
            }
        }
        return true;

    }

}
