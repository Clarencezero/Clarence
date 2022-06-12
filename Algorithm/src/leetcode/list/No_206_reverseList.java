package leetcode.list;

import leetcode.common.ListNode;

public class No_206_reverseList {
    public static void main(String[] args) {
        No_206_reverseList go = new No_206_reverseList();
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        ListNode listNode = go.reverseList2(n1);


    }
    public ListNode reverseList2(ListNode head) {
        if (head == null) return null;
        return helper(head);
    }

    private ListNode helper(ListNode node) {
        if (node.next == null) return node;
        ListNode prev = helper(node.next);
        prev.next = node;

        return node;
    }
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return cur;
    }
}
