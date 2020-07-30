package com.zhangxx.java8.leetcode;

import java.util.HashSet;

public class Solution7 {

    /**
     * 343. 整数拆分
     * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 2
     * 输出: 1
     * 解释: 2 = 1 + 1, 1 × 1 = 1。
     * 示例 2:
     * <p>
     * 输入: 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
     * 说明: 你可以假设 n 不小于 2 且不大于 58。
     * <p>
     * 3
     * 1 +1 +1 1*1*1
     * 1+2 1*2
     * 4
     * 2*2
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/integer-break
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public static int integerBreak(int n) {

        switch (n) {
            case 0:
                return 0;
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 4;
            case 5:
                return 6;
            case 6:
                return 9;
            default:
                break;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        dp[5] = 6;
        dp[6] = 9;
        for (int i = 7; i < n + 1; i++) {
            dp[i] = dp[i - 3] * 3;
        }
        return dp[n];
    }

    public static int integerBreak2(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int x = n / 3, y = n % 3;
        //整除属于情况1，直接返回3的x次方
        if (y == 0) {
            return (int) Math.pow(3, x);
        }
        //余数为1属于情况2，相当于余数是4=2*2组合，返回3的x-1次方*2*2
        if (y == 1) {
            return (int) Math.pow(3, x - 1) * 4;
        }
        //余数是2属于情况3，直接返回3和2的组合
        return (int) (Math.pow(3, x) * 2);
    }

    /**
     * 33. 搜索旋转排序数组
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * <p>
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     * <p>
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     * <p>
     * 你可以假设数组中不存在重复的元素。
     * <p>
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     * 示例 2:
     * <p>
     * 输入: nums = [4,5,6,7,0,1,2], target = 3
     * 输出: -1
     * 输入: nums = [4,5,6,7,1,2,3], target = 5
     * 输出: -1
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        if (length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = length - 1;
        int mid = left + ((right - left) >> 1);

        while (left < right) {
            if (nums[left] == target) {
                return left;
            }
            if (nums[right] == target) {
                return right;
            }
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                if (nums[0] > nums[mid]) {
                    //mid在右边区间
                    //target在右边区间
                    right = mid - 1;
                } else if (nums[0] > target) {
                    //target在右边区间
                    //mid在左边区间
                    left = mid + 1;
                } else if (nums[0] < target) {
                    //target mid 在左边区间
                    //mid在左边区间
                    right = mid - 1;
                } else {
                    return -1;
                }

            } else if (target > nums[mid]) {

                if (nums[0] > target) {
                    //mid在右边区间
                    //target在右边区间
                    left = mid + 1;
                } else if (nums[0] > nums[mid]) {
                    //target在左边区间
                    //mid在右边区间
                    right = mid - 1;
                } else if (nums[mid] > nums[0]) {
                    //target在左边区间
                    //mid在左边区间
                    left = mid + 1;
                } else {
                    return -1;
                }

            }
            mid = left + ((right - left) >> 1);
        }
        return nums[mid] != target ? -1 : mid;


    }


    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * <p>
     * 如果数组中不存在目标值，返回 [-1, -1]。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: [3,4]
     * 示例 2:
     * <p>
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: [-1,-1]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int right = nums.length - 1;
        if (right < 0) {
            return ans;
        }

        int left = 0;

        int mid = left + ((right - left) >> 1);

        while (left < right) {
            if (nums[left] == target) {
                mid = left;
                break;
            }
            if (nums[right] == target) {
                mid = right;
                break;
            }
            if (nums[mid] == target) {
                break;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;

            }
            mid = left + ((right - left) >> 1);
        }

        if (mid >= 0 && mid < nums.length && nums[mid] == target) {
            left = mid - 1;
            right = mid + 1;
            while (left > 0) {
                if (nums[left] == target) {
                    left--;
                } else {
                    break;
                }
            }
            ans[0] = left + 1;
            while (right < nums.length) {
                if (nums[right] == target) {
                    right++;
                } else {
                    break;
                }
            }
            ans[0] = left + 1;
            ans[1] = right - 1;


            return ans;
        } else {
            return ans;
        }


    }

    /**
     * 36. 有效的数独
     * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
     * <p>
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     * <p>
     * <p>
     * 上图是一个部分填充的有效的数独。
     * <p>
     * 数独部分空格内已填入了数字，空白格用 '.' 表示。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * [
     * ["5","3",".",".","7",".",".",".","."],
     * ["6",".",".","1","9","5",".",".","."],
     * [".","9","8",".",".",".",".","6","."],
     * ["8",".",".",".","6",".",".",".","3"],
     * ["4",".",".","8",".","3",".",".","1"],
     * ["7",".",".",".","2",".",".",".","6"],
     * [".","6",".",".",".",".","2","8","."],
     * [".",".",".","4","1","9",".",".","5"],
     * [".",".",".",".","8",".",".","7","9"]
     * ]
     * 输出: true
     * 示例 2:
     * <p>
     * 输入:
     * [
     *   ["8","3",".",".","7",".",".",".","."],
     *   ["6",".",".","1","9","5",".",".","."],
     *   [".","9","8",".",".",".",".","6","."],
     *   ["8",".",".",".","6",".",".",".","3"],
     *   ["4",".",".","8",".","3",".",".","1"],
     *   ["7",".",".",".","2",".",".",".","6"],
     *   [".","6",".",".",".",".","2","8","."],
     *   [".",".",".","4","1","9",".",".","5"],
     *   [".",".",".",".","8",".",".","7","9"]
     * ]
     * 输出: false
     * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
     * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
     * 说明:
     * <p>
     * 一个有效的数独（部分已被填充）不一定是可解的。
     * 只需要根据以上规则，验证已经填入的数字是否有效即可。
     * 给定数独序列只包含数字 1-9 和字符 '.' 。
     * 给定数独永远是 9x9 形式的。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-sudoku
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static boolean isValidSudoku(char[][] board) {
        //用数组代替HashSet t10[i]%9
        boolean ans = true;
        int[] SHU;
        int[] HEN;
        int[] XX0 = new int[9];
        int[] XX1 = new int[9];
        int[] XX2 = new int[9];

        for (int count = 0; count < 9; count++) {
            SHU = new int[9];
            HEN = new int[9];
            if (count % 3 == 0) {
                XX0 = new int[9];
                XX1 = new int[9];
                XX2 = new int[9];
            }

            for (int i = 0; i < 9; i++) {

                if (board[count][i] != '.') {
                    if (SHU[board[count][i] % 9] > 0) {
                        return false;
                    } else {
                        SHU[board[count][i] % 9] = 1;
                    }
                }
                if (board[i][count] != '.') {
                    if (HEN[board[i][count] % 9] > 0) {
                        return false;
                    } else {
                        HEN[board[i][count] % 9] = 1;

                    }
                }
                switch (i / 3) {
                    case 0:
                        if (board[count][i] != '.') {
                            if (XX0[board[count][i] % 9] > 0) {
                                return false;
                            } else {
                                XX0[board[count][i] % 9] = 1;
                            }
                        }

                        break;
                    case 1:
                        if (board[count][i] != '.') {
                            if (XX1[board[count][i] % 9] > 0) {
                                return false;
                            } else {
                                XX1[board[count][i] % 9] = 1;
                            }
                        }
                        break;
                    case 2:
                        if (board[count][i] != '.') {
                            if (XX2[board[count][i] % 9] > 0) {
                                return false;
                            } else {
                                XX2[board[count][i] % 9] = 1;
                            }
                        }
                        break;
                    default:
                        return false;
                }

            }

        }

        return ans;
    }

    public static boolean isValidSudoku2(char[][] board) {

        boolean ans = true;
        HashSet<Character> SHU;
        HashSet<Character> HEN;
        HashSet<Character> XX0 = new HashSet<>();
        HashSet<Character> XX1 = new HashSet<>();
        HashSet<Character> XX2 = new HashSet<>();
        for (int count = 0; count < 9; count++) {
            SHU = new HashSet<>();
            HEN = new HashSet<>();
            if (count % 3 == 0) {
                XX0 = new HashSet<>();
                XX1 = new HashSet<>();
                XX2 = new HashSet<>();
            }

            for (int i = 0; i < 9; i++) {

                if (board[count][i] != '.') {
                    if (SHU.contains(board[count][i])) {
                        return false;
                    } else {
                        SHU.add(board[count][i]);
                    }
                }
                if (board[i][count] != '.') {
                    if (HEN.contains(board[i][count])) {
                        return false;
                    } else {
                        HEN.add(board[i][count]);
                    }
                }
                switch (i / 3) {
                    case 0:
                        if (board[count][i] != '.') {
                            if (XX0.contains(board[count][i])) {
                                return false;
                            } else {
                                XX0.add(board[count][i]);
                            }
                        }

                        break;
                    case 1:
                        if (board[count][i] != '.') {
                            if (XX1.contains(board[count][i])) {
                                return false;
                            } else {
                                XX1.add(board[count][i]);
                            }
                        }
                        break;
                    case 2:
                        if (board[count][i] != '.') {
                            if (XX2.contains(board[count][i])) {
                                return false;
                            } else {
                                XX2.add(board[count][i]);
                            }
                        }
                        break;
                    default:
                        return false;
                }

            }

        }

        return ans;
    }
}
