import com.zhangxx.java8.leetcode.Node;
import com.zhangxx.java8.leetcode.Solution10;
import org.junit.Test;

import java.util.ArrayList;
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
}
