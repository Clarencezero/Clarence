package leetcode.twopointer;

import leetcode.common.ListNode;

public class No_142_detectCycle {
    public static void main(String[] args) {
        No_142_detectCycle go = new No_142_detectCycle();
        ListNode node = new ListNode(1);
        System.out.println(go.detectCycle(node));
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                // 快慢指针相遇，求入口
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }

        return null;
    }
}
