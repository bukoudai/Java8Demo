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
            if (integers != null) {
                for (Integer integer : integers) {
                    if (length >= integer) {
                        words = sentence.substring(i - integer, i);
                        if (dic.contains(words)) {
                            dp[i] = Math.min(dp[i], dp[i - integer]);
                            //多个单词符合选择最长的
                        }
                    }
                }
            }
        }
        return dp[n];

    }

    /**
     * 股票最大收益
     * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
     * <p>
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     * <p>
     * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int n = prices.length;

        if (n < 2) {
            //一天没法卖出
            return 0;
        }
        ;
        int dp[][] = new int[n][3];
        //第一天只能买入 收益为 负
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            //0  持有
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            //1 未持有不在冷冻期 前一天 冻结 或者前一天不动
            dp[i][1] = Math.max(dp[i - 1][2], dp[i - 1][1]);
            //2 未持有在冷冻期 可能是前一天卖掉
            dp[i][2] = dp[i - 1][0] + prices[i];
        }


        return Math.max(dp[n - 1][2], dp[n - 1][1]);
    }

    /**
     * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * todo 超时了..
     *
     * @param nums
     * @return
     */
    public static List<Integer> countSmaller2(int[] nums) {


        List<Integer> re = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            Integer c = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    c++;
                }

            }

            re.add(i, c);
        }


        return re;

    }

    public static List<Integer> countSmaller(int[] nums) {
//todo 待完善

        List<Integer> re = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            re.add(0);
        }

        TreeNode a=new TreeNode(nums[ nums.length-1]);
        for (int i = nums.length-2; i >=0; i--) {
            a=TreeNode.add(a,new TreeNode(nums[i]),re,i );
        }


        return re;

    }

    /**
     * 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
     * <p>
     * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
     * <p>
     * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
     * <p>
     * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
     * <p>
     *  
     * <p>
     * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
     * <p>
     * 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
     * <p>
     * -2 (K)   -3      3
     * -5       -10     1
     * 10	    30	    -5 (P)
     *  
     * <p>
     * 说明:
     * <p>
     * 骑士的健康点数没有上限。
     * <p>
     * 任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/dungeon-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param dungeon
     * @return
     */
    public static int calculateMinimumHP(int[][] dungeon) {
        int h = dungeon.length, w = dungeon[0].length;
        int[][] dp = new int[h][w];
        //反向Dp
        for (int i = h-1; i >= 0; i--) {
            for (int j = w-1; j >= 0; j--) {
                if(i==h-1&&j==w-1){
                    //公主的位置
                    dp[i][j]=1-dungeon[i][j];

                }else  if(i==h-1 ){
                    //最下面一行只能是向右
                    dp[i][j]= dp[i][j+1]-dungeon[i][j];

                }else if(j==w-1 ){
                    //最右边只能是向下
                    dp[i][j]=dp[i+1][j]-dungeon[i][j];
                }else {
                    //其他选择最小需要的血
                    dp[i][j]=Math.min(dp[i][j+1]-dungeon[i][j] ,dp[i+1][j]-dungeon[i][j]);
                }
             //血量最少要为1
                    dp[i][j]=Math.max(1, dp[i][j]);



            }
        }


        return dp[0][0];
    }

    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     * 示例 1:
     *
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     * 示例 2:
     *
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [4,9]
     * 说明：
     *
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
     * 我们可以不考虑输出结果的顺序。
     * 进阶:
     *
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer,Integer> re =new HashMap<>();
        for (int value : nums1) {
            Integer v = re.getOrDefault(value, 0);
            re.put(value, v + 1);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = re.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    re.put(num, count);
                } else {
                    re.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);

    }

}





