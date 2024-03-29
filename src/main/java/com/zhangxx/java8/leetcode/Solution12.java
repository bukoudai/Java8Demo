package com.zhangxx.java8.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution12 {

  /**
   * 841. 钥匙和房间
   * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
   * <p>
   * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
   * <p>
   * 最初，除 0 号房间外的其余所有房间都被锁住。
   * <p>
   * 你可以自由地在房间之间来回走动。
   * <p>
   * 如果能进入每个房间返回 true，否则返回 false。
   * <p>
   * 示例 1：
   * <p>
   * 输入: [[1],[2],[3],[]]
   * 输出: true
   * 解释:
   * 我们从 0 号房间开始，拿到钥匙 1。
   * 之后我们去 1 号房间，拿到钥匙 2。
   * 然后我们去 2 号房间，拿到钥匙 3。
   * 最后我们去了 3 号房间。
   * 由于我们能够进入每个房间，我们返回 true。
   * 示例 2：
   * <p>
   * 输入：[[1,3],[3,0,1],[2],[0]]
   * 输出：false
   * 解释：我们不能进入 2 号房间。
   * 提示：
   * <p>
   * 1 <= rooms.length <=1000
   * 0 <= rooms[i].length <= 1000
   * 所有房间中的钥匙数量总计不超过3000。
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/keys-and-rooms
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   *
   * @param rooms
   * @return
   */
  public static boolean canVisitAllRooms(List<List<Integer>> rooms) {

    //0 关闭 1打开
    int[] map = new int[rooms.size()];
    canVisitAllRooms_open(rooms, map, 0);
    int sum = 0;
    for (int i = 0; i < map.length; i++) {
      sum = sum + map[i];
    }
    return sum == map.length;
  }

  public static void canVisitAllRooms_open(List<List<Integer>> rooms, int[] map, int index) {

    if (map[index] == 1) {
      return;
    }
    map[index] = 1;
    List<Integer> integers = rooms.get(index);
    for (Integer integer : integers) {
      if (map[integer] != 1) {
        canVisitAllRooms_open(rooms, map, integer);
      }
    }

  }

  /**
   * 70. 爬楼梯
   * 假设你正在爬楼梯。需要 n阶你才能到达楼顶。
   * <p>
   * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
   * <p>
   * 注意：给定 n 是一个正整数。
   * <p>
   * 示例 1：
   * <p>
   * 输入： 2
   * 输出： 2
   * 解释： 有两种方法可以爬到楼顶。
   * 1.  1 阶 + 1 阶
   * 2.  2 阶
   * 示例 2：
   * <p>
   * 输入： 3
   * 输出： 3
   * 解释： 有三种方法可以爬到楼顶。
   * 1.  1 阶 + 1 阶 + 1 阶
   * 2.  1 阶 + 2 阶
   * 3.  2 阶 + 1 阶
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/climbing-stairs
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   *
   * @param n
   * @return
   */
  public int climbStairs(int n) {
    if (n == 0) {
      return n;
    }
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i < dp.length; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }


    return dp[n];


  }

  public int climbStairs_2(int n) {
    if (n == 0) {
      return n;
    }

    int a = 1;
    int b = 1;
    int temp;
    for (int i = 2; i <= n; i++) {
      temp = b;
      b = b + a;
      a = temp;
    }


    return b;


  }

  /**
   * 75. 颜色分类
   * 给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
   * <p>
   * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
   * <p>
   * 注意:
   * 不能使用代码库中的排序函数来解决这道题。
   * <p>
   * 示例:
   * <p>
   * 输入: [2,0,2,1,1,0]
   * 输出: [0,0,1,1,2,2]
   * 进阶：
   * <p>
   * 一个直观的解决方案是使用计数排序的两趟扫描算法。
   * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
   * 你能想出一个仅使用常数空间的一趟扫描算法吗？
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/sort-colors
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   *
   * @param nums
   */
  public void sortColors(int[] nums) {
    //双指针
    int length = nums.length;
    int[] ans = new int[length];
    System.arraycopy(nums, 0, ans, 0, length);
    int s = 0;
    int e = length - 1;

    for (int num : ans) {
      if (num == 0) {
        nums[s] = 0;
        s++;
      } else if (num == 2) {
        nums[e] = 2;
        e--;
      }
    }

    for (int i = s; i <= e; i++) {
      nums[i] = 1;
    }
  }

  /**
   * 257. 二叉树的所有路径
   * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
   * <p>
   * 说明:叶子节点是指没有子节点的节点。
   * <p>
   * 示例:
   * <p>
   * 输入:
   * <p>
   * 1
   * /   \
   * 2     3
   * \
   * 5
   * <p>
   * 输出: ["1->2->5", "1->3"]
   * <p>
   * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/binary-tree-paths
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   *
   * @param root
   * @return
   */
  public List<String> binaryTreePaths(TreeNode root) {

    List<String> ans = new ArrayList<>();

    binaryTreePaths_check(root, ans, "");


    return ans;
  }

  public static void binaryTreePaths_check(TreeNode root, List<String> ans, String value) {
    if (root != null) {
      value = value + root.val;
      if (root.left == null && root.right == null) {
        ans.add(value);
        return;
      }
      if (root.left != null) {
        binaryTreePaths_check(root.left, ans, value + "->");

      }
      if (root.right != null) {
        binaryTreePaths_check(root.right, ans, value + "->");

      }
    }
  }


  /***
   * 396. 旋转函数
   * 给定一个长度为 n 的整数数组nums。
   *
   * 假设arrk是数组nums顺时针旋转 k 个位置后的数组，我们定义nums的 旋转函数F为：
   *
   * F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1]
   * 返回F(0), F(1), ..., F(n-1)中的最大值。
   *
   * 生成的测试用例让答案符合32 位 整数。
   *
   *
   *
   * 示例 1:
   *
   * 输入: nums = [4,3,2,6]
   * 输出: 26
   * 解释:  3+1 =4
   * i F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
   * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
   * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
   * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
   * 所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。
   * 示例 2:
   *
   * 输入: nums = [100]
   * 输出: 0
   *
   * 把数组逆转跟把乘数逆转是一样的，可以看出有如下规律
   *   4     3     2     6
   *
   *  0*4   1*3   2*2   3*6   F(0)
   *
   *  1*4   2*3   3*2   0*6   F(1) = F(0) + SUM(data) - (N )* data[N-i];
   *
   *  2*4   3*3   0*2   1*6   F(2) = F(1) - SUM(data) + N * data[1];
   *
   *  3*4   0*3   1*2   2*6   F(3) = F(2) - SUM(data) + N * data[2];
   * 提示:
   *
   * n == nums.length
   * 1 <= n <= 105
   * -100 <= nums[i] <= 100
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/rotate-function
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   * @param nums
   * @return
   */
  public static int maxRotateFunction(int[] nums) {

    int length = nums.length;
    int sum = 0;
    int tmp = 0;
    for (int i = 0; i < length; i++) {
      sum = sum + nums[i];
      tmp = tmp + nums[i] * i;


    }

    int max = tmp;
    for (int i = 1; i < length; i++) {
      tmp = tmp + sum - (length) * nums[length - i];


      if (tmp > max) {
        max = tmp;
      }
    }


    return max;
  }


}
