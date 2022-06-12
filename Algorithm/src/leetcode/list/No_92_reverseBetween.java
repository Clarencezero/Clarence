package leetcode.list;

import leetcode.common.ListNode;

public class No_92_reverseBetween {
    public static void main(String[] args) {
        No_92_reverseBetween go = new No_92_reverseBetween();
        ListNode listNode = ListNode.getListNode();
        System.out.println(listNode);
        // [1,4,3,2,5]
        ListNode listNode1 = go.reverseBetween(listNode, 2, 4);
        System.out.println(listNode1);
    }

    // 后继节点
    private ListNode successor;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;

        return helper(head, left, right);
    }

    private ListNode helper(ListNode head, int left, int right) {
        if (left == 1) {
            return reverse(head, right);
        }

        head.next = helper(head.next, left - 1, right - 1);

        return head;
    }

    private ListNode reverse(ListNode head, int n) {
        // if (head.next == null) return head;

        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode last = reverse(head.next, n - 1);

        head.next.next = head;
        head.next = successor;

        return last;
    }
}
