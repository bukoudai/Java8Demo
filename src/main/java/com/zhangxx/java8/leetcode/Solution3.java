package com.zhangxx.java8.leetcode;


public class Solution3 {

    /**
     * 35. 搜索插入位置
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 你可以假设数组中无重复元素。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,3,5,6], 5
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: [1,3,5,6], 2
     * 输出: 1
     * 示例 3:
     * <p>
     * 输入: [1,3,5,6], 7
     * 输出: 4
     * 示例 4:
     * <p>
     * 输入: [1,3,5,6], 0
     * 输出: 0
     * [0,2] 1
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-insert-position
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {

        int l = nums.length;
        //最左或最右
        if (l == 0 || nums[0] >= target) {
            return 0;
        }
        if (nums[l - 1] < target) {
            return l;
        }
        if (nums[l - 1] == target) {
            return l - 1;
        }
        int index = 0;
        int end = l;
        int temp = 0;
        while (end - index > 0) {
            l = end - index;
            temp = index + (l >>> 1) + (l % 2);
            if (nums[temp] == target) {
                return temp;
            }
            if (nums[temp] > target) {
                if (l == 1) {
                    if (temp - 1 >= 0) {
                        return temp;
                    } else {
                        return 0;
                    }
                } else {
                    end = temp;
                }
            }
            if (nums[temp] < target) {
                if (l == 1) {
                    return temp + 1;
                } else {
                    index = temp;
                }
            }
        }
        return temp;
    }

    public static int searchInsert2(int[] nums, int target) {
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


    /**
     * 112. 路径总和
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     * <p>
     * 说明: 叶子节点是指没有子节点的节点。
     * <p>
     * 示例: 
     * 给定如下二叉树，以及目标和 sum = 22，
     * <p>
     * 5
     * / \
     * 4   8
     * /   / \
     * 11  13  4
     * /  \      \
     * 7    2      1
     * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/path-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @param sum
     * @return
     */

    public static boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum_check(0, sum, root);
    }

    public static boolean hasPathSum_check(int all, int sum, TreeNode root) {
        //计算节点和
        all = all + root.val;
        if (sum < all) {
            //和大于目标值
            return false;
        }
        if (sum == all) {
            //相等判断是否是叶子节点
            if (root.left == null && root.right == null) {
                return true;
            }
        }
        if (root.left != null) {
            if (hasPathSum_check(all, sum, root.left)) {
                return true;
            }
        }
        if (root.right != null) {
            if (hasPathSum_check(all, sum, root.right)) {
                return true;
            }
        }
        return false;

    }

    /**
     * 44. 通配符匹配
     * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
     * <p>
     * '?' 可以匹配任何单个字符。
     * '*' 可以匹配任意字符串（包括空字符串）。
     * 两个字符串完全匹配才算匹配成功。
     * <p>
     * 说明:
     * <p>
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
     * 示例 1:
     * <p>
     * 输入:
     * s = "aa"
     * p = "a"
     * 输出: false
     * 解释: "a" 无法匹配 "aa" 整个字符串。
     * 示例 2:
     * <p>
     * 输入:
     * s = "aa"
     * p = "*"
     * 输出: true
     * 解释: '*' 可以匹配任意字符串。
     * 示例 3:
     * <p>
     * 输入:
     * s = "cb"
     * p = "?a"
     * 输出: false
     * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
     * 示例 4:
     * <p>
     * 输入:
     * s = "adceb"
     * p = "*a*b"
     * 输出: true
     * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
     * 示例 5:
     * <p>
     * 输入:
     * s = "acdcb"
     * p = "a*c?b"
     * 输出: false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/wildcard-matching
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        char[] chars = s.toCharArray();
        char[] chars1 = p.toCharArray();

        //todo


        return false;
    }

    /**
     * 718. 最长重复子数组
     * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 输入：
     * A: [1,2,3,2,1]
     * B: [3,2,1,4,7]
     * 输出：3
     * 解释：
     * 长度最长的公共子数组是 [3, 2, 1] 。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= len(A), len(B) <= 1000
     * 0 <= A[i], B[i] < 100
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {
        //暴力解法
        int ans = 0;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = 0; j < B.length - 1; j++) {
                int k = 0;
                while (A[i + k] == B[j + k]) {
                    k += 1;
                }
                ans = Math.max(ans, k);
            }
        }

        return ans;

    }

    public static int findLength2(int[] A, int[] B) {
        //动态规划
        //   1 2 3 4 5 6 7 5 2
        // 2 0 1 0 0 0 0 0 0 1
        // 2 0 1 0 0 0 0 0 0 1
        // 3 0 0 1 0 0 0 0 0 0
        // 4 0 0 0 1 0 0 0 0 0
        // 5 0 0 0 0 1 0 0 1 0
        // 2 0 1 0 0 0 0 0 0 1

        int[][] dp = new int[A.length][B.length];

        int ans = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (A[i] == B[j]) {
                    if (i == 0 || j == 0) {
                        //边界
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }
                ans = Math.max(dp[i][j], ans);
            }

        }


        return ans;

    }

    /**
     * 378. 有序矩阵中第K小的元素
     * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
     * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * matrix = [
     * [ 1,  13,  14],
     * [9, 14, 15],
     * [11, 15, 16]
     * ],
     * k = 8,
     * <p>
     * 返回 13。
     *  
     * <p>
     * 提示：
     * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param matrix
     * @param k
     * @return
     */
    public static int kthSmallest(int[][] matrix, int k) {
        // 二分查找
        // 0 1 2 3
        // 2 4 5 6
        // 3 5 6 7
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k )) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static  boolean check(int[][] matrix, int mid, int k) {
        int i = matrix.length - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < matrix.length) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }



    /**
     * 167. 两数之和 II - 输入有序数组
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     *
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     *
     * 说明:
     *
     * 返回的下标值（index1 和 index2）不是从零开始的。
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     * 示例:
     *
     * 输入: numbers = [2, 7, 11, 15], target = 9
     * 输出: [1,2]
     * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {

            if ((numbers[right] - target) + numbers[left] == 0) {
                ans[0] = left+1;
                ans[1] = right+1;

                break;
            }
            if ((numbers[right] - target) + numbers[left] < 0) {
                left++;
            } else {
                right--;
            }
        }


        return ans;
    }


    /**
     *
     * 97. 交错字符串
     * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：s1 = "aa bc c", s2 = "db bc a", s3 = "aa db bc bc ac"
     * 输出：true
     * 示例 2：
     *
     * 输入：s1 = "aa b c c", s2 = "db b ca", s3 = "aa db bb accc"
     * 输出：false
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/interleaving-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s1
     * @param s2
     * @param s3
     *
     * @return
     */
    public static  boolean isInterleave(String s1, String s2, String s3) {
        int length3 = s3.length();
        int length1 = s2.length();
        int length2 = s1.length();
        if (length1+length2!= length3) {
            return false;
        }

        boolean[][] dp = new boolean[length1 + 1][length2 + 1];

        for (int i = 0; i < length1; i++) {

            for (int j = 0; j < length2; j++) {
                if (i == j && i == 0) {
                    dp[i][j] = true;
                    continue;
                }
                int p = i + j - 1;
                if (i > 0) {
                    dp[i][j] =   (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }

        }

        return  dp[length1][length2];
    }
}





