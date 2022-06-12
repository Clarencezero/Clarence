package jianzhioffer;

import java.util.Stack;

/**
 * Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）
 * 关键字: 单链表、头结点、尾部遍历
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class NO05_Print_The_List_From_Beginning_To_End {
    public static void main(String[] args) {
        ListNode listNode = generateListNode();
        int[] ints = reversePrint_2(listNode);
        System.out.println(ints);

    }

    public static ListNode generateListNode() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        return listNode1;
    }

    /**
     * 思路一: 使用 Stack（栈）写入数据，然后再遍历栈
     *
     * @param head
     * @return
     */
    public static int[] reversePrint_1(ListNode head) {
        if (head == null)
            return new int[]{};

        if (head.next == null)
            return new int[]{head.val};

        ListNode next = head;
        Stack<Integer> stack = new Stack();
        while (next != null) {
            stack.push(next.val);
            next = next.next;
        }
        int[] result = new int[stack.size()];

        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }

    /**
     * 思路二: 空间优化，使用 int 代替 Integer，能节省内存开销（基本类型不需要保存对象头等信息）
     * 然而测试的时候似乎并没有变化
     * @param head
     * @return
     */
    public static int[] reversePrint_2(ListNode head) {
        if (head == null)
            return new int[]{};

        if (head.next == null)
            return new int[]{head.val};

        // 获取链表长度
        int length = 0;
        ListNode next = head;
        while (next != null) {
            length++;
            next = next.next;
        }

        int[] result = new int[length];

        int p = length - 1;

        next = head;
        while (next != null) {
            result[p--] = next.val;
            next = next.next;
        }

        return result;
    }

    /**
     * 思路三:递归也是一种遍历方式
     */


}
