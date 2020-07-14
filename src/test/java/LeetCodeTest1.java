import com.zhangxx.java8.leetcode.ListNode;
import com.zhangxx.java8.leetcode.Solution1;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LeetCodeTest1 {
    //    @Test
    public void addTwoNumbers() {
        ListNode a = new ListNode(1);
        a.next = new ListNode(8);
        ListNode b = new ListNode(0);
        Solution1 s = new Solution1();
        ListNode listNode = s.addTwoNumbers(a, b);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    @Test
    public void lengthOfLongestSubstring() {

        System.out.println(Solution1.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(Solution1.lengthOfLongestSubstring("bbbbb"));
        System.out.println(Solution1.lengthOfLongestSubstring("pwwkew"));
        System.out.println(Solution1.lengthOfLongestSubstring(" "));
        System.out.println(Solution1.lengthOfLongestSubstring(" a"));
        System.out.println(Solution1.lengthOfLongestSubstring("dvdf"));
    }

    @Test
    public void respace() {

        String[] dictionary = {"looked", "just", "like", "her", "brother"};
        String sentence = "jesslookedjustliketimherbrother";

        System.out.println(Solution1.respace(dictionary, sentence));
        System.out.println(Solution1.respace2(dictionary, sentence));
    }

    @Test
    public void maxProfit() {

        int[] a = {1, 2, 3, 0, 2};
        int[] b = {4, 2, 1};


        System.out.println(Solution1.maxProfit(a));
        System.out.println(Solution1.maxProfit(b));

    }

    @Test
    public void countSmaller() {

        int[] a = {1, 1, 1, 1, 1};
        int[] b = {5, 2, 6, 1};



//        System.out.println(Solution1.countSmaller(a));
        System.out.println(Solution1.countSmaller(b));


    }

    @Test
    public void calculateMinimumHP() {

        int[] a = {-2, -3, 3};
        int[] b = {-5, -10, 1};
        int[] c = {10, 30, -5};

        /**
         *   int[] a = { 18,4,-3};
         *         int[] b = { 16,11,5};
         *         int[] c = { -14,-24,6};
         */
        int[][] t = new int[3][3];
        t[0] = a;
        t[1] = b;
        t[2] = c;


        System.out.println(Solution1.calculateMinimumHP(t));


    }

    @Test
    public void intersect() {

        int[] a = {-2, -3, 3};
        int[] b = {-5, -10, 1};
        int[] c = {10, 30, -5};


        System.out.println(Solution1.intersect(a, b));


    }

    @Test
    public void minimumTotal() {


        List<Integer> b = Arrays.asList(2);

        List<Integer> c = Arrays.asList(3, 4);
        List<Integer> d = Arrays.asList(6, 5, 7);
        List<Integer> e = Arrays.asList(4, 1, 8, 3);
        List<List<Integer>> a = Arrays.asList(b, c, d, e);

        System.out.println(Solution1.minimumTotal(a));


    }


}
