package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中序遍历：[3, 4, 5, 6, 7, 8]
 */
public class No_in_order_traversal {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree();
        List<Integer> res = inorderTraversal(root);
        System.out.println(res);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(res, root);
        return res;
    }

    private static void inOrder(List<Integer> res, TreeNode node) {
        if (node == null) return;
        inOrder(res, node.left);
        res.add(node.val);
        inOrder(res, node.right);
    }
}
