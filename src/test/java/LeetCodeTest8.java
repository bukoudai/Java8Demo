import com.zhangxx.java8.leetcode.ListNode;
import com.zhangxx.java8.leetcode.Solution8;
import org.junit.Test;

public class LeetCodeTest8 {
    @Test
    public void firstMissingPositive() {
        int[] a = new int[]{1, 0, 0, 8, 6};


//        System.out.println( Solution7.firstMissingPositive(a));
        System.out.println(Solution8.minMoves2(a));


    }

    @Test
    public void reverseList() {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(Solution8.reverseList(head));


    }
}
