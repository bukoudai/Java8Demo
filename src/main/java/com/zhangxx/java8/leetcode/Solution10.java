package com.zhangxx.java8.leetcode;

import java.util.*;

public class Solution10 {


    /**
     * 133. 克隆图
     * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
     * <p>
     * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
     * <p>
     * class Node {
     * public int val;
     * public List<Node> neighbors;
     * }
     *  
     * <p>
     * 测试用例格式：
     * <p>
     * 简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
     * <p>
     * 邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
     * <p>
     * 给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
     * 输出：[[2,4],[1,3],[2,4],[1,3]]
     * 解释：
     * 图中有 4 个节点。
     * 节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
     * 节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
     * 节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
     * 节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：adjList = [[]]
     * 输出：[[]]
     * 解释：输入包含一个空列表。该图仅仅只有一个值为 1 的节点，它没有任何邻居。
     * 示例 3：
     * <p>
     * 输入：adjList = []
     * 输出：[]
     * 解释：这个图是空的，它不含任何节点。
     * 示例 4：
     * <p>
     * <p>
     * <p>
     * 输入：adjList = [[2],[1]]
     * 输出：[[2],[1]]
     *  
     * <p>
     * 提示：
     * <p>
     * 节点数不超过 100 。
     * 每个节点值 Node.val 都是唯一的，1 <= Node.val <= 100。
     * 无向图是一个简单图，这意味着图中没有重复的边，也没有自环。
     * 由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p 的邻居。
     * 图是连通图，你可以从给定节点访问到所有节点。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/clone-graph
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param node
     * @return
     */


    public static Map<Integer, Node> map = new HashMap<>();

    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        List<Node> neighbors = node.neighbors;
        List<Node> _neighbors = new ArrayList<>();
        Node _node = new Node(node.val);
        map.put(node.val, _node);
        _node.neighbors = _neighbors;
        for (Node neighbor : neighbors) {
            Node node1 = map.get(neighbor.val);
            if (node1 == null) {
                _neighbors.add(cloneGraph(neighbor));
            } else {
                _neighbors.add(node1);
            }

        }


