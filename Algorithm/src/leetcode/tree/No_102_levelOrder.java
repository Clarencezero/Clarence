package leetcode.tree;

import java.util.*;

public class No_102_levelOrder {
    public static void main(String[] args) {
        No_102_levelOrder go = new No_102_levelOrder();
        TreeNode tree = TreeNode.getTree();
        List<List<Integer>> lists = go.levelOrder(tree);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, 1, res);
        return res;
    }

    private void helper(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) return ;
        if (res.size() < level) {
            res.add(new ArrayList<>());
        }
        res.get(level - 1).add(root.val);
        helper(root.left, level + 1, res);
        helper(root.right, level + 1, res);
    }
}
