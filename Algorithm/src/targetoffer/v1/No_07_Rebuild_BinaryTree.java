package jianzhioffer;


import java.util.LinkedList;

/**
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * 复习:
 * 记忆技巧: 根据访问根节点记忆前、中、后
 * 前序遍历（VLR）:
 * 访问根节点
 * 前序遍历左子树
 * 前序遍历右子树
 * 中序遍历（LDR）:
 * 中序遍历左子树
 * 访问根结点
 * 中序遍历右子树
 * 后序遍历（LRD）:
 * 后序遍历左子树
 * 后序遍历右子树
 * 访问根节点
 * <p>
 * 递归时间复杂度: 本质是 递归的次数 * 每次递归中的操作次数
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class No_07_Rebuild_BinaryTree {
    public static void main(String[] args) {
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree_2(preOrder, inOrder);
        System.out.println(treeNode);
    }

    /**
     * 思路一:
     * 前序遍历结果特点: 首位是根节点
     * 中序遍历结果特点: 根节点左边全是左子树、根节点右边全是右子树
     *
     * @param preorder 前序遍历结果数组
     * @param inorder  中序遍历结果数组
     * @return 返回
     */
    public static TreeNode buildTree_1(int[] preorder, int[] inorder) {
        return doRecursion(0, 0, inorder.length - 1, preorder, inorder);
    }

    /**
     * 关键: 当前节点在前序数组中的右子元素的索引
     *
     * @param preStart
     * @param inStart
     * @param inEnd
     * @return
     */
    private static TreeNode doRecursion(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        // 判断边界条件
        if (inStart > inEnd)
            return null;

        // 构建根节点
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }

        // 构建左子树
        root.left = doRecursion(preStart + 1, inStart, inIndex - 1, preorder, inorder);

        // 难点: 确定右子树的根节点在前序数组中的序号
        // 核心思想是: 依靠中序的拆分信息可得左、右子树元素总数，通过前序数组减去总个数再加1，即为右子树根节点序号
        // 左节点个数 = inIndex - inStart
        // 右节点序号 = preStart + (inIndex - inStart) + 1
        root.right = doRecursion(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);

        // 构建右子树
        return root;
    }


    /**
     * 思路二:遍历。使用栈保存遍历过的节点
     * 3
     * /   \
     * 4      11
     * / \
     * 5   10
     * /
     * 6
     * 前序数组:[3,4,5,6,10,11]
     * 中序数组:[6,5,4,10,3,11]
     * 重点:
     * 遍历前序数组，并与中序数组首位（j, 中序数组指针）比较，判断是否相等
     * 不相等，表示下一个节点是当前节点的左子树
     * 相等，则表示下一个节点可能为当前节点的右子树或其父节点的右子树。
     * 前序首位为根节点，且 3 != 6，所以 4 为 3 的左子树节点，
     * 5 != 6，所以 5 为4的左子树节点
     * 6 == 6，表示左子树节点已到头了，需要处理右子树节点
     * 从栈中弹出 5 与 5 比较，相等则跳过
     * 继续从线中弹出 4 与 4（此时j=2）相等，跳过
     * <p>
     * 转折点一: 前序 == 中序，表示左子树节点到头了，转而对于右子树处理
     * 转折点二: 堆上数据 != 当前中序指针数据，则为当前cur指针的右子树节点，并入栈
     * <p>
     * 当栈上的数据与中序遍历指针不相等，表示出现右节点，至于属于哪个右节点，则需要
     *
     * @param preorder 前序遍历结果数组
     * @param inorder  中序遍历结果数组
     * @return 返回
     */
    public static TreeNode buildTree_2(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        int j = 0;
        // 遍历前序数组
        for (int i = 1; i < preorder.length; i++) {
            // 获取堆上面数据
            TreeNode cur = stack.peek();
            // 如果不相等，表示还没有到达左子树最底层，需要入栈
            if (cur.val != inorder[j]) {
                TreeNode leftNode = new TreeNode(preorder[i]);
                // 入栈
                stack.push(leftNode);
                // 当前节点指向左子树
                cur.left = leftNode;
            } else {
                // 到达左子树最底层，开始构建右子树
                while (!stack.isEmpty() && cur.val == inorder[j]) {
                    cur = stack.pop();
                    j++;
                }
                // △ 转折，应该添加前序序号所指向的右子树节点
                cur.right = new TreeNode(preorder[i]);
                stack.push(cur.right);
            }
        }
        return root;
    }


}
