package leetcode.tree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() { }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // public static TreeNode constructTree(int[] nums) {
    //     return constructTree(nums, 0, nums.length, 1);
    // }
    //
    // private static TreeNode dfs(int[] nums, int start, int end, int level) {
    //     if (start > end) return null;
    //     TreeNode root = new TreeNode(nums[start]);
    //     int leftStart = (2 << level) ;
    //     int leftEnd = (2 << level) ;
    //     int rightStart = ;
    //     int rightEnd = ;
    //     root.left = dfs(nums, leftStart, leftEnd, level + 1);
    //     root.right = dfs(nums, rightStart, rightEnd, level + 1);
    //
    //     return root;
    // }

    public static TreeNode getCompleteTree() {
        TreeNode t4 = new TreeNode(4, null, null);
        TreeNode t5 = new TreeNode(5, null, null);
        TreeNode t6 = new TreeNode(6, null, null);
        TreeNode t7 = new TreeNode(7, null, null);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t3 = new TreeNode(3, t6, t7);
        TreeNode t1 = new TreeNode(1, t2, t3);
        return t1;
    }

    @Override
    public String toString() {
        // return "val=" + val +
        //         ", left=" + left +
        //         ", right=" + right ;
        return "val=" + val;
    }

    // https://leetcode-cn.com/problems/path-sum-ii/
    public static TreeNode getTree2() {
        TreeNode t7 = new TreeNode(7, null, null);
        TreeNode t2 = new TreeNode(2, null, null);
        TreeNode t11 = new TreeNode(11, t7, t2);
        TreeNode t4 = new TreeNode(4, t11, null);

        TreeNode t5_ = new TreeNode(5, null, null);
        TreeNode t1 = new TreeNode(1, null, null);
        TreeNode t4_ = new TreeNode(4, t5_, t1);
        TreeNode t13 = new TreeNode(13, null, null);
        TreeNode t8 = new TreeNode(8, t13, t4_);

        TreeNode t5 = new TreeNode(5, t4, t8);

        return t5;
    }

    public static TreeNode getTree() {
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3, null, t4);

        TreeNode t6 = new TreeNode(6, null, null);
        TreeNode t8 = new TreeNode(8, null, null);
        TreeNode t7 = new TreeNode(7, t6, t8);

        TreeNode t5 = new TreeNode(5, t3, t7);

        return t5;
    }

    public static TreeNode getBST() {
        TreeNode t227 = new TreeNode(227, null, null);
        TreeNode t911 = new TreeNode(911, null, null);
        TreeNode t701 = new TreeNode(701, null, t911);
        TreeNode t104 = new TreeNode(104, null, t227);
        TreeNode t236 = new TreeNode(236, t104, t701);
        return t236;
    }

    public static TreeNode getBST2() {
        TreeNode t2 = new TreeNode(2, null, null);
        TreeNode t4 = new TreeNode(4, null, null);
        TreeNode t7 = new TreeNode(7, null, null);

        TreeNode t3 = new TreeNode(3, t2, t4);
        TreeNode t6 = new TreeNode(6, null, t7);
        TreeNode t5 = new TreeNode(5, t3, t6);
        return t5;
    }
}
