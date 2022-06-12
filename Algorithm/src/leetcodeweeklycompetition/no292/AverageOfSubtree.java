package leetcodeweeklycompetition.no292;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class B {
    public int total = 0;
    public int count = 0;

    public B(int total, int count) {
        this.total = total;
        this.count = count;
    }
}

public class AverageOfSubtree {
    int count = 0;

    public static void main(String[] args) {
        AverageOfSubtree go = new AverageOfSubtree();

        TreeNode root = new TreeNode(4);
        TreeNode n8 = new TreeNode(8);
        TreeNode n5 = new TreeNode(5);
        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n6 = new TreeNode(6);
        root.left = n8;
        root.right = n5;
        n8.left = n0;
        n8.right = n1;
        n5.right = n6;

        go.sum(root);
        System.out.println(go.count);
    }

    private B sum(TreeNode node) {
        if (node == null) {
            return null;
        }
        B newB = new B(node.val, 1);
        B leftResult = sum(node.left);
        B rightResult = sum(node.right);
        if (leftResult != null) {
            newB.count += leftResult.count;
            newB.total += leftResult.total;
        }
        if (rightResult != null) {
            newB.count += rightResult.count;
            newB.total += rightResult.total;
        }
        int avg = newB.total / newB.count;
        if (avg == node.val) {
            count++;
        }
        return newB;
    }
}