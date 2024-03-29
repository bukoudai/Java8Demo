package com.zhangxx.java8.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

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

  /**
   * 529. 扫雷游戏
   * 让我们一起来玩扫雷游戏！
   * <p>
   * 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
   * <p>
   * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
   * <p>
   * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
   * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
   * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
   * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
   *  
   * <p>
   * 示例 1：
   * <p>
   * 输入:
   * <p>
   * [['E', 'E', 'E', 'E', 'E'],
   * ['E', 'E', 'M', 'E', 'E'],
   * ['E', 'E', 'E', 'E', 'E'],
   * ['E', 'E', 'E', 'E', 'E']]
   * <p>
   * Click : [3,0]
   * <p>
   * 输出:
   * <p>
   * [['B', '1', 'E', '1', 'B'],
   * ['B', '1', 'M', '1', 'B'],
   * ['B', '1', '1', '1', 'B'],
   * ['B', 'B', 'B', 'B', 'B']]
   * <p>
   * 解释:
   * <p>
   * 示例 2：
   * <p>
   * 输入:
   * <p>
   * [['B', '1', 'E', '1', 'B'],
   * ['B', '1', 'M', '1', 'B'],
   * ['B', '1', '1', '1', 'B'],
   * ['B', 'B', 'B', 'B', 'B']]
   * <p>
   * Click : [1,2]
   * <p>
   * 输出:
   * <p>
   * [['B', '1', 'E', '1', 'B'],
   * ['B', '1', 'X', '1', 'B'],
   * ['B', '1', '1', '1', 'B'],
   * ['B', 'B', 'B', 'B', 'B']]
   * <p>
   * 解释:
   * <p>
   *  
   * <p>
   * 注意：
   * <p>
   * 输入矩阵的宽和高的范围为 [1,50]。
   * 点击的位置只能是未被挖出的方块 ('M' 或者 'E')，这也意味着面板至少包含一个可点击的方块。
   * 输入面板不会是游戏结束的状态（即有地雷已被挖出）。
   * 简单起见，未提及的规则在这个问题中可被忽略。例如，当游戏结束时你不需要挖出所有地雷，考虑所有你可能赢得游戏或标记方块的情况。
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/minesweeper
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   *
   * @param board
   * @param click
   * @return
   */
  public static char[][] updateBoard(char[][] board, int[] click) {
    if (click.length == 0) {
      return board;
    }
    int y = click[0];
    int x = click[1];
    //点击位置是否是地雷
    if (board[y][x] == 'M') {
      board[y][x] = 'X';
      return board;
    }
    //点击位置周围是否有地雷
    int length = board.length;
    updateBoard_update(board, x, y, length);

    return board;


  }

  private static void updateBoard_update(char[][] board, int x, int y, int length) {
    if (board[y][x] == 'B') {
      return;
    } else {
      board[y][x] = 'B';
    }
    char checkNum = updateBoard_checkNum(board, x, y, length);
    if (checkNum > '0') {
      board[y][x] = checkNum;
    } else {
      //左上
      if (((y - 1) >= 0) && ((x - 1) >= 0)) {
        updateBoard_update(board, x - 1, y - 1, length);
      }
      //上
      if ((y - 1) >= 0) {
        updateBoard_update(board, x, y - 1, length);
      }
//右上
      if (((y - 1) >= 0) && ((x + 1) < board[y].length)) {
        updateBoard_update(board, x + 1, y - 1, length);
      }
      //左
      if ((x - 1) >= 0) {
        updateBoard_update(board, x - 1, y, length);
      }

      //右
      if ((x + 1) < board[y].length) {
        updateBoard_update(board, x + 1, y, length);
      }
      //左下
      if (((y + 1) < length) && ((x - 1) >= 0)) {
        updateBoard_update(board, x - 1, y + 1, length);
      }
      //下
      if ((y + 1) < length) {
        updateBoard_update(board, x, y + 1, length);
      }
      //右下
      if (((y + 1) < length) && ((x + 1) < board[y].length)) {
        updateBoard_update(board, x + 1, y + 1, length);
      }
    }

  }


  //判断地雷数
  private static char updateBoard_checkNum(char[][] board, int x, int y, int length) {

    char count = '0';
    //左上
    if (((y - 1) >= 0) && ((x - 1) >= 0)) {
      if (board[y - 1][x - 1] == 'M') {
        count++;
      }
    }
    //上
    if ((y - 1) >= 0) {
      if (board[y - 1][x] == 'M') {
        count++;
      }
    }
    //右上
    if (((y - 1) >= 0) && ((x + 1) < board[y].length)) {
      if (board[y - 1][x + 1] == 'M') {
        count++;
      }
    }
    //左
    if ((x - 1) >= 0) {
      if (board[y][x - 1] == 'M') {
        count++;
      }
    }
    //右
    if ((x + 1) < board[y].length) {
      if (board[y][x + 1] == 'M') {
        count++;
      }
    }
    //左下
    if (((y + 1) < length) && ((x - 1) >= 0)) {
      if (board[y + 1][x - 1] == 'M') {
        count++;
      }
    }
    //右下
    if (((y + 1) < length) && ((x + 1) < board[y].length)) {
      if (board[y + 1][x + 1] == 'M') {
        count++;
      }
    }
    //下
    if ((y + 1) < length) {
      if (board[y + 1][x] == 'M') {
        count++;
      }
    }

    return count;
  }

  /**
   * 69. x 的平方根
   * 实现 int sqrt(int x) 函数。
   * <p>
   * 计算并返回 x 的平方根，其中 x 是非负整数。
   * <p>
   * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
   * <p>
   * 示例 1:
   * <p>
   * 输入: 4
   * 输出: 2
   * 示例 2:
   * <p>
   * 输入: 8
   * 输出: 2
   * 说明: 8 的平方根是 2.82842...,
   *      由于返回类型是整数，小数部分将被舍去。
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/sqrtx
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   *
   * @param x
   * @return
   */
  public static int mySqrt(int x) {

    int max = x;
    int min = 0;
    int mid = min + (max - min) / 2;
    while (min < max) {


      if (min * min == x) {
        return min;
      }
      if (max == x / max) {
        return max;
      }
      mid = min + (max - min) / 2;
      if (mid == 0) {
        return min;
      }
      if (mid > x / mid) {
        max = mid - 1;
      } else if (mid == x / mid) {
        return mid;
      } else {
        min = mid + 1;
      }
    }

    return mid;

  }

  /**
   * 88. 合并两个有序数组
   * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
   * <p>
   *  
   * <p>
   * 说明:
   * <p>
   * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
   * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
   *  
   * <p>
   * 示例:
   * <p>
   * 输入:
   * nums1 = [1,2,3,0,0,0], m = 3
   * nums2 = [2,5,6],       n = 3
   * <p>
   * 输出: [1,2,2,3,5,6]
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/merge-sorted-array
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   *
   * @param nums1
   * @param m
   * @param nums2
   * @param n
   */
  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    m = m - 1;
    n = n - 1;
    for (int i = nums1.length - 1; i >= 0; i--) {
      if (m >= 0 && n >= 0) {
        if (nums1[m] >= nums2[n]) {
          nums1[i] = nums1[m];
          m--;
        } else {
          nums1[i] = nums2[n];
          n--;
        }
      } else if (n < 0) {
        nums1[i] = nums1[m];
        m--;
      } else {
        nums1[i] = nums2[n];
        n--;
      }
    }
  }


  /**
   * 111. 二叉树的最小深度
   * 给定一个二叉树，找出其最小深度。
   * <p>
   * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
   * <p>
   * 说明: 叶子节点是指没有子节点的节点。
   * <p>
   * 示例:
   * <p>
   * 给定二叉树 [3,9,20,null,null,15,7],
   * <p>
   * 3
   * / \
   * 9  20
   * /  \
   * 15   7
   * 返回它的最小深度  2.
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   *
   * @param root
   * @return
   */

  public int minDepth(TreeNode root) {

    if (root == null) {
      return 0;
    }
    int min = 1;
    if (root.left == null) {
      return min + minDepth(root.right);
    }
    if (root.right == null) {
      return min + minDepth(root.left);
    }


    min = min + Math.min(minDepth(root.left), minDepth(root.right));


    return min;


  }

  /**
   * 71. 简化路径
   * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
   * <p>
   * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
   * <p>
   * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
   * <p>
   *  
   * <p>
   * 示例 1：
   * <p>
   * 输入："/home/"
   * 输出："/home"
   * 解释：注意，最后一个目录名后面没有斜杠。
   * 示例 2：
   * <p>
   * 输入："/../"
   * 输出："/"
   * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
   * 示例 3：
   * <p>
   * 输入："/home//foo/"
   * 输出："/home/foo"
   * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
   * 示例 4：
   * <p>
   * 输入："/a/./b/../../c/"
   * 输出："/c"
   * 示例 5：
   * <p>
   * 输入："/a/../../b/../c//.//"
   * 输出："/c"
   * 示例 6：
   * <p>
   * 输入："/a//b////c/d//././/.."
   * 输出："/a/b/c"
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/simplify-path
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   *
   * @param path
   * @return
   */
  public static String simplifyPath(String path) {
    String[] split = path.split("/");


    Stack<String> ans = new Stack<>();

    for (int i = 0; i < split.length; i++) {
      String s = split[i];
      if (!"".equals(s)) {
        //判断压栈出栈
        if ("..".equals(s)) {
          //出栈
          if (!ans.empty()) {
            ans.pop();
          }
        } else if (!".".equals(s)) {
          ans.push(s);
        }
      }
    }
    if (ans.empty()) {
      return "/";
    }
    StringBuilder a = new StringBuilder();
    while (!ans.empty()) {

      a.insert(0, "/" + ans.pop());
    }


    return a.toString();

  }

  /**
   * 459. 重复的子字符串
   * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
   * <p>
   * 示例 1:
   * <p>
   * 输入: "abab"
   * <p>
   * 输出: True
   * <p>
   * 解释: 可由子字符串 "ab" 重复两次构成。
   * 示例 2:
   * <p>
   * 输入: "aba"
   * <p>
   * 输出: False
   * 示例 3:
   * <p>
   * 输入: "abcabcabcabc"
   * <p>
   * 输出: True
   * <p>
   * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/repeated-substring-pattern
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   *
   * @param s
   * @return
   */
  public boolean repeatedSubstringPattern(String s) {
    return (s + s).indexOf(s, 1) != s.length();

  }

  /**
   * 657. 机器人能否返回原点
   * 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
   * <p>
   * 移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
   * <p>
   * 注意：机器人“面朝”的方向无关紧要。 “R” 将始终使机器人向右移动一次，“L” 将始终向左移动等。此外，假设每次移动机器人的移动幅度相同。
   * <p>
   *  
   * <p>
   * 示例 1:
   * <p>
   * 输入: "UD"
   * 输出: true
   * 解释：机器人向上移动一次，然后向下移动一次。所有动作都具有相同的幅度，因此它最终回到它开始的原点。因此，我们返回 true。
   * 示例 2:
   * <p>
   * 输入: "LL"
   * 输出: false
   * 解释：机器人向左移动两次。它最终位于原点的左侧，距原点有两次 “移动” 的距离。我们返回 false，因为它在移动结束时没有返回原点。
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/robot-return-to-origin
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   *
   * @param moves
   * @return
   */
  public boolean judgeCircle(String moves) {
    int x = 0;
    int y = 0;

    int length = moves.length();
    for (int i = 0; i < length; i++) {
      char c = moves.charAt(i);
      switch (c) {
        case 'R':
          x++;
          break;
        case 'L':
          x--;
          break;
        case 'U':
          y++;
          break;
        case 'D':
          y--;
          break;
        default:
          return false;

      }
    }

    return x == 0 && y == 0;


  }

  public boolean judgeCircle_2(String moves) {
    int[] letters = new int[26 + 'A'];
    for (char c : moves.toCharArray()) {
      letters[c]++;
    }
    return letters['U'] == letters['D'] && letters['L'] == letters['R'];


  }


}
