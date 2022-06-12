package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 前序遍历：[5, 3, 4, 7, 6, 8]
 */
public class No_145_pre_order {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree();
        List<Integer> res = new ArrayList<>();
        preOrder(res, root);
        System.out.println(res);
    }

    private static void preOrder(List<Integer> res, TreeNode root) {
        if (root == null) return ;
        res.add(root.val);
        preOrder(res, root.left);
        preOrder(res, root.right);

    }
}
