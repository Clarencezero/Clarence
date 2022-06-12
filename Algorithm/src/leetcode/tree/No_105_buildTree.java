package leetcode.tree;

import java.util.*;

public class No_105_buildTree {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        buildTree3(preorder, inorder);
    }

    // https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--22/
    public static TreeNode buildTree3(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        int j = 0;
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode prev = root;
        stack.addLast(prev);

        // 遍历前序数组
        for (int i = 1; i < preorder.length; i++) {
            if (prev.val == inorder[j]) {
                // 如果前向节点prev的值与inorder相等，说明preorder[i]这个元素肯定不是prev的左节点，
                // 而在栈中某一个元素的右节点：不断出栈直到不相等，那么preorder[i]就是刚才所弹出的元素就是右节点
                while (!stack.isEmpty() && stack.peekLast().val == inorder[j]) {
                    // 遇到前序遍历元素和中序遍历元素数组相等的情况
                    // 那么表明 preorder[i+i]元素将会是右子树，因此需要进行出栈操作
                    prev = stack.pollLast();
                    // 同时inorder向前走
                    j++;
                }

                // 设置右孩子
                prev.right = new TreeNode(preorder[i]);
                // 更新cur指针
                prev = prev.right;
                stack.addLast(prev);
            } else {
                prev.left = new TreeNode(preorder[i]);
                prev = prev.left;
                stack.addLast(prev);
            }
        }

        return root;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode cur = root;
        // int j = 0;
        for (int i = 1, j = 0; i < preorder.length; i++) {
            if (cur.val != inorder[j]) {
                cur.left = new TreeNode(preorder[i]);
                stack.addLast(cur);
                cur = cur.left;
            } else {
                j++;
                while (!stack.isEmpty() && stack.peekLast().val == inorder[j]) {
                    cur = stack.pop();
                    j++;
                }
                cur = cur.right = new TreeNode(preorder[i]);
            }
        }

        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (inorder.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        int val = preorder[0];
        TreeNode root = new TreeNode(val);
        stack.push(root);

        for (int i = 1; i < preorder.length; i++) {
            val = preorder[i];
            TreeNode node = new TreeNode(val);

            if (map.get(val) < map.get(stack.peekLast().val)) {
                // 更新左节点
                stack.peek().left = node;
            } else {
                TreeNode parent = null;
                while (!stack.isEmpty() && map.get(val) > map.get(stack.peekLast().val)) {
                    parent = stack.pollLast();
                }
                parent.right = node;
            }
            stack.addLast(node);
        }

        return root;
    }
}
