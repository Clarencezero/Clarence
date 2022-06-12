package leetcode.stack;

import java.util.*;

public class No_316_removeDuplicateLetters {
    public static void main(String[] args) {
        String str = "ecbacba";
        // removeDuplicateLetters(str);
        List<String> strList = Arrays.asList("i", "love", "leetcode", "i", "love", "coding");
        topKFrequent2((String[]) strList.toArray(), 2);
    }

    // 1.遍历字符串，得到每个字符最后一个位置所在的地方
    // 2.头从开始遍历字符串，遇到以下情况
    //   2.1 栈为空，入栈
    //   2.2 如果当前指向的字符不会在后面存在，必须入栈
    //   2.3 新来的字符比栈顶元素更小，且栈顶元素会在后面出现，弹出栈顶元素，将新元素入栈
    public static String removeDuplicateLetters(String s) {
        // 特判
        if (s.length() < 2) return s;

        int[] lastIndex = new int[26];
        boolean[] visited = new boolean[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            lastIndex[chars[i] - 'a'] = i;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < chars.length; i++) {
            // b(栈顶元素) a(判断元素)
            if (visited[chars[i] - 'a']) {
                // 该元素已访问过了
                continue;
            }

            // 需要满足：1.队列非空 2.栈顶元素>待入队元素 3.栈顶元素后面存在，这样栈顶的元素才会被允许出队
            while (!stack.isEmpty() && stack.peekLast() - chars[i] > 0 && lastIndex[stack.peekLast() - 'a'] > i) {
                char removed = stack.pollLast();
                visited[removed - 'a'] = false;
            }

            visited[chars[i] - 'a'] = true;
            stack.addLast(chars[i]);

        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }


    public static List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq =
                new PriorityQueue<>((entry1, entry2) -> {
                    int res = entry1.getValue() == entry2.getValue() ? entry2.getKey().compareTo(entry1.getKey()) : entry1.getValue() - entry2.getValue();
                    System.out.println("compare: " + entry1 + ": " + entry2 + " 比较结果: " + res);
                    return res;
                }
                );

        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> ret = new ArrayList<>();
        while (!pq.isEmpty()) {
            ret.add(pq.poll().getKey());
        }
        Collections.reverse(ret);
        return ret;
    }
}
