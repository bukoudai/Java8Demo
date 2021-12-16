import com.zhangxx.java8.leetcode.Solution7;
import org.junit.jupiter.api.Test;


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

    @Test
    public void isValidSudoku() {
        char[] t1 = {'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        char[] t2 = {'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        char[] t3 = {'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        char[] t4 = {'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        char[] t5 = {'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        char[] t6 = {'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        char[] t7 = {'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        char[] t8 = {'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        char[] t9 = {'.', '.', '.', '.', '8', '.', '.', '7', '9'};
        char[][] t = new char[9][9];
        t[0] = t1;
        t[1] = t2;
        t[2] = t3;
        t[3] = t4;
        t[4] = t5;
        t[5] = t6;
        t[6] = t7;
        t[7] = t8;
        t[8] = t9;

        long l = System.nanoTime();

        for (int i = 0; i < 100; i++) {
            l = System.nanoTime();
            System.out.println(Solution7.isValidSudoku(t));
            l = System.nanoTime() - l;
            System.out.print("数组: ");
            System.out.println(l);
        }

        for (int i = 0; i < 100; i++) {
            l = System.nanoTime();
            System.out.println(Solution7.isValidSudoku2(t));
            l = System.nanoTime() - l;
            System.out.print("hash: ");
            System.out.println(l);
        }

//        char[] t10 = {'1','2','3','4','5','6','7','8','9'};
//        for (int i = 0; i < t10.length; i++) {
//            System.out.println(t10[i]%9);
//        }
    }

    @Test
    public void countAndSay() {

        System.out.println(Solution7.countAndSay(6));


    }

    @Test
    public void firstMissingPositive() {
        int[] a = new int[]{7, 8, 9, 11, 12};
        int[] b = new int[]{1, 2, 0};
        int[] c = new int[]{3, 4, -1, 1};


//        System.out.println( Solution7.firstMissingPositive(a));
        System.out.println(Solution7.firstMissingPositive(b));


    }
}
