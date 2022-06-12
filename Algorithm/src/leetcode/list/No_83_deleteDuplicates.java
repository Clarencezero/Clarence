package leetcode.list;

import leetcode.common.ListNode;

public class No_83_deleteDuplicates {
    public static void main(String[] args) {
        No_83_deleteDuplicates go = new No_83_deleteDuplicates();
        ListNode listNode = ListNode.getDuplicatesListNode();
        ListNode listNode1 = go.deleteDuplicates(listNode);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        // 1.升序、删除重复节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                // 更新 slow 指针
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        return dummy.next;
    }
}
