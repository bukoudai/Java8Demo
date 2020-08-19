package com.zhangxx.java8.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution11 {

    /**
     * 57. 插入区间
     * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
     * <p>
     * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
     * 输出：[[1,5],[6,9]]
     * 示例 2：
     * <p>
     * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     * 输出：[[1,2],[3,10],[12,16]]
     * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/insert-interval
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> list = new LinkedList<>(Arrays.asList(intervals));
        boolean addFlag = true;
        for (int i = 0; i < list.size(); i++) {
            int[] ints = list.get(i);
            if (newInterval[1] >= ints[0] && newInterval[0] <= ints[1]) {
                newInterval[0] = Math.min(newInterval[0], ints[0]);
                newInterval[1] = Math.max(newInterval[1], ints[1]);
                list.set(i, newInterval);
                if (!addFlag) {
                    list.remove(i);
                    i--;
                }
                addFlag = false;
            } else if (list.get(i)[0] >= newInterval[1] && addFlag) {
                list.add(i, newInterval);
                addFlag = false;
                break;
            }
        }
        if (addFlag) {
            list.add(newInterval);
        }
        return list.toArray(new int[list.size()][2]);
    }


    /**
     * 45. 跳跃游戏 II
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * <p>
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * <p>
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * <p>
     * 示例:
     * <p>
     * 输入: [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     * 说明:
     * <p>
     * 假设你总是可以到达数组的最后一个位置。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/jump-game-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return 0;
        }
        if (length < 3) {
            return 1;
        }
        int left = 0;
        int right = 0;
        int step = 0;

        for (int i = 0; i < length; i++) {
            right = Math.max(right, nums[i] + i);
            if (i >= left) {
                left = right;
                step++;
                if (right >= (length - 1)) {
                    return step;
                }
            }
        }
        return step;
    }

    /**
     * 647. 回文子串
     * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
     * <p>
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入："abc"
     * 输出：3
     * 解释：三个回文子串: "a", "b", "c"
     * 示例 2：
     * <p>
     * 输入："aaa"
     * 输出：6
     * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
     *  
     * <p>
     * 提示：
     * <p>
     * 输入的字符串长度不会超过 1000 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindromic-substrings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {

        int[] manacher = manacher(s);
        int sum = 0;
        for (int i = 0; i < manacher.length; i++) {
            int i1 = manacher[i];

            sum = sum + (i1 / 2) - 1;
        }
        return sum;
    }

    /**
     * 用Manacher算法求出字符串回文半径数组
     *
     * @param str 字符串
     * @return
     */

    public static int[] manacher(String str) {

        char[] chars = str.toCharArray();
        int length = chars.length;
        //构造新的奇数串
        char[] newchars = new char[length * 2 + 1];
        int l = newchars.length;
        newchars[0] = '#';
        for (int i = 1; i <= length; i++) {
            newchars[i * 2 - 1] = chars[i - 1];
            newchars[i * 2] = '#';
        }

        //计算每个字符的最大回文半径
        int[] p = new int[l];
        //最右边界的对称中心
        int c = -1;
        //最右边界
        int R = -1;
        for (int i = 0; i < l; i++) {
            p[i] = R > i ? Math.min(p[2 * c - i], R - i + 1) : 1;
            while (i + p[i] < newchars.length && i - p[i] > -1) {
                if (newchars[i - p[i]] == newchars[i + p[i]]) {
                    p[i]++;
                } else {
                    break;
                }
            }
            if (i + p[i] > R) {
                R = i + p[i] - 1;
                c = i;
            }

        }

        return p;
    }

}
