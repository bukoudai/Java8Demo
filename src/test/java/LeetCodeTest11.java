import com.zhangxx.java8.leetcode.Solution11;
import org.junit.Test;

import java.util.Arrays;

public class LeetCodeTest11 {
    @Test
    public void generateMatrix() {
        int[][] f = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};

        System.out.println(Arrays.deepToString(Solution11.insert(f, new int[]{4, 8})));

    }
}
