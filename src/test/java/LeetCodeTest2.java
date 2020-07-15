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
        int[] a = {0, 0, 0};
        int[] b = {0, 0, 0};
        int[] c = {0, 0, 0};


        int[][] t = new int[3][3];
        t[0] = a;
        t[1] = b;
        t[2] = c;


        System.out.println(Solution2.uniquePathsWithObstacles(t));

    }

    @Test
    public void uniquePaths() {


        System.out.println(Solution2.uniquePaths(1, 2));
        System.out.println(Solution2.uniquePaths(3, 2));
        System.out.println(Solution2.uniquePaths(7, 3));

    }


}
