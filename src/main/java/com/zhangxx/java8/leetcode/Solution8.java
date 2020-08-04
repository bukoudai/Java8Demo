package com.zhangxx.java8.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution8 {
    /**
     * 462. 最少移动次数使数组元素相等 II
     * 给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，其中每次移动可将选定的一个元素加1或减1。 您可以假设数组的长度最多为10000。
     * <p>
     * 例如:
     * <p>
     * 输入:
     * [1,2,3]
     * <p>
     * 输出:
     * 2
     * <p>
     * 说明：
     * 只有两个动作是必要的（记得每一步仅可使其中一个元素加1或减1）：
     * <p>
     * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static int minMoves2(int[] nums) {
        int ans = 0;
        if (nums.length < 2) {
            return ans;
        }
        Arrays.sort(nums);
        int mid = nums[nums.length >> 1];
        for (int num : nums) {
            ans += Math.abs(mid - num);
        }
        return ans;
    }

    public static int minMoves2_2(int[] nums) {

        Arrays.sort(nums);
        int move = 0;
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            move += nums[h] - nums[l];
            l++;
            h--;
        }
        return move;

    }

    /**
     * 206. 反转链表
     * 剑指 Offer 24. 反转链表
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     * <p>
     *  
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     *  
     * <p>
     * 限制：
     * <p>
     * 0 <= 节点个数 <= 5000
     * `
     * 1-2-3-4-5-null
     * <p>
     * 1-null
     * <p>
     * 2-1
     * 3-2
     * 4-3
     * 5-4
     * <p>
     * null
     * <p>
     * <p>
     * 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static ListNode reverseList(ListNode head) {
        //递归 脑子不够用了..
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        ListNode tmp = head.next;
        head.next = null;
        tmp.next = head;
        return p;
    }

    //     * 不知道自己怎么做出了的!!
    //     * 就那样成功了 这就是简单题么?
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode two = head.next;
        ListNode tmp;
        head.next = null;
        while (true) {
            tmp = two.next;
            two.next = pre.next;
            pre.next = two;
            if (tmp != null) {
                two = tmp;
            } else {
                break;
            }
        }

        return pre.next;
    }

    /**
     * 415. 字符串相加
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     * <p>
     * 注意：
     * <p>
     * num1 和num2 的长度都小于 5100.
     * num1 和num2 都只包含数字 0-9.
     * num1 和num2 都不包含任何前导零。
     * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings(String num1, String num2) {

        if (num1.length() == 0) {
            return num2;
        }
        if (num2.length() == 0) {
            return num1;
        }
        if (num1.length() < num2.length()) {
            return addStrings(num2, num1);
        }
        int temp = 0;
        int count = 1;
        char[] ans = new char[num1.length() + 1];
        for (int i = 0; i < num1.length(); i++) {
            int c = (num1.charAt(num1.length() - 1 - i) - 48);
            int sum;
            if ((num2.length() - i) > 0) {
                int d = (num2.charAt(num2.length() - 1 - i) - 48);
                sum = c + d + temp;
            } else {
                sum = c + temp;
            }
            if (sum - 10 == 0) {
                ans[ans.length - count] = '0';
                temp = 1;
            } else if (sum - 10 > 0) {
                ans[ans.length - count] = (char) (sum - 10 + 48);
                temp = 1;
            } else {
                ans[ans.length - count] = (char) (sum + 48);
                temp = 0;
            }
            count++;
        }
        if (temp > 0) {
            ans[0] = (char) (temp + 48);
            return new String(ans);
        } else {
            return new String(ans, 1, ans.length - 1);
        }


    }

    /**
     * 43. 字符串相乘
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     * <p>
     * 示例 1:
     * <p>
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     * 示例 2:
     * <p>
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     * 说明：
     * <p>
     * num1 和 num2 的长度小于110。
     * num1 和 num2 只包含数字 0-9。
     * num1 和 num2 均不以零开头，除非是数字 0 本身。
     * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/multiply-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0) {
            return "";
        }
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        char[] ans = new char[n1.length + n2.length];
        int start = ans.length - 1;
        for (int i = n1.length - 1; i >= 0; i--) {
            int d = n1[i] - '0', k = start;
            for (int j = n2.length - 1; j >= 0; j--) {
                ans[k--] += (n2[j] - '0') * d;
            }
            start--;
        }
        int rem = 0;
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] += rem;
            rem = ans[i] / 10;
            ans[i] = (char) (ans[i] % 10);
        }

        int i = 0;
        while (ans[i] == 0) {
            i++;
        }
        start = i;
        while (i < ans.length) {
            ans[i] = (char) (ans[i] + 48);
            i++;
        }

        return new String(ans, start, ans.length - start);

    }

    /**
     * 207. 课程表
     * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
     * <p>
     * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
     * <p>
     * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: 2, [[1,0]]
     * 输出: true
     * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
     * 示例 2:
     * <p>
     * 输入: 2, [[1,0],[0,1]]
     * 输出: false
     * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
     *  
     * <p>
     * 提示：
     * <p>
     * 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
     * 你可以假定输入的先决条件中没有重复的边。
     * 1 <= numCourses <= 10^5
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/course-schedule
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //DFS
        if (prerequisites.length == 0 || ((prerequisites.length == 1) && (prerequisites[0].length == 0))) {
            return true;
        }
        //准备数据
        int learnCount = 0;

        //节点状态 1 可以学习  0 未遍历  2正在遍历 3 死循环
        int[] status = new int[numCourses];
        //保存节点链接的下一个节点的集合
        HashMap<Integer, List<Integer>> nodes = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int pre = prerequisite[0];
            if (nodes.get(pre) == null) {
                nodes.put(pre, new LinkedList<>());
            }
            nodes.get(pre).add(prerequisite[1]);
        }

        //遍历每个节点

        for (int i = 0; i < numCourses; i++) {
            if (status[i] == 0) {
                //深度遍历
                dfs(nodes, i, status);
            }
        }
        for (int value : status) {
            if (value == 1) {
                learnCount++;
            }
        }
        return learnCount >= numCourses;
    }

    public static boolean dfs(HashMap<Integer, List<Integer>> nodes, int index, int[] status) {
        if (status[index] == 0) {
            status[index] = 2;
            if (nodes.get(index) == null) {
                status[index] = 1;
                return true;
            }
            for (int i1 = 0, l = nodes.get(index).size(); i1 < l; i1++) {
                if (!dfs(nodes, nodes.get(index).get(i1), status)) {
                    status[index] = 3;
                    return false;
                }
            }
            status[index] = 1;
            return true;
        }
        return status[index] == 1;
    }

    public static boolean canFinish_BFS(int numCourses, int[][] prerequisites) {
        //BFS
        if (prerequisites.length == 0 || ((prerequisites.length == 1) && (prerequisites[0].length == 0))) {
            return true;
        }
        //准备数据
        //节点计数   这门课之后的课 +1
        int[] counts = new int[numCourses];
        //保存这门课之后的课
        HashMap<Integer, List<Integer>> nodes = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            nodes.computeIfAbsent(prerequisite[1], k -> new LinkedList<>());
            nodes.get(prerequisite[1]).add(prerequisite[0]);
            counts[prerequisite[0]]++;
        }

        for (int i = 0; i < counts.length; i++) {
            bfs(nodes, i, counts);
        }
        for (int count : counts) {
            if (count > 0) {
                return false;
            }
        }
        return true;
    }

    public static void bfs(HashMap<Integer, List<Integer>> nodes, int index, int[] counts) {
        if (counts[index] == 0) {
            counts[index] = -1;
            //如果为0
            List<Integer> integers = nodes.get(index);
            if (integers == null) {
                return;
            }
            for (int integer : integers) {
                if (counts[integer] < 0) {
                    continue;
                }
                counts[integer]--;
                if (counts[integer] == 0) {
                    bfs(nodes, integer, counts);
                }
            }

        }
    }
}
