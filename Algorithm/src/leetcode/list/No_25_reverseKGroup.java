package leetcode.list;

import leetcode.common.ListNode;

public class No_25_reverseKGroup {
    public static void main(String[] args) {
        No_25_reverseKGroup go = new No_25_reverseKGroup();
        ListNode listNode = ListNode.getListNode();
        System.out.println(listNode);
        System.out.println(go.reverseKGroup(listNode, 4));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        // 区间[start, end)
        ListNode start = head, end = head;
        for (int i = 0; i < k; i++) {
            // 最后不满足k个就不反转
            if (end == null) break;
            end = end.next;
        }

        // 反转[start, end)区间的元素
        ListNode newHead = reverse(start, end);
        head.next = reverseKGroup(end, k);
        return newHead;
    }

    private ListNode  reverse(ListNode start, ListNode end) {
        ListNode prev = null, cur = start, next = null;
        while (cur != end) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
