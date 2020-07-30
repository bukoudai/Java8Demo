import com.zhangxx.java8.leetcode.Solution7;
import org.junit.Test;

import java.util.Arrays;

public class LeetCodeTest7 {

    @Test
    public void search() {
        int[] a = new int[]{4, 5, 6, 7, 0, 1, 2};
        int[] b = new int[]{3, 5, 1};
        int[] c = new int[]{5, 1, 3};
        int[] d = new int[]{4, 5, 6, 7, 8, 1, 2, 3};
        int[] e = new int[]{8, 9, 2, 3, 4, 5, 6, 7};
        int[] f = new int[]{5, 1, 2, 3, 4};
        int[] g = new int[]{1, 3};
        System.out.println(Solution7.search(a, 0));
        System.out.println(Solution7.search(a, 3));
        System.out.println(Solution7.search(b, 3));
        System.out.println(Solution7.search(b, 1));
        System.out.println(Solution7.search(c, 3));
        System.out.println(Solution7.search(d, 8));
        System.out.println(Solution7.search(e, 6));
        System.out.println(Solution7.search(f, 1));
        System.out.println(Solution7.search(g, 2));


    }

    @Test
    public void searchRange() {
        int[] a = new int[]{5, 7, 7, 8, 8, 10};
        int[] b = new int[]{};
        int[] c = new int[]{2, 2};

//        System.out.println(Arrays.toString(Solution7.searchRange(a,  10)));
//        System.out.println(Arrays.toString(Solution7.searchRange(b,  1)));
        System.out.println(Arrays.toString(Solution7.searchRange(c, 2)));


    }
}
