package leetcode.design;

import java.util.HashMap;
import java.util.Map;

class MyLinkedList {
    int key;
    int val;
    MyLinkedList next;
    MyLinkedList prev;

    public MyLinkedList(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class No_146_LRUCache2 {

    public static void main(String[] args) {
        No_146_LRUCache2 go = new No_146_LRUCache2(2);
        go.put(1, 1);
        go.put(2, 2);
        go.put(3, 3);
        System.out.println(go.get(1));
        go.put(4, 4);
        System.out.println(go.get(2));
        System.out.println(go.get(3));
        System.out.println(go.get(4));
    }

    // 存储key和LinkedList的映射关系
    private final Map<Integer, MyLinkedList> dataMap;
    private final MyLinkedList head, tail;
    private int capacity, size;

    public No_146_LRUCache2(int capacity) {
        this.capacity = capacity;
        dataMap = new HashMap<>(capacity);
        head = new MyLinkedList(-1, -1);
        tail = new MyLinkedList(-1, -1);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    /**
     * 从缓存中获取元素
     * 1. 通过HashMap判断是否存在，如果不存在则返回-1
     * 2. 元素存在，则将节点移动到链表的末尾
     */
    public int get(int key) {
        MyLinkedList node = dataMap.get(key);
        if (node == null) return -1;

        // 将节点移动到末尾
        moveToLast(node);
        return node.val;
    }

    /**
     * 放入元素稍显复杂
     * 1. 判断元素是否存在
     * 2. 元素不存在，则创建新的节点。根据size大小判断是否需要移除head的元素，并更新size
     * 3. 元素存在，则更新节点值，并将旧的节点移动到末尾即可
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        MyLinkedList node = dataMap.get(key);
        if (node == null) {
            // 节点不存在，那么创建新的节点
            MyLinkedList newNode = new MyLinkedList(key, value);
            dataMap.put(key, newNode);
            size++;
            if (size > capacity) {
                // remove key
                MyLinkedList removed = removeFirst();
                dataMap.remove(removed.key);
                size--;
            }
            addLast(newNode);
        } else {
            // 如果包含则更新
            node.val = value;
            remove(node);
            addLast(node);
        }
    }



    // 移除双向链表的头结点，需要注意判空
    private MyLinkedList removeFirst() {
        if (head.next == tail) return null;

        MyLinkedList removed = head.next;
        head.next = removed.next;
        removed.next.prev = head;
        return removed;
    }

    /**
     * 将某个节点移动到链表的末尾
     * 1. 将节点移除
     * 2. 将节点添加到链表末尾
     * @param node
     */
    private void moveToLast(MyLinkedList node) {
        remove(node);
        addLast(node);
    }

    private void remove(MyLinkedList node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 将链表添加到末尾
    private void addLast(MyLinkedList x) {
        // 更新x节点
        x.prev = tail.prev;
        x.next = tail;

        // 更新tail节点
        tail.prev.next = x;
        tail.prev = x;
    }
}
