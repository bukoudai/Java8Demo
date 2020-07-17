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



}
