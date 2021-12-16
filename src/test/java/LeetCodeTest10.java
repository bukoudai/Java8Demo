import com.zhangxx.java8.leetcode.Node;
import com.zhangxx.java8.leetcode.Solution10;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCodeTest10 {

    @Test
    public void flatten() {


        Node n1 = new Node(1);
        Node n2 = new Node(2);
        List<Node> l1 = new ArrayList<>();
        l1.add(n2);
        List<Node> l2 = new ArrayList<>();
        l2.add(n1);
        n1.neighbors = l1;
        n2.neighbors = l2;
        Node node = Solution10.cloneGraph(n1);

        System.out.println(node);
    }

    @Test
    public void generateParenthesis() {


        System.out.println(Solution10.generateParenthesis(3));
    }

    @Test
    public void spiralOrder() {

        int[][] f = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Solution10.spiralOrder(f));
        System.out.println(Solution10.spiralOrder(a));
    }

    @Test
    public void generateMatrix() {


        System.out.println(Arrays.deepToString(Solution10.generateMatrix(2)));

    }
}
