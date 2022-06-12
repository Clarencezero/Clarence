package leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class No_538_convertBST {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.getBST2();
        convertBST(tree);
        List<String> list = new LinkedList<>();
        list.add(0, "helloworld");
        list.add(0, "helloworld2");
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        int sum = 0;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.addLast(p);
                p = p.right;
                continue;
            }
            TreeNode node = stack.pollLast();
            sum += node.val;
            node.val = sum;
            p = node.left;
        }
        return root;
    }
}
