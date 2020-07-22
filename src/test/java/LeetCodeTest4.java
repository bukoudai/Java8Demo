import com.zhangxx.java8.leetcode.Solution4;
import com.zhangxx.java8.leetcode.TreeNode;
import org.junit.Test;

public class LeetCodeTest4 {

    @Test
    public void isInterleave() {

//        int[] c = {7,9,8,0,7,1,3,5,5,2,3,3};
        int[] c = {8, 3, 4, 3, 5, 0, 5, 6, 6, 2, 8, 5, 6, 2, 3, 8, 3, 5, 1, 0, 2};
//        int[] c = {1,2, 3 };

//        System.out.println(Solution4.maxCoins(c));
        System.out.println(Solution4.maxCoins_dp(c));


    }

    @Test
    public void generateTrees() {


//        System.out.println(Solution4.generateTrees(1));
        System.out.println(Solution4.generateTrees(2));
//        System.out.println(Solution4.generateTrees(3));
//        System.out.println(Solution4.generateTrees(4));


    }
    @Test
    public void sortedArrayToBST() {

        int[] a ={-10,-3,0,5,9};

        TreeNode treeNode = Solution4.sortedArrayToBST(a);
        System.out.println(treeNode);

    }
    @Test
    public void minPathSum() {

        int[] a ={1,3,1};

        int[] b = {1,5,1};
        int[] c = {4,2,1};


        int[][] t = new int[3][3];
        t[0] = a;
        t[1] = b;
        t[2] = c;
        System.out.println(Solution4.minPathSum(t));

    }
}
