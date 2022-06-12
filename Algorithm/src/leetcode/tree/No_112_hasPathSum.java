package leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class No_112_hasPathSum {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree2();
        List<List<Integer>> lists = pathSum(root, 22);
        System.out.println(lists);
    }


    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null) return res;

        dfs(root, path, res, targetSum);

        return res;
    }

    private static void dfs(TreeNode root, List<Integer> path, List<List<Integer>> res, int targetSum) {
        if (root == null) return ;
        if (root.val == targetSum && root.left == null && root.right == null) {
            // 将结果添加到res集合中
            path.add(root.val);
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(root.val);
        dfs(root.left, path, res, targetSum - root.val);
        dfs(root.right, path, res, targetSum - root.val);

        path.remove(path.size() - 1); // 回溯
    }

    private static void postOrder(TreeNode root) {
        if (root == null) return;
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        TreeNode prev = null;

        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.addLast(p);
                p = p.left;
            }
            TreeNode node = stack.peekLast();
            if (node.right != null && node.right != prev) {
                // 处理右节点
                p = node.right;
                continue;
            } else {
                // 处理左节点,
                node = stack.pollLast();
                res.add(node.val);
                prev = node;
            }
        }

        for (Integer re : res) {
            System.out.print(re + " ");
        }

    }
}
