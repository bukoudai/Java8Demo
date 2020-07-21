package com.zhangxx.java8.leetcode;

import java.util.List;

public class TreeNode {
    int val;
    int count;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
        count = 0; // 记录小于当前节点值的个数
    }

    public static TreeNode add(TreeNode root, TreeNode inset, List<Integer> re, int index){
        if (root == null) {
            root = inset;
            return root;
        }
        if (root.val >= inset.val) { // 注意小于等于插入到左子树，防止多加1
            root.count++; // 小于根节点，则小于根节点的数量count++
            root.left = add(root.left, inset, re, index);
        } else {
            re.set(index,root.count + 1) ; // 累加小于当前节点的个数和当前节点(1)
            root.right = add(root.right, inset, re, index);
        }
        return inset;
    }


    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
         this.left = left;
         this.right = right;
     }

    @Override
    public String toString() {

StringBuilder a =new StringBuilder( ).append(val) .append(left) .append(right);

        return a.toString();
    }
}
