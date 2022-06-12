package leetcode.design;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 *
 */
public class No_460_LFUCache {
    public static void main(String[] args) {
    }

    final Map<Integer, Integer> keyValueMap;
    final Map<Integer, Integer> keyFreqMap;
    final Map<Integer, LinkedHashSet> freqToKeys;
    final int capacity;
    int size, minFreq;

    public No_460_LFUCache(int capacity) {
        this.capacity = capacity;
        keyValueMap = new HashMap<>(capacity);
        keyFreqMap = new HashMap<>(capacity);
        freqToKeys = new HashMap<>();
        size = 0;
        minFreq = 0;
    }

    // 1.key->val映射表，如果不存在，返回-1
    // 2.如果存在，则更新freq
    public int get(int key) {
        if (!keyValueMap.containsKey(key) || capacity == 0) return -1;

        // 增加
        increaseFreq(key);

        return keyValueMap.get(key);
    }

    // 1.如果key存在，则更新val和freq
    // 2.如果不存在，则判断容量是否已经满了，如果满了，则移除最少freq的key，然后将新数据插入
    public void put(int key, int value) {
        if (capacity == 0) return;
        // ① key存在，则更新val和freq
        if (keyValueMap.containsKey(key)) {
            keyValueMap.put(key, value);
            increaseFreq(key);
            return;
        }
        // ② key不存在，当容量已满时需要淘汰minFreq最小的
        if (this.size >= capacity) {
            removeMinFreqKey();
        }

        keyValueMap.put(key, value);
        keyFreqMap.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        size++;
        minFreq = 1;
    }

    // 增加freq
    private void increaseFreq(int key) {
        int freq = keyFreqMap.get(key);
        keyFreqMap.put(key, freq + 1);

        // 将旧的数据移除
        freqToKeys.get(freq).remove(key);
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            if (freq == this.minFreq) {
                this.minFreq++;
            }
        }
    }

    private void removeMinFreqKey() {
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        int deletedKey = keyList.iterator().next();
        keyList.remove(deletedKey);
        if (keyList.isEmpty()) freqToKeys.remove(this.minFreq);

        keyValueMap.remove(deletedKey);
        keyFreqMap.remove(deletedKey);
    }
}
