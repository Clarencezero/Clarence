package leetcode.list;

import leetcode.common.ListNode;


public class No_recursive_linklist {
    public static void main(String[] args) {
        No_recursive_linklist go = new No_recursive_linklist();
        ListNode tree = ListNode.getListNode();
        go.helper(tree);
    }

    private void helper(ListNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        helper(node.next);
    }
}
