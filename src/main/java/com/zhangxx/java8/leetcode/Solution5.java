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
        int ans = nums[0] + nums[1] + nums[2];
        if (nums.length == 3) {
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

                if (i < target) {
                    left++;
                } else if (i > target) {
                    right--;
                } else {
                    return target;
                }
                if (Math.abs(target - i) <= Math.abs(target - ans)) {
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

    /**
     * 18. 四数之和
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     * <p>
     * 注意：
     * <p>
     * 答案中不可以包含重复的四元组。
     * <p>
     * 示例：
     * <p>
     * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
     * <p>
     * 满足要求的四元组集合为：
     * [
     * [-1,  0, 0, 1],
     * [-2, -1, 1, 2],
     * [-2,  0, 0, 2]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/4sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 4) {
            return ans;

        }
        Arrays.sort(nums);

        int minValue = nums[0] + nums[1] + nums[2] + nums[3];
        int maxValue = nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] + nums[nums.length - 4];
        //target是否在最大最小区间内
        if (minValue > target || maxValue < target) {
            return ans;
        }
        for (int p = 0; p < nums.length - 3; p++) {
            if ((p > 0) && (nums[p] == nums[p - 1])) {
                continue;
            }
            //target是否在最大最小区间内
            minValue = nums[p] + nums[p + 1] + nums[p + 2] + nums[p + 3];

            if (minValue > target) {
                continue;
            }
            for (int k = p + 1; k < nums.length - 2; k++) {

                if ((k > p + 1) && (nums[k] == nums[k - 1])) {
                    continue;
                }
                int left = k + 1;
                int right = nums.length - 1;

                minValue = nums[p] + nums[k] + nums[left] + nums[left + 1];
                maxValue = nums[p] + nums[k] + nums[right - 1] + nums[right];
                //target是否在最大最小区间内
                if (minValue > target || maxValue < target) {
                    continue;
                }

                while (left < right) {
                    if ((left - 1) > k && nums[left - 1] == nums[left]) {
                        left++;
                        continue;
                    }
                    if ((right + 1) < (nums.length - 1) && nums[right + 1] == nums[right]) {
                        right--;
                        continue;
                    }

                    int i = nums[p] + nums[k] + nums[right] + nums[left];

                    if (i < target) {
                        left++;
                    } else if (i > target) {
                        right--;
                    } else {
                        List<Integer> list = Arrays.asList(nums[p], nums[k], nums[left], nums[right]);
                        ans.add(list);
                        left++;
                        right--;
                    }


                }

            }
        }


        return ans;
    }

    /**
     * 12. 整数转罗马数字
     * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
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
     * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 3
     * 输出: "III"
     * 示例 2:
     * <p>
     * 输入: 4
     * 输出: "IV"
     * 示例 3:
     * <p>
     * 输入: 9
     * 输出: "IX"
     * 示例 4:
     * <p>
     * 输入: 58
     * 输出: "LVIII"
     * 解释: L = 50, V = 5, III = 3.
     * 示例 5:
     * <p>
     * 输入: 1994
     * 输出: "MCMXCIV"
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/integer-to-roman
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();


        for (int n = 0; n < 4; n++) {
            int x = num % 10;
            ans.insert(0, keyRoman[n][x]);
            num = num / 10;
            if (num <= 0) {
                break;
            }
        }


        return ans.toString();
    }

    private static String[][] keyRoman = new String[4][10];

    static {
        keyRoman[0] = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        keyRoman[1] = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        keyRoman[2] = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        keyRoman[3] = new String[]{"", "M", "MM", "MMM", "", "", "", "", "", ""};
    }

    public static String intToRoman2(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] reps = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 13; i++) {
            while (num >= values[i]) {
                num -= values[i];
                res.append(reps[i]);
            }
        }
        return res.toString();

    }

    /**
     * 392. 判断子序列
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * <p>
     * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
     * <p>
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     * <p>
     * 示例 1:
     * s = "abc", t = "ahbgdc"
     * <p>
     * 返回 true.
     * <p>
     * 示例 2:
     * s = "axc", t = "ahbgdc"
     * <p>
     * 返回 false.
     * <p>
     * 后续挑战 :
     * <p>
     * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/is-subsequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int si = 0;

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(si)) {
                si++;
            }


            if (si >= s.length()) {
                return true;
            }
        }


        return false;
    }


    /**
     * 17. 电话号码的字母组合
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * <p>
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * <p>
     * <p>
     * <p>
     * 示例:
     * <p>
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * 说明:
     * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {

        List<String> re = new LinkedList<>();

        for (int i = 0; i < digits.length(); i++) {
            re = letterCombinations(digits, i, re);
        }


        return re;
    }


    public static List<String> letterCombinations(String digits, int index, List<String> list) {


        List<String> re = new LinkedList<>();
        switch (digits.charAt(index)) {
            case '2':

                if (list.size() == 0) {
                    re.add("a");
                    re.add("b");
                    re.add("c");
                } else {
                    for (String s : list) {
                        re.add(s + "a");
                        re.add(s + "b");
                        re.add(s + "c");
                    }
                }
                break;
            case '3':
                if (list.size() == 0) {
                    re.add("d");
                    re.add("e");
                    re.add("f");
                } else {
                    for (String s : list) {
                        re.add(s + "d");
                        re.add(s + "e");
                        re.add(s + "f");
                    }
                }
                break;
            case '4':
                if (list.size() == 0) {
                    re.add("g");
                    re.add("h");
                    re.add("i");
                } else {
                    for (String s : list) {
                        re.add(s + "g");
                        re.add(s + "h");
                        re.add(s + "i");
                    }
                }
                break;


            case '5':

                if (list.size() == 0) {
                    re.add("j");
                    re.add("k");
                    re.add("l");
                } else {
                    for (String s : list) {
                        re.add(s + "j");
                        re.add(s + "k");
                        re.add(s + "l");
                    }
                }
                break;
            case '6':
                if (list.size() == 0) {
                    re.add("m");
                    re.add("n");
                    re.add("o");
                } else {
                    for (String s : list) {
                        re.add(s + "m");
                        re.add(s + "n");
                        re.add(s + "o");
                    }
                }
                break;
            case '7':
                if (list.size() == 0) {
                    re.add("p");
                    re.add("q");
                    re.add("r");
                    re.add("s");
                } else {
                    for (String s : list) {
                        re.add(s + "p");
                        re.add(s + "q");
                        re.add(s + "r");
                        re.add(s + "s");
                    }
                }
                break;
            case '8':
                if (list.size() == 0) {
                    re.add("t");
                    re.add("u");
                    re.add("v");
                } else {
                    for (String s : list) {
                        re.add(s + "t");
                        re.add(s + "u");
                        re.add(s + "v");
                    }
                }
                break;
            case '9':

                if (list.size() == 0) {
                    re.add("w");
                    re.add("x");
                    re.add("y");
                    re.add("z");
                } else {
                    for (String s : list) {
                        re.add(s + "w");
                        re.add(s + "x");
                        re.add(s + "y");
                        re.add(s + "z");
                    }
                }
                break;

            default:
                break;
        }

        return re;
    }
}
