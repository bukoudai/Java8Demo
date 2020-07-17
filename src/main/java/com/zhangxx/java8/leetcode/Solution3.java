package com.zhangxx.java8.leetcode;


public class Solution3 {

    /**
     * 35. 搜索插入位置
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 你可以假设数组中无重复元素。
     *
     * 示例 1:
     *
     * 输入: [1,3,5,6], 5
     * 输出: 2
     * 示例 2:
     *
     * 输入: [1,3,5,6], 2
     * 输出: 1
     * 示例 3:
     *
     * 输入: [1,3,5,6], 7
     * 输出: 4
     * 示例 4:
     *
     * 输入: [1,3,5,6], 0
     * 输出: 0
     *      [0,2] 1
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-insert-position
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param target
     * @return
     */
    public static  int searchInsert(int[] nums, int target) {

        int l =nums.length;
        //最左或最右
        if (l==0||nums[0]>=target) {
            return 0;
        }
        if (nums[l-1]<target) {
            return l;
        }
        if (nums[l-1]==target) {
            return l-1;
        }
        int index=0;
        int end=l;
        int temp=0;
        while (end-index>0){
            l=end-index;
            temp =index+(l>>>1)+(l % 2);
            if (nums[temp]==target) {
                return temp;
            }
            if (nums[temp]>target) {
                if(l==1){
                    if (temp-1>=0) {
                        return temp;
                    }else {
                        return 0;
                    }
                }else {
                    end=temp;
                }
            }
            if (nums[temp]<target) {
                if(l==1){
                  return temp+1;
                }else {
                    index=temp;
                }
            }
        }
        return temp;
    }
    public static  int searchInsert2(int[] nums, int target) {
        /// l 0 0 m 0 0 0 r
        /// 1 2 3 4 5 6 7 8
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;

    }
}





