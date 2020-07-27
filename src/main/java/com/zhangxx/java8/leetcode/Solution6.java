package com.zhangxx.java8.leetcode;

public class Solution6 {

    /**
     * 21. 合并两个有序链表
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode re = new ListNode();
        ListNode root = re;
        while (true) {

            if (l1 == null) {
                root.next = l2;
                break;
            }
            if (l2 == null) {
                root.next = l1;
                break;
            }
            if (l1.val > l2.val) {
                root.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                root.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            root = root.next;

        }


        return re.next;
    }
}
