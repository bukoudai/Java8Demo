package com.zhangxx.java8.leetcode;


import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Solution1 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int one = l1.val + l2.val;
        ListNode re = new ListNode(one % 10);
        int bu = one / 10;
        ListNode next = re;
        while (l1.next != null || l2.next != null) {

            l1 = l1.next == null ? new ListNode(0) : l1.next;
            l2 = l2.next == null ? new ListNode(0) : l2.next;
            one = l1.val + l2.val + bu;

            next.next = new ListNode(one % 10);
            next = next.next;
            bu = one / 10;
        }
        if (bu > 0) {
            next.next = new ListNode(bu);

        }


        return re;
    }

    /**
     * 3. 无重复字符的最长子串
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if ("".equals(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();

        char[] b = new char[]{};
        char[] max = new char[]{};
        char[] tmp;
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];

            boolean flag = false;
            for (char c : b) {
                if (c == aChar) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                if (max.length < b.length) {
                    max = b.clone();
                }
                b = new char[]{};

                i = j;
                j++;
            } else {
                tmp = new char[b.length + 1];
                System.arraycopy(b, 0, tmp, 0, b.length);
                tmp[b.length] = aChar;
                b = tmp.clone();
                if (max.length < b.length) {
                    max = b.clone();
                }
            }


        }


        return max.length;
    }

    public static int lengthOfLongestSubstring2(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }

    /**
     * 16.11. 跳水板
     * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
     * <p>
     * 返回的长度需要从小到大排列。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/diving-board-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param shorter
     * @param longer
     * @param k
     * @return
     */
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[]{};// 判空
        }

        if (shorter == longer) {// 短板和长版相等，结果只存在一种
            return new int[]{shorter * k};
        }
        int[] res = new int[k + 1];

        Arrays.fill(res, shorter * k); // 创建数组默认值为shorter*K最短的跳板长度
        for (int i = 0; i < res.length; i++) {
            res[i] += i * (longer - shorter); // longer-shorter 差值
        }
        return res;

    }

    /**
     * 中位数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int all = nums1.length + nums2.length;
        int z = all / 2;
        if (all % 2 > 0) {


        }

        return 0;
    }

    /***
     * 面试题 17.13. 恢复空格 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/re-space-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param dictionary
     * @param sentence
     * @return
     */
    public static int respace(String[] dictionary, String sentence) {
        Set<String> dic = new HashSet<>(Arrays.asList(dictionary));

        int n = sentence.length();
        //dp[i]表示sentence前i个字符所得结果
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;  //先假设当前字符作为单词不在字典中 dp[1]=1
            for (int j = 0; j < i; j++) {
                String words = sentence.substring(j, i);
                if (dic.contains(words)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[n];

    }

    /**
     * 优化  记录字典单词最后一个字符 和单词长度
     *
     * @param dictionary
     * @param sentence
     * @return
     */
    public static int respace2(String[] dictionary, String sentence) {
        Set<String> dic = new HashSet<>(Arrays.asList(dictionary));
        HashMap<Character, HashSet<Integer>> map = new HashMap<>();
        for (String s : dic) {
            int size = s.length();
            HashSet<Integer> integers = map.get(s.charAt(size - 1));
            if (integers == null) {
                integers = new HashSet<>();
            }
            integers.add(size);
            map.put(s.charAt(size - 1), integers);
        }

        int n = sentence.length();
        //dp[i]表示sentence前i个字符所得结果
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;  //先假设当前字符作为单词不在字典中 dp[1]=1
            String words = sentence.substring(0, i);
            int length = words.length();
            HashSet<Integer> integers = map.get(words.charAt(length - 1));
            if (integers != null)  {
                for (Integer integer : integers) {
                    if (length>=integer) {
                        words = sentence.substring(i-integer, i);
                        if (dic.contains(words)) {
                            dp[i] = Math.min(dp[i], dp[i-integer]);
                            //多个单词符合选择最长的
                        }
                    }
                }
            }
        }
        return dp[n];

    }

    public static int maxProfit(int[] prices) {
        int n=prices.length;

        if(n<2){
            //一天没法卖出
            return 0;
        };
        int dp[][]=new int[n][3];
        //第一天只能买入 收益为 负
        dp[0][0]=-prices[0];
        for(int i=1;i<n;i++){
            //0  持有
            dp[i][0] =   Math.max(dp[i - 1][0],dp[i - 1][1] - prices[i]);
            //1 未持有不在冷冻期 前一天 冻结 或者前一天不动
            dp[i][1] =  Math.max(dp[i - 1][2],dp[i - 1][1]);
            //2 未持有在冷冻期 可能是前一天卖掉
            dp[i][2] = dp[i - 1][0]+ prices[i] ;
        }


        return Math.max(dp[n-1][2],dp[n-1][1]);
    }


}





