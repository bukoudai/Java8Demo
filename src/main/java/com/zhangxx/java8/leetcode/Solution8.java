package com.zhangxx.java8.leetcode;

import java.util.Arrays;

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
}
