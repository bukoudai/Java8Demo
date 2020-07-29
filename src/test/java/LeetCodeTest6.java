import com.zhangxx.java8.leetcode.ListNode;
import com.zhangxx.java8.leetcode.Solution6;
import org.junit.Test;

import java.util.Arrays;

public class LeetCodeTest6 {

    @Test
    public void mergeTwoLists() {


        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);


        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        System.out.println(Solution6.mergeTwoLists(head2, head));


    }

    @Test
    public void removeElement() {

        int[] a = {0, 1, 2, 2, 3, 0, 4, 2};

        System.out.println(Solution6.removeElement(a, 0));


    }

    @Test
    public void swapPairs() {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(Solution6.swapPairs(head));


    }

    @Test
    public void strStr() {


        System.out.println(Solution6.strStr("a", "a"));
        System.out.println(Solution6.strStr("hello", "ll"));
        System.out.println(Solution6.strStr("aaaaa", "bba"));


    }

    @Test
    public void divide() {


        System.out.println(Solution6.divide(10, 3));
        System.out.println(Solution6.divide(7, -3));
        System.out.println(Solution6.divide(-2147483648, -1));
        System.out.println(Solution6.divide(-2147483648, 1));


    }

    @Test
    public void nextPermutation() {

        int[] a = {1, 2, 3};
        int[] d = {1, 3, 2};
        int[] b = {3, 2, 1};
        int[] c = {1, 1, 5};
        Solution6.nextPermutation(d);
        System.out.println(Arrays.toString(d));
        Solution6.nextPermutation(a);
        System.out.println(Arrays.toString(a));
        Solution6.nextPermutation(b);
        System.out.println(Arrays.toString(b));
        Solution6.nextPermutation(c);
        System.out.println(Arrays.toString(c));


    }

    @Test
    public void longestValidParentheses() {

        System.out.println(Solution6.longestValidParentheses(")())"));
        System.out.println(Solution6.longestValidParentheses(")()())"));
        System.out.println(Solution6.longestValidParentheses("()(())"));


    }
}
