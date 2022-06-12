package leetcode.tree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class No_113_pathSum {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree2();
        List<List<Integer>> lists = pathSum(root, 22);
    }


    private static List<List<Integer>> res = new ArrayList<>();
    private static Deque<Integer> path = new ArrayDeque<>();

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return res;

        getAllpath(root, path, targetSum);

        return res;
    }

    private static void getAllpath(TreeNode root, Deque<Integer> path, int targetSum) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null && root.val == targetSum) {
            // 将path的路径添加到集合中
            List<Integer> list = new ArrayList<>();
            for (Integer i : path) {
                list.add(i);
            }
            res.add(list);
        }

        if (root.left != null) {
            getAllpath(root.left, path, targetSum - root.val);
        }
        if (root.right != null) {
            getAllpath(root.right, path, targetSum - root.right.val);
        }
        path.removeLast();
    }

}
