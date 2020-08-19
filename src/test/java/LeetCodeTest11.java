import com.zhangxx.java8.leetcode.Solution11;
import org.junit.Test;

import java.util.Arrays;

public class LeetCodeTest11 {
    @Test
    public void generateMatrix() {
        int[][] f = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};

        System.out.println(Arrays.deepToString(Solution11.insert(f, new int[]{4, 8})));

    }

    @Test
    public void jump() {

        System.out.println(Solution11.jump(new int[]{1, 2, 3}));
        System.out.println(Solution11.jump(new int[]{3, 2, 1}));
        System.out.println(Solution11.jump(new int[]{2, 3, 1}));
        System.out.println(Solution11.jump(new int[]{2, 3, 1, 4}));
        //                                                1   2          3      4           5
        System.out.println(Solution11.jump(new int[]{1, 2, 3, 5, 6, 4, 1, 2, 3, 5, 6, 7, 1, 55, 2, 34, 5, 6}));

    }

    @Test
    public void manacher() {


//        System.out.println(Arrays.toString(Solution11.manacher("abbadcacda")));
        System.out.println(Arrays.toString(Solution11.manacher("aaaa")));
//        System.out.println( Solution11.countSubstrings("aaa") );


    }
}
