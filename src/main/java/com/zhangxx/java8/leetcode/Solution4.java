package com.zhangxx.java8.leetcode;

import java.util.*;

public class Solution4 {


    /**
     * 312. 戳气球
     * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
     *
     * 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
     *
     * 求所能获得硬币的最大数量。
     *
     * 说明:
     *
     * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
     * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
     * 示例:
     *
     * 输入: [3,1,5,8]
     * 输出: 167
     * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
     *      coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
     *
     *                      3 1 5 8
     *
     *       1 5 8                              3 5 8                               3 1 8                                3 1 5
     * 5 8      1 8      1 5            5 8     3 8         3 5            1 8      3 8         3 1               1 5       3 5         3 1
     * 5    8  1    8   1    5     5    8     3     8     3    5      1     8       3    8      3   1            1  5      3    5       3   1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/burst-balloons
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return //todo 超时 待优化 TT
     */
        static Map<String,Integer> maxCoins_map=new HashMap<>();
    public static int maxCoins(int[] nums) {
        StringBuilder key =new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            key.append(nums[i]).append(",");
        }
        Integer integer = maxCoins_map.get(key.toString());
        if (integer != null) {
            return integer;
        }
        if (nums.length==1) {
            maxCoins_map.put( key.toString(),nums[0]);
            return nums[0];
        }

        int max =0;
        for (int i = 0; i < nums.length; i++) {

            int[] c=new int[nums.length-1];
            int ci=0;
            for (int i1 = 0; i1 < nums.length; i1++ ) {
                if (i1 != i) {
                    c[ci] = nums[i1];
                    ci++;
                }
            }
            int coins;
            if (i-1<0) {
                coins= nums[i] * nums[i + 1];
            }else if(i+1 >=nums.length){
                coins=  nums[i-1]*nums[i] ;
            }else {
                coins=  nums[i-1]*nums[i]* nums[i + 1] ;
            }
            max =Math.max(maxCoins(c)+coins,max);

        }


        maxCoins_map.put(key.toString(),max);
        return max;
    }

}
