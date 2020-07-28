import com.zhangxx.java8.leetcode.ListNode;
import com.zhangxx.java8.leetcode.Solution6;
import org.junit.Test;

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
}
