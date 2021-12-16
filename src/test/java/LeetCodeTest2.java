import com.zhangxx.java8.leetcode.Solution2;
import org.junit.jupiter.api.Test;


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

    @Test
    public void findMedianSortedArrays() {

        int[] a = {1, 2};
        int[] b = {3, 4};
        System.out.println(Solution2.findMedianSortedArrays(a, b));

    }

    @Test
    public void longestPalindrome() {


        System.out.println(Solution2.longestPalindrome("babad"));
        System.out.println(Solution2.longestPalindrome("cbbd"));
        System.out.println(Solution2.longestPalindrome("aa"));

    }

    @Test
    public void convert() {


        System.out.println(Solution2.convert("LEETCODEISHIRING", 4));


    }

    @Test
    public void reverse() {


        System.out.println(Solution2.reverse(1534236469));
        System.out.println(Solution2.reverse2(1534236469));
        System.out.println(Solution2.reverse3(1534236469));


    }

    @Test
    public void myAtoi() {


        System.out.println(Solution2.myAtoi("42"));
        System.out.println(Solution2.myAtoi("   -42"));
        System.out.println(Solution2.myAtoi("4193 with words"));
        System.out.println(Solution2.myAtoi("words and 987"));
        System.out.println(Solution2.myAtoi("-91283472332"));
        System.out.println(Solution2.myAtoi(""));
        System.out.println(Solution2.myAtoi(" "));
        System.out.println(Solution2.myAtoi("-"));
        System.out.println(Solution2.myAtoi("-+2"));
        System.out.println(Solution2.myAtoi("20000000000000000000"));


    }

    @Test
    public void isBipartite() {


        int[] a = {1, 2, 3};
        int[] b = {0, 2};
        int[] c = {0, 1, 3};
        int[] d = {0, 2};
        int[][] t = new int[4][];
        t[0] = a;
        t[1] = b;
        t[2] = c;
        t[3] = d;
        System.out.println(Solution2.isBipartite(t));

    }

    @Test
    public void isBipartite2() {
        int[] a = {1, 3};
        int[] b = {0, 2};
        int[] c = {1, 3};
        int[] d = {0, 2};
        int[][] t = new int[4][];
        t[0] = a;
        t[1] = b;
        t[2] = c;
        t[3] = d;
        System.out.println(Solution2.isBipartite(t));

    }

    @Test
    public void isBipartite3() {
        //     [[3],[2,4],[1],[0,4],[1,3]]
        int[] a = {3};
        int[] b = {2, 4};
        int[] c = {1};
        int[] d = {0, 4};
        int[] e = {1, 3};
        int[][] t = new int[5][];
        t[0] = a;
        t[1] = b;
        t[2] = c;
        t[3] = d;
        t[4] = e;
        System.out.println(Solution2.isBipartite(t));

    }


}
