package com.zhangxx.java8.leetcode;

import java.util.Arrays;

public class Solution8 {
    /**
     * 462. 最少移动次数使数组元素相等 II
     * 给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，其中每次移动可将选定的一个元素加1或减1。 您可以假设数组的长度最多为10000。
     * <p>
     * 例如:
     * <p>
     * 输入:
     * [1,2,3]
     * <p>
     * 输出:
     * 2
     * <p>
     * 说明：
     * 只有两个动作是必要的（记得每一步仅可使其中一个元素加1或减1）：
     * <p>
     * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static int minMoves2(int[] nums) {
        int ans = 0;
        if (nums.length < 2) {
            return ans;
        }
        Arrays.sort(nums);
        int mid = nums[nums.length >> 1];
        for (int num : nums) {
            ans += Math.abs(mid - num);
        }
        return ans;
    }

    public static int minMoves2_2(int[] nums) {

        Arrays.sort(nums);
        int move = 0;
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            move += nums[h] - nums[l];
            l++;
            h--;
        }
        return move;

    }
}
