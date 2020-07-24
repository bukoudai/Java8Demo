package com.zhangxx.java8.leetcode;

import java.util.*;

public class Solution5 {

    /**
     * 11. 盛最多水的容器
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     * -         -
     * - * * * * - * -
     * - -       -   -
     * - -   -   -   -
     * - -   - - -   -
     * - -   - - - - -
     * - - - - - - - -
     * - - - - - - - - -
     * 1 8 6 2 5 4 8 3 7
     * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int h = Math.min(height[i], height[j]);
                int w = j - i;
                max = Math.max(max, h * w);
            }
        }
        return max;
    }

    //双指针
    public static int maxArea2(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int left = height[i];
            int right = height[j];
            if (left < right) {
                max = Math.max(max, left * (j - i));
                i++;
            } else {
                max = Math.max(max, right * (j - i));
                j--;
            }
        }
        return max;
    }


    /**
     * 1025. 除数博弈
     * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
     * <p>
     * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
     * <p>
     * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
     * 用 N - x 替换黑板上的数字 N 。
     * 如果玩家无法执行这些操作，就会输掉游戏。
     * <p>
     * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：2
     * 输出：true
     * 解释：爱丽丝选择 1，鲍勃无法进行操作。
     * 示例 2：
     * <p>
     * 输入：3
     * 输出：false
     * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= N <= 1000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/divisor-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param N
     * @return
     */
    public static boolean divisorGame(int N) {
        //数字N如果是奇数，它的约数必然都是奇数；若为偶数，则其约数可奇可偶。
        //无论N初始为多大的值，游戏最终只会进行到N=2时结束，那么谁轮到N=2时谁就会赢。
        //因为爱丽丝先手，N初始若为偶数，爱丽丝则只需一直选1，使鲍勃一直面临N为奇数的情况，这样爱丽丝稳赢；
        //N初始若为奇数，那么爱丽丝第一次选完之后N必为偶数，那么鲍勃只需一直选1就会稳赢。
        //综述，判断N是奇数还是偶数，即可得出最终结果！
        return N % 2 == 0;
    }

    /**
     * 15. 三数之和
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     * <p>
     * <p>
     * 示例：
     * <p>
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     * <p>
     * 满足要求的三元组集合为：
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        //超时..
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> map = new HashSet<>();
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                int complement = -nums[i] - nums[j];
                if (map.contains(complement)) {
                    List<Integer> list = new ArrayList<>();
                    boolean d = false;
                    list.add(nums[i]);
                    list.add(complement);
                    list.add(nums[j]);
                    list.sort(Integer::compare);
                    for (List<Integer> an : ans) {
                        if (an.get(0).equals(list.get(0)) &&
                                an.get(1).equals(list.get(1)) &&
                                an.get(2).equals(list.get(2))) {
                            d = true;
                            break;
                        }

                    }
                    if (!d) {
                        ans.add(list);
                    }


                }
                map.add(nums[j]);
            }
        }


        return ans;
    }

    //-5 -3 -2 -1 0 1 2 3 4 5
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) {
            return ans;

        }
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            if ((k - 1 >= 0) && (nums[k] == nums[k - 1])) {
                continue;
            }
            int left = k + 1;
            int right = nums.length - 1;

            while (left < right) {
                if ((left - 1) > k && nums[left - 1] == nums[left]) {
                    left++;
                    continue;
                }
                if ((right + 1) < (nums.length - 1) && nums[right + 1] == nums[right]) {
                    right--;
                    continue;
                }

                int i = nums[k] + nums[right] + nums[left];

                if (i < 0) {
                    left++;
                } else if (i > 0) {
                    right--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[k]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);
                    left++;
                    right--;
                }


            }

        }

        return ans;
    }

    /**
     * 16. 最接近的三数之和
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     *  
     * <p>
     * 提示：
     * <p>
     * 3 <= nums.length <= 10^3
     * -10^3 <= nums[i] <= 10^3
     * -10^4 <= target <= 10^4
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum-closest
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        int ans = 0;
        if (nums.length == 3) {
            return 0;

        }
        Arrays.sort(nums);
        boolean frist = true;
        for (int k = 0; k < nums.length - 2; k++) {
            if ((k - 1 >= 0) && (nums[k] == nums[k - 1])) {
                continue;
            }
            int left = k + 1;
            int right = nums.length - 1;

            while (left < right) {
                if ((left - 1) > k && nums[left - 1] == nums[left]) {
                    left++;
                    continue;
                }
                if ((right + 1) < (nums.length - 1) && nums[right + 1] == nums[right]) {
                    right--;
                    continue;
                }

                int i = nums[k] + nums[right] + nums[left];

                if (i < target) {
                    left++;
                } else if (i > target) {
                    right--;
                } else {

                    left++;
                    right--;
                }
                if (frist) {
                    ans = i;
                    frist = false;
                } else if (Math.abs(target - i) <= Math.abs(target - ans)) {
                    ans = i;
                }

            }

        }

        return ans;
    }

    /**
     * 1. 两数之和
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * <p>
     *  
     * <p>
     * 示例:
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
