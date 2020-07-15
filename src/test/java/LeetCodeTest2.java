import com.zhangxx.java8.leetcode.Solution2;
import org.junit.Test;

public class LeetCodeTest2 {


    @Test
    public void minimumTotal() {


        System.out.println(Solution2.numTrees(2));
        System.out.println(Solution2.numTrees(3));
        System.out.println(Solution2.numTrees(4));
        System.out.println(Solution2.numTrees(5));
        System.out.println(Solution2.numTrees(6));


    }

    @Test
    public void uniquePathsWithObstacles() {
        int[] a = {1};
        int[] b = {0, 0, 0};
        int[] c = {0, 0, 0};

        /**
         *   int[] a = { 18,4,-3};
         *         int[] b = { 16,11,5};
         *         int[] c = { -14,-24,6};
         */
        int[][] t = new int[1][1];
        t[0] = a;
//        t[1] = b;
//        t[2] = c;


        System.out.println(Solution2.uniquePathsWithObstacles(t));


    }


}
