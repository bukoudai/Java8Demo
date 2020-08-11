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


    /**
     * 100. 相同的树
     * 给定两个二叉树，编写一个函数来检验它们是否相同。
     * <p>
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     * <p>
     * 示例 1:
     * <p>
     * 输入:       1         1
     * / \       / \
     * 2   3     2   3
     * <p>
     * [1,2,3],   [1,2,3]
     * <p>
     * 输出: true
     * 示例 2:
     * <p>
     * 输入:      1          1
     * /           \
     * 2             2
     * <p>
     * [1,2],     [1,null,2]
     * <p>
     * 输出: false
     * 示例 3:
     * <p>
     * 输入:       1         1
     * / \       / \
     * 2   1     1   2
     * <p>
     * [1,2,1],   [1,1,2]
     * <p>
     * 输出: false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/same-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }


        return false;

    }

    /**
     * 114. 二叉树展开为链表
     * 给定一个二叉树，原地将它展开为一个单链表。
     * <p>
     *  
     * <p>
     * 例如，给定二叉树
     * <p>
     * 1
     * / \
     * 2   5
     * / \   \
     * 3   4   6
     * 将其展开为：
     * <p>
     * 1
     * \
     * 2
     * \
     * 3
     * \
     * 4
     * \
     * 5
     * \
     * 6
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     */
    public static void flatten(TreeNode root) {
        if (root != null) {
            leftFlatten(root);
        }
    }

    public static TreeNode leftFlatten(TreeNode root) {

        if (root.left == null) {
            if (root.right == null) {
                return root;
            }
            return leftFlatten(root.right);
        }
        TreeNode tmp = root.right;
        TreeNode treeNode = leftFlatten(root.left);
        treeNode.right = tmp;
        root.right = root.left;
        root.left = null;
        if (tmp == null) {
            return treeNode;
        }
        return leftFlatten(tmp);

    }

    /**
     * 61. 旋转链表
     * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 1->2->3->4->5->NULL k=2
     * 输出: 4->5->1->2->3->NULL
     * 解释:
     * 向右旋转 1 步: 5->1->2->3->4->NULL
     * 向右旋转 2 步: 4->5->1->2->3->NULL
     * 示例 2:
     * <p>
     * 输入: 0->1->2->NULL, k = 4 s=3
     * 输出: 2->0->1->NULL
     * 解释:
     * 向右旋转 1 步: 2->0->1->NULL
     * 向右旋转 2 步: 1->2->0->NULL
     * 向右旋转 3 步: 0->1->2->NULL
     * 向右旋转 4 步: 2->0->1->NULL
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotate-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ArrayList<ListNode> a = new ArrayList<>();
        //把链表转换成列表
        while (true) {
            a.add(head);
            if (head.next == null) {
                //首尾相连
                head.next = a.get(0);
                break;
            }
            head = head.next;
        }
        int size = a.size();
        int i = (k) % (size);
        return i == 0 ? a.get(0) : a.get(size - i);
    }

    /**
     * 696. 计数二进制子串
     * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
     * <p>
     * 重复出现的子串要计算它们出现的次数。
     * <p>
     * 示例 1 :
     * <p>
     * 输入: "00110011"
     * 输出: 6
     * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
     * <p>
     * 请注意，一些重复出现的子串要计算它们出现的次数。
     * <p>
     * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
     * 示例 2 :
     * <p>
     * 输入: "10101"
     * 输出: 4
     * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
     * 注意：
     * <p>
     * s.length 在1到50,000之间。
     * s 只包含“0”或“1”字符。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-binary-substrings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public static int countBinarySubstrings(String s) {
        int length = s.length();
        if (length < 2) {
            return 0;
        }
        int ans = 0;
        int last = 0;
        int now = 1;
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                now++;
                if (last >= now) {
                    ans++;
                }
            } else {
                last = now;
                now = 1;
                ans++;
            }
        }
        return ans;
    }

    /**
     * 130. 被围绕的区域
     * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
     * <p>
     * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     * <p>
     * 示例:
     * <p>
     * X X X X
     * X O O X
     * X X O X
     * X O X X
     * 运行你的函数后，矩阵变为：
     * <p>
     * X X X X
     * X X X X
     * X X X X
     * X O X X
     * 解释:
     * <p>
     * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/surrounded-regions
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param board
     */
    public static void solve(char[][] board) {
        int h = board.length;

        if (h < 3) {
            return;
        }
        int w = board[0].length;
        if (w < 3) {
            return;
        }
        //处理四个角
        if (board[0][0] == 'O') {
            board[0][0] = '+';
        }
        if (board[0][w - 1] == 'O') {
            board[0][w - 1] = '+';
        }
        if (board[h - 1][0] == 'O') {
            board[h - 1][0] = '+';
        }
        if (board[h - 1][w - 1] == 'O') {
            board[h - 1][w - 1] = '+';
        }
        for (int i = 1; i < w - 1; i++) {
            dfs(board, i, 0, h, w);
            dfs(board, i, h - 1, h, w);
        }
        for (int i = 1; i < h - 1; i++) {
            dfs(board, 0, i, h, w);
            dfs(board, w - 1, i, h, w);
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                char c = board[i][j];
                if (c == 'O') {
                    board[i][j] = 'X';
                } else if (c == '+') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void dfs(char[][] board, int x, int y, int h, int w) {
        if (board[y][x] == 'O') {
            board[y][x] = '+';
        } else {
            return;
        }
        if (y != 0) {
            dfs(board, x, y - 1, h, w);
        }
        if (y != h - 1) {
            dfs(board, x, y + 1, h, w);
        }
        if (x != 0) {
            dfs(board, x - 1, y, h, w);
        }
        if (x != w - 1) {
            dfs(board, x + 1, y, h, w);
        }


    }

    /**
     * 66. 加一
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * <p>
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * <p>
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * 示例 2:
     * <p>
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/plus-one
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {

        int tmp = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i] + tmp;
            if (num > 10) {
                tmp = 1;
                digits[i] = num - 10;
            } else if (num == 10) {
                tmp = 1;
                digits[i] = 0;
            } else {
                tmp = 0;
                digits[i] = num;
            }
        }
        if (tmp > 0) {
            int[] ans = new int[digits.length + 1];
            System.arraycopy(digits, 0, ans, 1, digits.length);
            ans[0] = tmp;
            return ans;
        } else {
            return digits;
        }

    }

    public int[] plusOne2(int[] digits) {

        int tmp = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i] + tmp;
            if (num > 10) {
                tmp = 1;
                digits[i] = num - 10;
            } else if (num == 10) {
                tmp = 1;
                digits[i] = 0;
            } else {
                digits[i] = num;
                return digits;
            }
        }

        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        return ans;

    }
}
