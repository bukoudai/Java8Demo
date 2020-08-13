package com.zhangxx.java8.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
