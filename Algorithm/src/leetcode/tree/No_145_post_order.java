package leetcode.tree;

import java.util.*;

public class No_145_post_order {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree();
        List<Integer> integers = postorderTraversal3(root);
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
    }


    public static List<Integer> postorderTraversal3(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        TreeNode p = root;
        TreeNode prev = null;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.addLast(p);
                p = p.left;
            }

            p = stack.peekLast();
            if (p.right != null && p.right != prev) {
                p = p.right;
                continue;
            }

            // 遇到叶子节点或current节点的左、右子节点都已经成功被处理了
            stack.pollLast();
            res.add(p.val);
            // 更新pre指针
            prev = p;
            p = null;
        }
        return res;
    }


    public static List<Integer> postorderTraversal2(TreeNode root) {
        Stack<TreeNode> s = new Stack();
        List<Integer> ans = new ArrayList<>();
        TreeNode cur = root;

        while (cur != null || !s.empty()) {
            while (!isLeaf(cur)) {
                s.push(cur);
                cur = cur.left;
            }

            // 走不动了，左节点的值一定是最先加入的，它不会再被遍历
            if (cur != null) ans.add(cur.val);

            while (!s.empty() && cur == s.peek().right) {
                cur = s.pop();
                ans.add(cur.val);
            }

            if (s.empty()) cur = null;
            else cur = s.peek().right;
        }

        return ans;
    }

    private static boolean isLeaf(TreeNode r) {
        if (r == null) return true;
        return r.left == null && r.right == null;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        TreeNode pLastVisit = null;
        // 一直走到最左边
        while (p != null) {
            stack.addLast(p);
            p = p.left;
        }

        while (!stack.isEmpty()) {
            p = stack.pollLast();
            // 判断是否需要输出根节点的值，
            // 输出根节点的值的前提是它的左、右子树都已经完成遍历
            if (p.right == null || p.right == pLastVisit) {
                res.add(p.val);
                // 修改最近一次经过的节点
                pLastVisit = p;
            } else {
                // 左子树刚被访问过
                stack.addLast(p);
                p = p.right;

                // 将右节点的所有最左边都走一遍
                while (p != null) {
                    stack.addLast(p);
                    p = p.left;
                }
            }
        }

        return res;
    }
}
