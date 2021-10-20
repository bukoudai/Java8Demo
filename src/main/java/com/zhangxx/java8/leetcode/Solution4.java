package com.zhangxx.java8.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution4 {


  /**
   * 312. 戳气球
   * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
   * <p>
   * 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
   * <p>
   * 求所能获得硬币的最大数量。
   * <p>
   * 说明:
   * <p>
   * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
   * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
   * 示例:
   * <p>
   * 输入: [3,1,5,8]
   * 输出: 167
   * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
   *      coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
   * <p>
   * 3 1 5 8
   * <p>
   * 1 5 8                              3 5 8                               3 1 8                                3 1 5
   * 5 8      1 8      1 5            5 8     3 8         3 5            1 8      3 8         3 1               1 5       3 5         3 1
   * 5    8  1    8   1    5     5    8     3     8     3    5      1     8       3    8      3   1            1  5      3    5       3   1
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/burst-balloons
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   *
   * @param nums
   * @return
   */
  static Map<String, Integer> maxCoins_map = new HashMap<>();

  public static int maxCoins(int[] nums) {
    StringBuilder key = new StringBuilder();
    for (int i = 0; i < nums.length; i++) {
      key.append(nums[i]).append(",");
    }
    Integer integer = maxCoins_map.get(key.toString());
    if (integer != null) {
      return integer;
    }
    if (nums.length == 1) {
      maxCoins_map.put(key.toString(), nums[0]);
      return nums[0];
    }

    int max = 0;
    for (int i = 0; i < nums.length; i++) {

      int[] c = new int[nums.length - 1];
      int ci = 0;
      for (int i1 = 0; i1 < nums.length; i1++) {
        if (i1 != i) {
          c[ci] = nums[i1];
          ci++;
        }
      }
      int coins;
      if (i - 1 < 0) {
        coins = nums[i] * nums[i + 1];
      } else if (i + 1 >= nums.length) {
        coins = nums[i - 1] * nums[i];
      } else {
        coins = nums[i - 1] * nums[i] * nums[i + 1];
      }
      max = Math.max(maxCoins(c) + coins, max);

    }


    maxCoins_map.put(key.toString(), max);
    return max;
  }

  /**
   * 戳气球 动态规划
   * n=3
   * j 0 1 2 3 4
   * i   1 2 3 4 1
   * 0 1 0 1 0 0 0  (0,3+1)  (0,2) (2,4)
   * 1 2 0 0 0 0 0
   * 2 3 0 0 0 0 0
   * 3 4 0 0 0 0 0
   * 4 1 0 0 0 0 0
   * <p>
   * i< k < j
   * dp[i][j]=max(dp[i][k]+dp[k][j]+v[i]*v[k]*v[j])
   *
   * @param nums
   * @return
   */
  public static int maxCoins_dp(int[] nums) {
    int n = nums.length;
    int[] values = new int[n + 2];
    values[0] = 1;
    values[n + 1] = 1;
    System.arraycopy(nums, 0, values, 1, values.length - 1 - 1);
    int[][] dp = new int[n + 2][n + 2];
    // l 区间宽度
    for (int l = 2; l < n + 2; l++) {
      for (int left = 0; left + l < n + 2; left++) {
        int right = left + l;
        for (int k = left + 1; k < right; k++) {
          // 择优做选择
          dp[left][right] = Math.max(
                  dp[left][right],
                  dp[left][k] + dp[k][right] + values[left] * values[right] * values[k]
          );
        }
      }
    }


    return dp[0][n + 1];


  }


  /**
   * 95. 不同的二叉搜索树 II
   * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
   * <p>
   *  
   * <p>
   * 示例：
   * <p>
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
   * <p>
   * 1         3     3      2      1                       1           2       1
   * \       /     /      / \      \                        2       1
   * 3     2     1      1   3      2
   * /     /       \                 \
   * 2     1         2                 3
   *  
   * <p>
   * 提示：
   * <p>
   * 0 <= n <= 8
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   *
   * @param n
   * @return
   */
  public static List<TreeNode> generateTrees(int n) {
    return n == 0 ? new ArrayList<>() : dfs(1, n);
  }

  public static ArrayList<TreeNode> dfs(int start, int end) {


    ArrayList<TreeNode> treeNodes = new ArrayList<>();
    if (start == end) {
      treeNodes.add(new TreeNode(start));
      return treeNodes;
    }
    if (start > end) {
      treeNodes.add(null);
      return treeNodes;
    }
    for (int i = start; i <= end; i++) {
      ArrayList<TreeNode> treeNodesLeft = dfs(start, i - 1);
      ArrayList<TreeNode> treeNodesRight = dfs(i + 1, end);
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
   * <p>
   * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
   * <p>
   * 示例:
   * <p>
   * 给定有序数组: [-10,-3,0,5,9],
   * <p>
   * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
   * <p>
   * 0
   * / \
   * -3   9
   * /   /
   * -10  5
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   *
   * @param nums
   * @return
   */
  public static TreeNode sortedArrayToBST(int[] nums) {


    return sortedArrayToBST(0, nums.length - 1, nums);
  }

  public static TreeNode sortedArrayToBST(int start, int end, int[] nums) {

    if (end == start) {
      return new TreeNode(nums[end]);
    } else if (end < start) {
      return null;
    }
    int mid = (start + end) >>> 1;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = sortedArrayToBST(start, mid - 1, nums);
    root.right = sortedArrayToBST(mid + 1, end, nums);

    return root;
  }


  /**
   * 153. 寻找旋转排序数组中的最小值  剑指 Offer 11. 旋转数组的最小数字 154. 寻找旋转排序数组中的最小值 II
   * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
   * <p>
   * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
   * <p>
   * 请找出其中最小的元素。
   * <p>
   * 你可以假设数组中不存在重复元素。
   * <p>
   * 示例 1:
   * <p>
   * 输入: [3,4,5,1,2]
   * 输出: 1
   * 示例 2:
   * <p>
   * 输入: [4,5,6,7,0,1,2]
   * 输出: 0
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   * <p>
   * <p>
   * 可用二分优化...
   *
   * @param nums
   * @return
   */
  public static int findMin(int[] nums) {

    int length = nums.length;

    for (int i = 0; i < length - 1; i++) {
      if (nums[i] > nums[i + 1]) {
        return nums[i + 1];
      }
    }
    return nums[0];

  }


  /**
   * 64. 最小路径和
   * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
   * <p>
   * 说明：每次只能向下或者向右移动一步。
   * <p>
   * 示例:
   * <p>
   * 输入:
   * [
   *   [1,3,1],
   * [1,5,1],
   * [4,2,1]
   * ]
   * 输出: 7
   * 解释: 因为路径 1→3→1→1→1 的总和最小。
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/minimum-path-sum
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   *
   * @param grid
   * @return
   */
  public static int minPathSum(int[][] grid) {
    int h = grid.length;
    if (h == 0) {
      return 0;
    }

    int w = grid[0].length;
    if (w == 0) {
      return 0;
    }

    int[][] dp = new int[h][w];


    for (int i = h - 1; i >= 0; i--) {
      for (int j = w - 1; j >= 0; j--) {

        dp[i][j] = grid[i][j];

        if ((i < (h - 1)) && (j < (w - 1))) {
          dp[i][j] = Math.min(dp[i][j] + dp[i][j + 1], dp[i][j] + dp[i + 1][j]);

        } else if (i < (h - 1)) {
          dp[i][j] = dp[i][j] + dp[i + 1][j];

        } else if (j < (w - 1)) {
          dp[i][j] = dp[i][j] + dp[i][j + 1];
        }
      }


    }


    return dp[0][0];


  }

  /**
   * 13. 罗马数字转整数
   * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
   * <p>
   * 字符          数值
   * I             1
   * V             5
   * X             10
   * L             50
   * C             100
   * D             500
   * M             1000
   * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
   * <p>
   * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
   * <p>
   * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
   * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
   * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
   * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
   * <p>
   * 示例 1:
   * <p>
   * 输入: "III"
   * 输出: 3
   * 示例 2:
   * <p>
   * 输入: "IV"
   * 输出: 4
   * 示例 3:
   * <p>
   * 输入: "IX"
   * 输出: 9
   * 示例 4:
   * <p>
   * 输入: "LVIII"
   * 输出: 58
   * 解释: L = 50, V= 5, III = 3.
   * 示例 5:
   * <p>
   * 输入: "MCMXCIV"
   * 输出: 1994
   * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/roman-to-integer
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   *
   * @param s
   * @return
   */
  public static int romanToInt(String s) {
    HashMap<String, Integer> map = new HashMap<>();
    map.put("I", 1);
    map.put("V", 5);
    map.put("X", 10);
    map.put("L", 50);
    map.put("C", 100);
    map.put("D", 500);
    map.put("M", 1000);
    map.put("IV", 4);
    map.put("IX", 9);
    map.put("XL", 40);
    map.put("XC", 90);
    map.put("CD", 400);
    map.put("CM", 900);
    Integer ans = 0;

    for (int i = s.length() - 1; i >= 0; i--) {

      char c1 = s.charAt(i);
      if (i - 1 >= 0) {

        char c2 = s.charAt(i - 1);

        Integer integer = map.get(String.valueOf(c2) + c1);

        if (integer != null) {

          ans += integer;
          i--;
        } else {
          integer = map.get(String.valueOf(c1));
          ans += integer;
        }
      } else {
        Integer integer = map.get(String.valueOf(c1));
        ans += integer;
      }


    }
    return ans;
  }


  public static int romanToInt2(String s) {
    int ans = 0;
    //储存前一位
    int highestRank = 0;
    for (int i = s.length() - 1; i >= 0; i--) {

      int rank = getRank(s.charAt(i));
      int val = romanValues[rank];
      if (val < highestRank) {//前一位比当前位大  则减去当前值
        ans -= val;
      } else {
        highestRank = val;
        ans += val;
      }

    }
    return ans;
  }

  public static int[] romanValues = {1, 5, 10, 50, 100, 500, 1000};

  public static int getRank(char ch) {
    switch (ch) {
      case 'I':
        return 0;
      case 'V':
        return 1;
      case 'X':
        return 2;
      case 'L':
        return 3;
      case 'C':
        return 4;
      case 'D':
        return 5;
      case 'M':
        return 6;
      default:
        return -1;
    }
  }

  /**
   * 14. 最长公共前缀
   * 编写一个函数来查找字符串数组中的最长公共前缀。
   * <p>
   * 如果不存在公共前缀，返回空字符串 ""。
   * <p>
   * 示例 1:
   * <p>
   * 输入: ["flower","flow","flight"]
   * 输出: "fl"
   * 示例 2:
   * <p>
   * 输入: ["dog","racecar","car"]
   * 输出: ""
   * 解释: 输入不存在公共前缀。
   * 说明:
   * <p>
   * 所有输入只包含小写字母 a-z 。
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/longest-common-prefix
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   *
   * @param strs
   * @return
   */
  public static String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    String ans = strs[0];
    for (int i = 1; i < strs.length; i++) {
      ans = longestCommonPrefix_CommonPrefix(ans, strs[i]);
    }


    return ans;
  }

  private static String longestCommonPrefix_CommonPrefix(String prefix, String str) {

    if ("".equals(str) || "".equals(prefix)) {
      return "";
    }
    if (prefix.length() > str.length()) {
      return longestCommonPrefix_CommonPrefix(str, prefix);
    }
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < prefix.length(); i++) {
      if (prefix.charAt(i) == str.charAt(i)) {
        ans.append(prefix.charAt(i));
      } else {
        break;
      }


    }


    return ans.toString();
  }

  /**
   * 20. 有效的括号
   * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
   * <p>
   * 有效字符串需满足：
   * <p>
   * 左括号必须用相同类型的右括号闭合。
   * 左括号必须以正确的顺序闭合。
   * 注意空字符串可被认为是有效字符串。
   * <p>
   * 示例 1:
   * <p>
   * 输入: "()"
   * 输出: true
   * 示例 2:
   * <p>
   * 输入: "()[]{}"
   * 输出: true
   * 示例 3:
   * <p>
   * 输入: "(]"
   * 输出: false
   * 示例 4:
   * <p>
   * 输入: "([)]"
   * 输出: false
   * 示例 5:
   * <p>
   * 输入: "{[]}"
   * 输出: true
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/valid-parentheses
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   *
   * @param s
   * @return
   */
  public static boolean isValid(String s) {
    int length = s.length();
    if (length == 0) {
      return true;
    } else {
      if (length % 2 != 0) {
        return false;
      }
    }
    char[] stack = new char[length / 2];
    int index = 0;
    for (int i = 0; i < length; i++) {
      char c = s.charAt(i);
      boolean add = false;
      if (c == '(' || c == '[' || c == '{') {
        add = true;
      }
      if (add) {
        if (index >= stack.length) {
          return false;
        }
        stack[index] = c;

        index++;

      } else {
        if (index <= 0) {
          return false;
        }
        index--;

        switch (c) {
          case ')':
            if (stack[index] != '(') {
              return false;
            }
            break;
          case ']':
            if (stack[index] != '[') {
              return false;
            }
            break;
          case '}':
            if (stack[index] != '{') {
              return false;
            }
            break;
          default:
            return false;
        }

      }
    }
    return index == 0;
  }


}
