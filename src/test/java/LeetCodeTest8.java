import com.zhangxx.java8.leetcode.ListNode;
import com.zhangxx.java8.leetcode.Solution8;
import org.junit.jupiter.api.Test;


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

    @Test
    public void addStrings() {


        System.out.println(Solution8.addStrings("123456789", "987654321"));


    }

    @Test
    public void multiply() {


        System.out.println(Solution8.multiply("99", "999"));


    }

    @Test
    public void canFinish() {

        int[][] c = new int[][]{{1, 0}, {0, 1}};
        int[][] d = new int[][]{{1, 0}};
        int[][] e = new int[][]{{0, 1}};
        int[][] an1 = new int[][]{{0, 2}, {1, 2}, {2, 0}};
        int[][] bn1 = new int[][]{{1, 0}, {1, 2}, {0, 1}};

        int[][] f = new int[][]{{2, 0}, {1, 0}, {3, 1}, {3, 2}, {1, 3}};
//        System.out.println(Solution8.canFinish(2,c));
//        System.out.println(Solution8.canFinish(2,d));
//        System.out.println(Solution8.canFinish(2,e));
//        System.out.println(Solution8.canFinish(3,an1));
//        System.out.println(Solution8.canFinish(3,bn1));

        System.out.println(Solution8.canFinish_BFS(2, c));
        System.out.println(Solution8.canFinish_BFS(2, d));
        System.out.println(Solution8.canFinish_BFS(2, e));
        System.out.println(Solution8.canFinish_BFS(3, an1));
        System.out.println(Solution8.canFinish_BFS(3, bn1));
        System.out.println(Solution8.canFinish_BFS(4, f));


    }

    @Test
    public void maxSubArray() {


        System.out.println(Solution8.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));


    }
}
