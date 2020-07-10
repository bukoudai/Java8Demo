import com.zhangxx.java8.leetcode.ListNode;
import com.zhangxx.java8.leetcode.Solution1;

import org.junit.Test;

public class LeetCodeTest1 {
//    @Test
    public  void addTwoNumbers(){
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
    public  void lengthOfLongestSubstring(){

        System.out.println(Solution1.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(Solution1.lengthOfLongestSubstring("bbbbb"));
        System.out.println(Solution1.lengthOfLongestSubstring("pwwkew"));
        System.out.println(Solution1.lengthOfLongestSubstring(" "));
        System.out.println(Solution1.lengthOfLongestSubstring(" a"));
        System.out.println(Solution1.lengthOfLongestSubstring("dvdf"));
    }
    @Test
    public  void respace(){

        String[] dictionary = {"looked","just","like","her","brother"};
        String  sentence = "jesslookedjustliketimherbrother";

        System.out.println(Solution1.respace(dictionary,sentence));
        System.out.println(Solution1.respace2(dictionary,sentence));
    }
    @Test
    public  void maxProfit(){

        int[] a = {1,2,0,0,6};


        System.out.println(Solution1.maxProfit(a));

    }


}
