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

    /**
     * 104. 二叉树的最大深度
     * 给定一个二叉树，找出其最大深度。
     * <p>
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * <p>
     * 说明: 叶子节点是指没有子节点的节点。
     * <p>
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回它的最大深度 3 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = 1;
        max = max + Math.max(maxDepth(root.left), maxDepth(root.right));
        return max;
    }

    /**
     * 27. 移除元素
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * <p>
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 给定 nums = [3,2,2,3], val = 3,
     * <p>
     * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     * 示例 2:
     * <p>
     * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
     * <p>
     * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
     * <p>
     * 注意这五个元素可为任意顺序。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     *  
     * <p>
     * 说明:
     * <p>
     * 为什么返回数值是整数，但输出的答案是数组呢?
     * <p>
     * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     * <p>
     * 你可以想象内部操作如下:
     * <p>
     * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
     * int len = removeElement(nums, val);
     * <p>
     * // 在函数里修改输入数组对于调用者是可见的。
     * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
     * for (int i = 0; i < len; i++) {
     *     print(nums[i]);
     * }
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-element
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param val
     * @return val =1
     * 3 4 1 1 1 5 6
     * l
     * i
     */
    public static int removeElement(int[] nums, int val) {
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != val) {
                if (left != i) {
                    nums[left] = num;
                    nums[i] = val;
                }
                left++;
            }

        }


        return left;
    }

    /**
     * 24. 两两交换链表中的节点
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * <p>
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * <p>
     *  
     * <p>
     * 示例:
     * <p>
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode ans = head.next == null ? head : head.next;
        ListNode pre = new ListNode();

        ListNode left = head;
        pre.next = left;
        ListNode right = head.next;
        while (true) {
            if (right != null) {
                left.next = right.next;
                right.next = left;
                pre.next = right;
            } else {
                break;
            }
            pre = left;
            left = left.next;
            if (left == null) {
                break;
            }
            right = left.next;
        }

        return ans;
    }

    public static ListNode swapPairs(ListNode head) {
        //递归
        if (head == null || head.next == null) {
            return head;
        }
        ListNode right = head.next;
        head.next = swapPairs(right.next);
        right.next = head;

        return right;

    }

    /**
     * 28. 实现 strStr()
     * 实现 strStr() 函数。
     * <p>
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * <p>
     * 示例 1:
     * <p>
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     * 说明:
     * <p>
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * <p>
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/implement-strstr
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if ("".equals(needle) || needle == null) {
            return 0;
        }
        int ans = -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {

            boolean e = true;
            for (int j = i, f = 0; j < (i + needle.length()); j++, f++) {
                if (haystack.charAt(j) != needle.charAt(f)) {
                    e = false;
                    break;
                }

            }
            if (e) {
                ans = i;
                break;
            }

        }
        return ans;
    }

    public static int strStr2(String haystack, String needle) {
        if ("".equals(needle) || needle == null) {
            return 0;
        }

        return haystack.indexOf(needle);
    }

    /**
     * 29. 两数相除
     * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
     * <p>
     * 返回被除数 dividend 除以除数 divisor 得到的商。
     * <p>
     * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: dividend = 10, divisor = 3
     * 输出: 3
     * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
     * 示例 2:
     * <p>
     * 输入: dividend = 7, divisor = -3
     * 输出: -2
     * 解释: 7/-3 = truncate(-2.33333..) = -2
     *  
     * <p>
     * 提示：
     * <p>
     * 被除数和除数均为 32 位有符号整数。
     * 除数不为 0。
     * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/divide-two-integers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        long ans = 0;
        long a = dividend;
        long b = divisor;
        if (a < 0) {
            a = -a;
        }
        if (b < 0) {
            b = -b;
        }
        if (a < b) {
            return 0;
        }
        long temp = b;
        long c = 1;
        while (a >= temp) {
            if ((a - temp) > temp) {
                temp = temp << 1;
                c = c << 1;
            } else {
                ans = ans + c;
                a = a - temp;
                c = 1;
                temp = b;
            }
        }
        if (dividend > 0 ^ divisor > 0) {
            ans = -ans;
        }

        return ans == (int) ans ? (int) ans : Integer.MAX_VALUE;
    }
}
