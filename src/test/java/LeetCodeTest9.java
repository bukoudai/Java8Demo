import com.zhangxx.java8.leetcode.Solution4;
import com.zhangxx.java8.leetcode.Solution9;
import com.zhangxx.java8.leetcode.TreeNode;
import org.junit.Test;

public class LeetCodeTest9 {


    @Test
    public void rob() {


        System.out.println(Solution9.rob(new int[]{2, 7, 9, 11, 1}));


    }

    @Test
    public void rob_2() {


        System.out.println(Solution9.rob_2(new int[]{2, 7, 9, 11, 1}));
        System.out.println(Solution9.rob_2(new int[]{2, 3, 2}));
        System.out.println(Solution9.rob_2(new int[]{1, 1, 1, 2}));
        System.out.println(Solution9.rob_2(new int[]{2, 2, 4, 3, 2, 5}));
        System.out.println(Solution9.rob_2(new int[]{2, 1, 2, 6, 1, 8, 10, 10}));


    }

    @Test
    public void rob_3() {
        int[] a = {10, 3, 0, 5, 9};

        TreeNode treeNode = Solution4.sortedArrayToBST(a);

        System.out.println(Solution9.rob2(treeNode));


    }
}
