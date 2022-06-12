package leetcode.design;

import java.util.HashMap;
import java.util.Map;



/*
 * [146] LRU 缓存机制
 * 编程遇到的问题：
 * 1.遇到空指针异常。这是因为如果我们将head、tail直接指向元素的话，这会很容易导致空指针异常。
 * 所以我们需要在构造函数中对这两个指针变量初始化。这两个指针作为标记指针是不代表任何数据的。
 * 2.统一规定：尾结点是指向最近使用的元素。头结点是指向最不常用的元素。
 * 3.指针的变更是有步骤的，先对待操作的节点进行缓存，然后再挨个更新指针即可
 *   
 * 
 */

class No_146_LRUCache {
    public static void main(String[] args) {
        No_146_LRUCache lRUCache = new No_146_LRUCache(2);
        lRUCache.put(2, 1);
        lRUCache.put(2, 2);
        lRUCache.get(2);
        
        lRUCache.put(1, 1);
        lRUCache.put(4, 1);
        lRUCache.get(2);
        
    }
    int capacity;
    Map<Integer, Entry> data; // 数据
    Entry head; // 头部存在最新元素
    Entry tail; // 尾部存放即将过期的元素
    

    public No_146_LRUCache(int capacity) {
        this.capacity = capacity;
        data = new HashMap<>(capacity);

        // 初始化头、尾结点指针。否则容易出现空指针异常
        head = new Entry(-1, -1);
        tail = new Entry(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    /**
     * 从LRU缓存中获取元素，注意事项：
     * 1.先判断map是否存在，如果不存在则返回-1
     * 2.如果元素存在，返回前将该元素放回到双向链表的头部
     */
    public int get(int key) {
        // 如果map中包含，则获取后再放入尾部
        if (data.containsKey(key)) {
            Entry target = data.get(key);
            popToTail(target);
            return target.value;
        } else {
            return -1;
        }

    }
    
    /**
     * 更新操作
     * 需要判断容量是否已经满了，如果满了对元素进行淘汰
     * 
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        if (data.containsKey(key)) {
            // 更新
            Entry target = data.get(key);
            target.value = value;
            popToTail(target);
        } else {
            // 不包含
            Entry newEntry = new Entry(key, value);
            if (data.size() == capacity) {
                Entry removedEntry = removeFirst();
                data.remove(removedEntry.key);
            }
            addToTail(newEntry);
            data.put(key, newEntry);
        }
    }

    /**
     * 将entry结点移动到链表的末端，延迟删除
     * 
     * @param entry
     */
    private void popToTail(Entry entry) {
        Entry prev = entry.prev;
        Entry next = entry.next;
        prev.next = next;
        next.prev = prev;

        // 加入末尾
        Entry last = tail.prev;
        last.next = entry;
        tail.prev = entry;
        entry.prev = last;
        entry.next = tail;
    }

    /**
     * 移除首个节点
     * 1.
     * @return
     */
    private Entry removeFirst() {
        if (head.next.equals(tail)) 
            throw new IllegalArgumentException("no elements could be removed!");
        
        Entry firstEntry = head.next;
        head.next = firstEntry.next;

        firstEntry.next.prev = head;
        firstEntry.prev = null;
        firstEntry.next = null;
        return firstEntry;
    }
    
    // 加入末尾
    private void addToTail(Entry newEntry) {
        Entry tailEntry = tail.prev;
        tailEntry.next = newEntry;
        newEntry.prev = tailEntry;
        newEntry.next = tail;
        tail.prev = newEntry;
    }


    class Entry {
        int key;
        int value;
        Entry prev;
        Entry next;
        public Entry (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}