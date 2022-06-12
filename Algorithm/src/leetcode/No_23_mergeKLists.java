package leetcode;

import leetcode.common.ListNode;

public class No_23_mergeKLists {
    public static void main(String[] args) {
        No_23_mergeKLists go = new No_23_mergeKLists();
        ListNode n1 = go.makeNode1();
        ListNode n2 = go.makeNode2();
        ListNode n3 = go.makeNode3();
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

        ListNode[] lists = {n1, n2, n3};

        ListNode listNode = go.mergeKLists(lists);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public  ListNode makeNode1() {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n1 = new ListNode(1, n4);
        return n1;
    }

    public ListNode makeNode2() {
        ListNode n5 = new ListNode(4);
        ListNode n4 = new ListNode(3, n5);
        ListNode n1 = new ListNode(1, n4);
        return n1;
    }
    public ListNode makeNode3() {
        ListNode n4 = new ListNode(6);
        ListNode n1 = new ListNode(2, n4);
        return n1;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left >= right) return lists[left];
        int mid = left + (right - left) / 2;

        // 合并左半区
        ListNode leftNode = merge(lists, left, mid);

        // 合并右半区
        ListNode rightNode = merge(lists, mid + 1, right);

        // 归并
        ListNode newHead = mergeTwoListNode(leftNode, rightNode);

        return newHead;

    }

    // 合并两个链表，
    private ListNode mergeTwoListNode(ListNode n1, ListNode n2) {
        if (n1 == null || n2 == null) return n1 == null ? n2 : n1;
        ListNode root;
        if (n1.val > n2.val) {
            root = n2;
            root.next = mergeTwoListNode(n1, n2.next);
        } else {
            root = n1;
            root.next = mergeTwoListNode(n2, n1.next);
        }
        return root;
    }
}
