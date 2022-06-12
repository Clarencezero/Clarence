package leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class No_106_buildTree {
    public static void main(String[] args) {

    }


    /**
     * 这题主要考查边界问题
     * 要注意切割的标准，到底是左闭右开、左开右闭、左闭又闭，这个就是不变量，要在递归中保持这个不变量
     *
     * 1.首先在后序遍历序列中找到根节点（最后一个元素）
     * 2.根据根节点在遗弃遍历序列中找到根节点的位置
     * 3.根据根节点的位置将中序遍历序列分为左子树和右子树
     * 4.根据根节点的位置确定左子树和右子树在中序数组和后序数组中的左右边界值
     * 5.递归构造左子树和右子树
     * 6.返回根节点
     *
     * 切割中序数组通过遍历确定根节点的值即可，一直保持左闭右开的不变量，即[0, array.length)
     * 切割后序是以已完成切割的中序集合大小确定
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return null;
    }


}