        return _node;
    }

    /**
     * 22. 括号生成
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * <p>
     * <p>
     * <p>
     * 示例：
     * <p>
     * 输入：n = 3
     * 输出：[
     * "((()))",
     * "(()())",
     * "(())()",
     * "()(())",
     * "()()()"
     * ]
     *
     * @param n
     * @return
     */

    static ArrayList[] cache = new ArrayList[100];

    public static List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; c++) {
                for (String left : generate(c)) {
                    for (String right : generate(n - 1 - c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }

    public static List<String> generateParenthesis(int n) {
        return generate(n);
    }

    /**
     * 54. 螺旋矩阵
     * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * [
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * ]
     * 输出: [1,2,3,6,9,8,7,4,5]
     * 示例 2:
     * <p>
     * 输入:
     * [
     * [1, 2, 3, 4],
     * [5, 6, 7, 8],
     * [9,10,11,12]
     * ]
     * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/spiral-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        int x = matrix.length;
        if (x == 0) {
            return new ArrayList<>();
        }
        int y = matrix[0].length;
        if (y == 0) {
            return new ArrayList<>();
        }
        int numEle = x * y;
        List<Integer> ans = new ArrayList<>(numEle);
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        while (numEle >= 1) {
            for (int i = left; i <= right && numEle >= 1; i++) {
                ans.add(matrix[top][i]);
                numEle--;
            }
            top++;
            for (int i = top; i <= bottom && numEle >= 1; i++) {
                ans.add(matrix[i][right]);
                numEle--;
            }
            right--;
            for (int i = right; i >= left && numEle >= 1; i--) {
                ans.add(matrix[bottom][i]);
                numEle--;
            }
            bottom--;
            for (int i = bottom; i >= top && numEle >= 1; i--) {
                ans.add(matrix[i][left]);
                numEle--;
            }
            left++;
        }
        return ans;

    }


    /**
     * 49. 字母异位词分组
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     * <p>
     * 示例:
     * <p>
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出:
     * [
     * ["ate","eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     * 说明：
     * <p>
     * 所有输入均为小写字母。
     * 不考虑答案输出的顺序。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/group-anagrams
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new LinkedList<>();

        HashMap<String, List<String>> hash = new HashMap<>();
        for (String str1 : strs) {
            char[] str = str1.toCharArray();
            Arrays.sort(str);
            String key = new String(str);
            List<String> strings = hash.get(key);
            if (strings == null) {
                LinkedList<String> objects = new LinkedList<>();
                objects.add(str1);
                ans.add(objects);
                hash.put(key, objects);
            } else {
                strings.add(str1);
            }
        }
        return ans;

    }


    /**
     * 55. 跳跃游戏
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * <p>
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * <p>
     * 判断你是否能够到达最后一个位置。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [2,3,1,1,4]
     * 输入: [2,4,4,1,4]
     * 输出: true
     * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
     * 示例 2:
     * <p>
     * 输入: [3,2,1,0,4]
     * 输出: false
     * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/jump-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int length = nums.length;

        if (length == 0) {
            return false;
        }
        int max = 0;
        for (int i = 0; i < length; i++) {
            max = Math.max(nums[i] + i, max);
            if (max >= (length - 1)) {
                return true;
            }

            if ((i >= (max)) && (i != (length - 1))) {
                return false;
            }

        }


        return false;

    }

    /**
     * 56. 合并区间
     * 给出一个区间的集合，请合并所有重叠的区间。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例 2:
     * <p>
     * 输入: [[1,4],[4,5]]
     * 输出: [[1,5]]
     * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-intervals
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> list = new LinkedList<>(Arrays.asList(intervals));
        for (int i = 0; i < list.size(); i++) {


            for (int i1 = 0; i1 < list.size(); i1++) {
                int[] interval = list.get(i);
                if (i1 == i) {
                    continue;
                }
                int[] ints = list.get(i1);
                if (interval[1] >= ints[0] && interval[0] <= ints[1]) {
                    ints[0] = Math.min(interval[0], ints[0]);
                    ints[1] = Math.max(interval[1], ints[1]);
                    list.set(i, ints);
                    list.remove(i1);
                    i1 = 0;
                }
            }

        }
        int[][] ans = new int[list.size()][];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    /**
     * 110. 平衡二叉树
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * <p>
     * 本题中，一棵高度平衡二叉树定义为：
     * <p>
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
     * <p>
     * 示例 1:
     * <p>
     * 给定二叉树 [3,9,20,null,null,15,7]
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回 true 。
     * <p>
     * 示例 2:
     * <p>
     * 给定二叉树 [1,2,2,3,3,null,null,4,4]
     * <p>
     * 1
     * / \
     * 2   2
     * / \
     * 3   3
     * / \
     * 4   4
     * 返回 false 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return isBalanced_hight(root) > -1;
    }

    public int isBalanced_hight(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left_hight = isBalanced_hight(root.left);
        if (left_hight == -1) {
            return -1;
        }
        int right_hight = isBalanced_hight(root.right);
        if (right_hight == -1) {
            return -1;
        }
        if (Math.abs(left_hight - right_hight) > 1) {
            return -1;
        }


        return Math.max(left_hight, right_hight) + 1;
    }

    /**
     * 58. 最后一个单词的长度
     * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
     * <p>
     * 如果不存在最后一个单词，请返回 0 。
     * <p>
     * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
     * <p>
     *  
     * <p>
     * 示例:
     * <p>
     * 输入: "Hello World"
     * 输出: 5
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/length-of-last-word
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int lastworld = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (lastworld == 0) {
                    continue;
                } else {
                    return lastworld;
                }
            }

            if (s.charAt(i) != ' ') {
                lastworld++;
            }
        }

        return lastworld;

    }

    /**
     * 59. 螺旋矩阵 II
     * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
     * <p>
     * 示例:
     * <p>
     * 输入: 3
     * 输出:
     * [
     * [ 1, 2, 3 ],
     * [ 8, 9, 4 ],
     * [ 7, 6, 5 ]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n) {

        int[][] ans = new int[n][n];
        int count = 1;
        int top = 0;
        int left = 0;
        int right = n - 1;
        int bottom = n - 1;
        int max = n * n;
        while (count <= max) {
            for (int i = left; (i <= right) && (count <= max); i++) {
                ans[top][i] = count;
                count++;
            }
            top++;
            for (int i = top; (i <= bottom) && (count <= max); i++) {
                ans[i][right] = count;
                count++;
            }
            right--;
            for (int i = right; (i >= left) && (count <= max); i--) {
                ans[bottom][i] = count;
                count++;
            }
            bottom--;
            for (int i = bottom; (i >= top) && (count <= max); i--) {
                ans[i][left] = count;
                count++;
            }
            left++;

        }


        return ans;


    }

    /**
     * 109. 有序链表转换二叉搜索树
     * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
     * <p>
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     * <p>
     * 示例:
     * <p>
     * 给定的有序链表： [-10, -3, 0, 5, 9],
     * <p>
     * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
     * <p>
     * 0
     * / \
     * -3   9
     * /   /
     * -10  5
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> n = new ArrayList<>();

        if (head == null) {
            return null;
        }

        while (head != null) {

            n.add(head.val);
            head = head.next;
        }


        return sortedArrayToBST(0, n.size() - 1, n);
    }

    public static TreeNode sortedArrayToBST(int start, int end, ArrayList<Integer> nums) {

        if (end == start) {
            return new TreeNode(nums.get(end));
        } else if (end < start) {
            return null;
        }
        int mid = (start + end) >>> 1;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = sortedArrayToBST(start, mid - 1, nums);
        root.right = sortedArrayToBST(mid + 1, end, nums);

        return root;
    }


}
