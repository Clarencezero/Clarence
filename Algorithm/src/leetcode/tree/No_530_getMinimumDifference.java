package leetcode.tree;

public class No_530_getMinimumDifference {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.getBST();
        System.out.println(getMinimumDifference(tree));
    }

    private static int res = Integer.MAX_VALUE;

    public static int getMinimumDifference(TreeNode root) {
        if (root == null ) return 0;
        inorder(root);
        return res;
    }

    private static void inorder(TreeNode root) {
        if (root == null) return;
        if (root.left != null) inorder(root.left);

        // 终止条件：
        if (root.left != null) res = Math.min(res, Math.abs(root.val - root.left.val));
        if (root.right != null) res = Math.min(res, Math.abs(root.val - root.right.val));
        if (root.left != null && root.right != null) res = Math.min(res, Math.abs(root.left.val - root.right.val));

        if (root.right != null) inorder(root.right);
    }
}
