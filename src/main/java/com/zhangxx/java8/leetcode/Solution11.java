package com.zhangxx.java8.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

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
}
