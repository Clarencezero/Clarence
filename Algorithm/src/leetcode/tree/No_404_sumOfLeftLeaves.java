package leetcode.tree;

public class No_404_sumOfLeftLeaves {
    public static void main(String[] args) {
        TreeNode tree = getTree();
        System.out.println(sumOfLeftLeaves(tree));
    }

    /**
     * 节点的所有子叶子节点数 = 左子数左节点的和 + 右子数左节点的和
     * @param root
     * @return
     */
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int leftVal = sumOfLeftLeaves(root.left);
        int rightVal = sumOfLeftLeaves(root.right);
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }

        return sum + leftVal + rightVal;
    }

    public static TreeNode getTree() {
        TreeNode t15 = new TreeNode(15, null, null);
        TreeNode t7 = new TreeNode(7, null, null);
        TreeNode t20 = new TreeNode(20, t15, t7);
        TreeNode t9 = new TreeNode(9, null, null);
        TreeNode t3 = new TreeNode(3, t9, t20);

        return t3;
    }


}
