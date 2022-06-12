package leetcode.common;

/**
 * 这个题目简单考查了节点的问题。主要思想是建立一个cur 指向当前的节点,类似一个指针的作用。添加的时候不断向下移动。获取元素的时候,也需要移动指针
 */


public class ListNode {
    public int val;
    public ListNode next;


    public ListNode(int x) {
        val = x;
    }

    public ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }

    public static ListNode getListNode(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (int i : nums) {
            p.next = new ListNode(i);
            p = p.next;
        }
        return dummy.next;
    }


    public static ListNode getListNode() {
        ListNode n7 = new ListNode(7);
        ListNode n6 = new ListNode(6, n7);
        ListNode n5 = new ListNode(5, n6);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        return n1;
    }

    public static ListNode getDuplicatesListNode() {
        ListNode n5 = new ListNode(3, null);
        ListNode n4 = new ListNode(3, n5);
        ListNode n3 = new ListNode(2, n4);
        ListNode n2 = new ListNode(1, n3);
        ListNode n1 = new ListNode(1, n2);
        return n1;
    }

    @Override
    public String toString() {
        // return val + ">" + next.val;
        StringBuilder sb = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            sb.append(cur.val).append("->");
            cur = cur.next;
        }
        return sb.substring(0, sb.length() - 2);
    }
}
