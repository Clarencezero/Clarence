package targetoffer.v2;

import leetcode.common.ListNode;

public class No_026_reorderList {
    public static void main(String[] args) {
        No_026_reorderList go = new No_026_reorderList();
        int[] nums = {1,2,3,4,5};
        ListNode head = ListNode.getListNode(nums);
        go.reorderList(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return ;
        reorderList(head, len(head));
    }

    private ListNode reorderList(ListNode head, int len) {
        if (len == 0) return null;
        if (len == 1) return head;
        if (len == 2) return head.next;

        ListNode tail = reorderList(head.next, len - 2);
        System.out.println("tail: " + tail.val);
        ListNode temp = tail.next;
        tail.next = tail.next.next;
        temp.next = head.next;
        head.next = temp;
        return tail;
    }

    private int len(ListNode head) {
        ListNode p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }
}
