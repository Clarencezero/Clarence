package jianzhioffer;


public class No_18_Delete_List_Node {
    public static void main(String[] args) {
        No_18_Delete_List_Node node = new No_18_Delete_List_Node();
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode listNode = node.deleteNode(n1, 5);
        while (listNode.next != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode root = new ListNode(-1);
        if (head.val == val) {
            return head.next;
        }
        root.next = head;
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null) {
            if (cur.val == val) {
                // 替换
                pre.next = cur.next;
            }
            pre = cur;
            cur = cur.next;
        }

        return root.next;
    }
}
