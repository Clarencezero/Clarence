package leetcode.tree;


public class No_222_countNodes {
    public static void main(String[] args) {
       TreeNode root = TreeNode.getCompleteTree();
        System.out.println(countNodes(root));
    }

    public static int countNodes(TreeNode root) {
        if (root == null) return 0;
        // 获取高度
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (leftHeight == rightHeight) {
            // 说明左子树是满二叉树，需要递归统计右子树
            return (1 << leftHeight) + countNodes(root.right);
        } else {
            return (1 << rightHeight) + countNodes(root.left);
        }
    }


    private static int getHeight(TreeNode root) {
        int level = 0;
        TreeNode p = root;
        while (p != null) {
            level++;
            p = p.left;
        }
        return level;
    }
}
