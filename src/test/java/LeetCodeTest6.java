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
}
