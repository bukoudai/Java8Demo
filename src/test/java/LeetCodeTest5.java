import com.zhangxx.java8.leetcode.Solution5;
import org.junit.Test;

public class LeetCodeTest5 {

    @Test
    public void sortedArrayToBST() {

        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};


//        System.out.println( Solution5.maxArea(a));
        System.out.println(Solution5.maxArea2(a));

    }

    @Test
    public void threeSum() {

        int[] a = {-1, 0, 1, 2, -1, -4};
        int[] b = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        int[] c = {-5, 0, -2, 3, -2, 1, 1, 3, 0, -5, 3, 3, 0, -1};


        System.out.println(Solution5.threeSum(a));
        System.out.println(Solution5.threeSum2(a));
        System.out.println(Solution5.threeSum(b));
        System.out.println(Solution5.threeSum2(b));
        System.out.println(Solution5.threeSum(c));
        System.out.println(Solution5.threeSum2(c));

    }


    @Test
    public void threeSumClosest() {
        int[] a = {-1, 2, 1, -4};
        int[] b = {1, 1, -1, -1, 3};


//        System.out.println(Solution5.threeSumClosest(a,1));
        System.out.println(Solution5.threeSumClosest(b, -1));


    }

    @Test
    public void fourSum() {
        int[] a = {-1, 2, 1, -4};
        int[] b = {1, 0, -1, 0, -2, 2};
        int[] c = {0, 0, 0, 0};


//        System.out.println(Solution5.threeSumClosest(a,1));
//        System.out.println(Solution5.fourSum(b, 0));
        System.out.println(Solution5.fourSum(c, 0));


    }

    @Test
    public void intToRoman() {

        System.out.println(Solution5.intToRoman(1993));
        System.out.println(Solution5.intToRoman(58));


    }

    @Test
    public void letterCombinations() {

        System.out.println(Solution5.letterCombinations("23"));
        System.out.println(Solution5.letterCombinations("58"));


    }
}
