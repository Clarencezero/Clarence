package jianzhioffer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 */


/**
 * 思路一: 使用单栈遍历
 * 时间复杂度/空间复杂度都比较高: 因为添加/删除两个操作都需要翻转栈
 */
class CQueue_1 {
    // 栈->队列
    Stack<Integer> stack = new Stack<>();
    boolean reverse = false;

    public CQueue_1() {

    }

    public void appendTail(int value) {
        if (reverse) {
            // 翻转
            Stack<Integer> temp = new Stack<>();
            while (!stack.isEmpty()) {
                temp.push(stack.pop());
            }
            temp.push(value);
            stack = temp;
            reverse = !reverse;
        } else {
            stack.push(value);
        }
    }

    public int deleteHead() {
        if (stack.isEmpty()) {
            return -1;
        }
        if (!reverse) {
            // 翻转
            Stack<Integer> temp = new Stack<>();
            while (!stack.isEmpty()) {
                temp.push(stack.pop());
            }
            int returnVlaue = temp.pop();
            stack = temp;
            reverse = !reverse;
            return returnVlaue;
        } else {
            return stack.pop();
        }
    }
}

/**
 * 思路二: 使用两个栈进行操作
 * 关键: 从主栈依次 pop 到 副栈中，此时相当于链表反转，直接 pop 副栈即可，
 * 而新增的可以直接添加到主栈，此时删除、新增不受任何影响。
 */
class CQueue_2 {
    private Stack<Integer> normal;
    private Stack<Integer> temp;
    public CQueue_2() {
        normal = new Stack<>();
        temp = new Stack<>();
    }

    public void appendTail(int value) {
        normal.push(value);
    }

    public int deleteHead() {
        // if (normal.isEmpty() && temp.isEmpty()) {
        //     return -1;
        // }
        // if (!temp.isEmpty()) {
        //     return temp.pop();
        // }
        //
        // while (!normal.isEmpty()) {
        //     temp.push(normal.pop());
        // }
        // return temp.pop();

        // 改进，减少判断次数
        if (temp.isEmpty()) {
            while (!normal.isEmpty()) {
                temp.push(normal.pop());
            }
        }

        if (temp.isEmpty()) {
            return -1;
        } else {
            return temp.pop();
        }

    }
}

/**
 * 使用 LinkList 替代 Stack，这会减少执行用时，但会增加内存消耗
 * LinkList:
 *    底层实现: 双向链表。随机访问效率低，但随机插入、删除效率高。当增、删、改多于查找时，使用 LinkedList
 * Stack:
 *    底层实现: 数组。随机访问效率高，但随机插入、删除效率低。当查找居多时，使用 Stack
 *
 * 这里插入多于查找，所以推荐使用 LinkList，但是由于使用链表作为底层存储，则内存消耗多于 Stack
 */
class CQueue_3 {
    private LinkedList<Integer> normal;
    private LinkedList<Integer> temp;
    public CQueue_3() {
        normal = new LinkedList<>();
        temp = new LinkedList<>();
    }

    public void appendTail(int value) {
        normal.push(value);
    }

    public int deleteHead() {
        if (temp.isEmpty()) {
            while (!normal.isEmpty()) {
                temp.push(normal.pop());
            }
        }

        if (temp.isEmpty()) {
            return -1;
        } else {
            return temp.pop();
        }

    }
}

