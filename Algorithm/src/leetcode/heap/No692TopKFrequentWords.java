package leetcode.heap;

import java.util.*;

/**
 * 使用堆情况总结:
 * 1. 判断是获取前K个最大值还是最小值。
 * 2. 最大: 如果想省空间的话, 那么需要的是最小堆。如果里面的数=K,则offer最小值出来即可。
 * 3. 最小: 则需要最大堆。如果里面的数=k, offer最大值即可。
 * 4. comparator构造的时，
 */
public class No692TopKFrequentWords {
    public static void main(String[] args) {
        String[] data =  {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> strings = topKFrequent(data, k);
        strings.forEach(System.out::println);
    }

    // 给一非空的单词列表，返回前 k 个出现次数最多的单词。返回的答案应该按单词出现频率由高到低排序
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.get(word) == null ? 0 : countMap.get(word) + 1);
        }

        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (countMap.get(o1) == countMap.get(o2)) {
                    return o2.compareTo(o1);
                } else {
                    return countMap.get(o1) - countMap.get(o2);
                }
            }
        });

        for (String s : countMap.keySet()) {
            queue.offer(s);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        List<String> res = new ArrayList<>(k);
        while (!queue.isEmpty()) res.add(queue.poll());
        Collections.reverse(res);
        return res;
    }
}
