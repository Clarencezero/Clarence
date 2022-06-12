package leetcode.heap;

import java.util.HashSet;
import java.util.PriorityQueue;

public class No1709GetKthMagicNumberLCCI {
    public static void main(String[] args) {
        int rest = nthUglyNumber(4);
        System.out.println(rest);
    }


    public static int nthUglyNumber(int n) {
        // PriorityQueue<Long> pq = new PriorityQueue<>(n, new Comparator<Long>(){
        //     public int compare(Long o1, Long o2) {
        //         return o1 < o2 ? -1 : 1;
        //     }
        // });
        // 小：负值 大：正值
        PriorityQueue<Long> pq = new PriorityQueue<>(n, (o1, o2) -> o1 < o2 ? -1 : 1);

        HashSet<Long> hash = new HashSet<>();
        hash.add(1L);
        pq.offer(1L);
        int[] primes = new int[]{2, 3, 5};
        for (int prime : primes) {
            hash.add((long) prime);
            pq.offer((long) prime);
        }
        long min = primes[0];
        for (int i = 0; i < n; i++) {
            // min始终为第i+1个丑数，优先队列提供保证
            min = pq.poll();
            for (int prime : primes) {
                if (!hash.contains(min * prime)) {
                    hash.add(min * prime);
                    // HashSet保证优先队列中无重复丑数
                    pq.offer(min * prime);
                }
            }
        }
        return (int) min;
    }
}
