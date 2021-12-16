import com.zhangxx.java8.leetcode.Solution11;

import org.junit.jupiter.api.*;

import java.util.Arrays;
@DisplayName("LeetCodeTest11")
public class LeetCodeTest11 {

    @BeforeAll
    public static void init() {
        System.out.println("初始化数据");
    }

    @AfterAll
    public static void cleanup() {
        System.out.println("清理数据");
    }

    @BeforeEach
    public void tearup() {
        System.out.println("当前测试方法开始");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("当前测试方法结束");
    }

    @DisplayName("57. 插入区间")
    @Test
    public void insert() {
        int[][] f = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        Assertions.assertArrayEquals(Solution11.insert(f, new int[]{4, 8}),new int[][]{{1, 2}, {3, 10}, {12, 16}},"[[1, 2], [3, 10], [12, 16]]");
    }
    @Disabled
    @Test
    public void jump() {

        System.out.println(Solution11.jump(new int[]{1, 2, 3}));
        System.out.println(Solution11.jump(new int[]{3, 2, 1}));
        System.out.println(Solution11.jump(new int[]{2, 3, 1}));
        System.out.println(Solution11.jump(new int[]{2, 3, 1, 4}));
        //                                                1   2          3      4           5
        System.out.println(Solution11.jump(new int[]{1, 2, 3, 5, 6, 4, 1, 2, 3, 5, 6, 7, 1, 55, 2, 34, 5, 6}));

    }
    @Disabled
    @Test
    public void manacher() {


//        System.out.println(Arrays.toString(Solution11.manacher("abbadcacda")));
        System.out.println(Arrays.toString(Solution11.manacher("aaaa")));
//        System.out.println( Solution11.countSubstrings("aaa") );


    }
    @Disabled
    @Test
    public void updateBoard() {


        //                                                1   2          3      4           5
        System.out.println(Arrays.deepToString(Solution11.updateBoard(new char[][]{
                new char[]{'E', 'E', 'E', 'E', 'E'}
                , new char[]{'E', 'E', 'M', 'E', 'E'}
                , new char[]{'E', 'E', 'E', 'E', 'E'}
                , new char[]{'E', 'E', 'E', 'E', 'E'}}, new int[]{3, 0})));

    }
    @Disabled
    @Test
    public void mySqrt() {


        //                                                1   2          3      4           5
        System.out.println(Solution11.mySqrt(100));

    }
    @Disabled
    @Test
    public void simplifyPath() {


        //                                                1   2          3      4           5
        System.out.println(Solution11.simplifyPath("/a/b/c"));
        System.out.println(Solution11.simplifyPath("/a/./b/../../c/"));
        System.out.println(Solution11.simplifyPath("/../"));
        System.out.println(Solution11.simplifyPath("/..."));
        System.out.println(Solution11.simplifyPath("/../"));

    }
}
