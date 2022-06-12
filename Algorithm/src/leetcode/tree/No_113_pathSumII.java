package leetcode.tree;

import java.util.*;

public class No_113_pathSumII {
    static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        Arrays.fill(arr[1], 1);
        for (int[] a : arr) {
            System.out.print(a[0] + " " + a[1] + " " + a[2]);
            System.out.println();
        }
        // TreeNode tree = TreeNode.getTree2();
        // List<List<Integer>> lists = pathSum(tree, 22);
        // for (List<Integer> list : lists) {
        //     System.out.println(list);
        // }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        traversal(root, res, targetSum);
        return res;
    }

    private static void traversal(TreeNode root, List<List<Integer>> res, int targetSum) {
        if (root == null) return;
        path.add(root.val);

        if (root.left == null && root.right == null && root.val == targetSum) {
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        traversal(root.left, res, targetSum - root.val);
        traversal(root.right, res, targetSum - root.val);
        path.remove(path.size() - 1);
        System.out.println("node" + root.val + "  " + path);
    }


    public static List<List<Integer>> pathSum2TreeNode(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        int SUM = 0;
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.addLast(cur);
                path.add(cur.val);
                SUM += cur.val;
                cur = cur.left;
            }
            cur = stack.peekLast();

            if (cur.right != null && cur.right != pre) {
                cur = cur.right;
                continue;
            }

            if (cur.left == null && cur.right == null && SUM == sum)
                res.add(new ArrayList<>(path));

            pre = cur;
            stack.pollLast();
            path.remove(path.size() - 1);
            // 回溯
            SUM -= cur.val;
            cur = null;

        }
        return res;
    }
}
