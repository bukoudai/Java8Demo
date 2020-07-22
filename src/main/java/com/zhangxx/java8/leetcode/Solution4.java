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
     * @return
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

    /**  戳气球 动态规划
     * n=3
     *    j 0 1 2 3 4
     *  i   1 2 3 4 1
     *  0 1 0 1 0 0 0  (0,3+1)  (0,2) (2,4)
     *  1 2 0 0 0 0 0
     *  2 3 0 0 0 0 0
     *  3 4 0 0 0 0 0
     *  4 1 0 0 0 0 0
     *
     *i< k < j
     *dp[i][j]=max(dp[i][k]+dp[k][j]+v[i]*v[k]*v[j])
     *
     * @param nums
     * @return
     */
    public static int maxCoins_dp(int[] nums) {
        int n = nums.length;
        int[] values=new int[n+2];
        values[0]=1;
        values[n+1]=1;
        System.arraycopy(nums, 0, values, 1, values.length - 1 - 1);
        int[][] dp = new int[n + 2][n + 2];
            // l 区间宽度
            for (int l = 2; l <n+2; l++) {
                for (int left = 0; left+l <n+2; left++) {
                    int right=left+l;
                    for (int k = left + 1; k < right; k++) {
                        // 择优做选择
                        dp[left][right] = Math.max(
                                dp[left][right],
                                dp[left][k] + dp[k][right] + values[left]*values[right]*values[k]
                        );
                    }
                }
            }


        return dp[0][n + 1];


    }


    /**
     * 95. 不同的二叉搜索树 II
     * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
     *
     *  
     *
     * 示例：
     *
     * 输入：3
     * 输出：
     * [
     *   [1,null,3,2],
     *   [3,2,null,1],
     *   [3,1,null,null,2],
     *   [2,1,3],
     *   [1,null,2,null,3]
     * ]
     * 解释：
     * 以上的输出对应以下 5 种不同结构的二叉搜索树：
     *
     *    1         3     3      2      1                       1           2       1
     *     \       /     /      / \      \                        2       1
     *      3     2     1      1   3      2
     *     /     /       \                 \
     *    2     1         2                 3
     *  
     *
     * 提示：
     *
     * 0 <= n <= 8
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public static List<TreeNode> generateTrees(int n) {
         return  n==0?new ArrayList<>():dfs(1,n );
    }

    public static ArrayList<TreeNode> dfs(int start, int end ){


        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        if (start==end) {
            treeNodes.add(new TreeNode(start));
            return treeNodes;
        }
        if (start>end) {
            treeNodes.add(null);
            return treeNodes;
        }
        for (int i = start; i <=end; i++) {
            ArrayList<TreeNode> treeNodesLeft = dfs(start,i-1);
            ArrayList<TreeNode> treeNodesRight = dfs(i+1,end);
            for (TreeNode leftTree : treeNodesLeft) {
                for (TreeNode rightTree : treeNodesRight) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    treeNodes.add(root);
                }
            }


        }

        return treeNodes;


    }

    /**
     * 108. 将有序数组转换为二叉搜索树
     * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
     *
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     *
     * 示例:
     *
     * 给定有序数组: [-10,-3,0,5,9],
     *
     * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
     *
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static TreeNode sortedArrayToBST(int[] nums) {


        return sortedArrayToBST(0,nums.length-1,nums);
    }
    public static TreeNode sortedArrayToBST(int start,int end,int[] nums) {

        if (end==start) {
            return new TreeNode(nums[end]);
        }else   if (end<start) {
            return null;
        }
        int mid =(start+end)>>>1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left=sortedArrayToBST( start,mid-1,nums);
         root.right=sortedArrayToBST(mid+1,end,nums);

        return root;
    }


    /**
     *153. 寻找旋转排序数组中的最小值  剑指 Offer 11. 旋转数组的最小数字 154. 寻找旋转排序数组中的最小值 II
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     *
     * 请找出其中最小的元素。
     *
     * 你可以假设数组中不存在重复元素。
     *
     * 示例 1:
     *
     * 输入: [3,4,5,1,2]
     * 输出: 1
     * 示例 2:
     *
     * 输入: [4,5,6,7,0,1,2]
     * 输出: 0
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     * 可用二分优化...
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {

        int length = nums.length;

        for (int i = 0; i < length-1; i++) {
            if (nums[i]>nums[i+1]) {
                return nums[i+1];
            }
        }
        return nums[0];

    }


    /**
     *64. 最小路径和
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     *
     * 说明：每次只能向下或者向右移动一步。
     *
     * 示例:
     *
     * 输入:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 7
     * 解释: 因为路径 1→3→1→1→1 的总和最小。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-path-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        int h = grid.length;
        if (h==0) {
            return 0;
        }

        int w = grid[0].length;
        if (w==0) {
            return 0;
        }

        int[][] dp =new int[h][w];


        for (int i = h-1; i >=0; i--) {
            for (int j = w-1; j >=0; j--) {

                dp[i][j]=grid[i][j];

                if ( (i<(h-1))&&( j<(w-1))){
                    dp[i][j]  =Math.min(dp[i][j]+dp[i][j+1],dp[i][j]+dp[i+1][j]);

                }else if ( i<(h-1)){
                   dp[i][j]  =dp[i][j]+dp[i+1][j];

               }else  if ( j<(w-1)){
                    dp[i][j]  =dp[i][j]+dp[i][j+1];
                }
            }




        }


return   dp[0][0];


    }
}
