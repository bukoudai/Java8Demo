import com.zhangxx.java8.leetcode.Solution2;
import com.zhangxx.java8.leetcode.Solution3;
import org.junit.Test;

public class LeetCodeTest3 {


    @Test
    public void searchInsert() {

        int[] a = { };
        int[] c = {1,3};
        int[] b = {1,3,5,6};
        System.out.println(Solution3.searchInsert(c,2));
        System.out.println(Solution3.searchInsert(b,5));
        System.out.println(Solution3.searchInsert(b,2));
        System.out.println(Solution3.searchInsert(b,7));
        System.out.println(Solution3.searchInsert(b,0));
        System.out.println(Solution3.searchInsert(a,0));
        System.out.println(Solution3.searchInsert(c,0));



    }
    @Test
    public void findLength2() {


        int[] c = {1,2,3,4,5,6,7,5,2};
        int[] b = {2,2,3,4,5,2};
        System.out.println(Solution3.findLength2(c,b));




    }
    @Test
    public void kthSmallest() {


        int[] a = {1,4};
        int[] b = {2,5};
        int[] c = {12,13,15};

        int[][] t = new int[2][2];
        t[0] = a;
        t[1] = b;
//        t[2] = c;

        System.out.println(Solution3.kthSmallest(t,2));




    }

    @Test
    public void isInterleave() {

      String  s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";

        System.out.println(Solution3.isInterleave(s1,s2,s3));
        s1 = "aabcc"; s2 = "dbbca";s3 = "aadbbbaccc";
        System.out.println(Solution3.isInterleave(s1,s2,s3));




    }

    /***
     * 用动态规划优化斐波那契数列
     *
     */
    @Test
    public   void fibonacciTest( ) {
        int n=45;
        long l = System.currentTimeMillis();
        System.out.println(fibonacci(n));
        long end = System.currentTimeMillis()-l;
        System.out.println(end);


          l = System.currentTimeMillis();
        System.out.println(fibonacci2(n));
          end = System.currentTimeMillis()-l;
        System.out.println(end);
    }
    public static double fibonacci(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    public static double fibonacci2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        double pre=1;
        double preNext=2;
        double ans=0;
        for (int i = 3; i <= n; i++) {
            ans=pre+preNext;
            pre=preNext;
            preNext=ans;

        }

        return ans;
    }


}
