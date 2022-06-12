package leetcode.tree;

import leetcode.common.ListNode;

public class No_109_sortedListToBST {
    public static void main(String[] args) {
        ListNode listNode = getListNode();
        sortedListToBST(listNode);
    }


    static ListNode node ;
    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        int size = 0;
        ListNode p = head;
        node = head;
        while (p != null) {
            size++;
            p = p.next;
        }

        return inorderhelper(0, size);
    }


    // 左闭右开
    private static TreeNode inorderhelper(int start, int end) {
        if (start >= end) return null;

        // 取中值
        int mid = (end - start) / 2 + start;
        TreeNode left = inorderhelper(start, mid);
        TreeNode newNode = new TreeNode(node.val);
        newNode.left = left;
        node = node.next;

        TreeNode right = inorderhelper(mid + 1, end);
        newNode.right = right;

        return newNode;
    }


    private static ListNode getListNode() {
        ListNode l7 = new ListNode(7);
        ListNode l6 = new ListNode(6, l7);
        ListNode l5 = new ListNode(5, l6);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        return l1;
    }

}
