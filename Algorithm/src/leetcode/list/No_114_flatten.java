package leetcode.list;

import leetcode.tree.TreeNode;

public class No_114_flatten {
    public static void main(String[] args) {
        No_114_flatten go = new No_114_flatten();
        TreeNode tree = TreeNode.getTree();
        go.flatten(tree);
    }

    public void flatten(TreeNode root) {
        if (root == null) return ;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode right = cur.right;
                cur.right = cur.left;
                // 找到最右节点
                TreeNode p = cur.right;
                while (p.right != null) {
                    p = p.right;
                }
                p.right = right;
            } else {
                cur = cur.right;
            }
        }
    }
}
