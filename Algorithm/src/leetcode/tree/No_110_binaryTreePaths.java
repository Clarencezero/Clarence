package leetcode.tree;

import java.util.*;

public class No_110_binaryTreePaths {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree();
        List<String> res = binaryTreePaths(root);
        for (String re : res) {
            System.out.print(re + " ");
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        Deque<Integer> path = new ArrayDeque<>();
        List<String> result = new ArrayList<>();
        traversal(root, path, result);
        return result;
    }

    private static void traversal(TreeNode root, Deque<Integer> path, List<String> result) {
        // 终止条件
        if (root == null) return;
        path.add(root.val);

        if (root.left == null && root.right == null) {
            // 添加数据到集合
            StringBuilder str = new StringBuilder();
            int size = path.size();
            int i = 0;
            for (Integer integer : path) {
                str.append(integer);
                if (i != size - 1) {
                    str.append("->");
                }
                i++;
            }
            result.add(str.toString());
        }
        traversal(root.left, path, result);
        traversal(root.right, path, result);
        path.removeLast();
    }

}
