package leetcode.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Worker {
    public int quality;
    private int wage;

    public Worker(int quality, int wage) {
        this.quality = quality;
        this.wage = wage;
    }
}

public class No857MinimumCosttoHireKWorkers {
    public static void main(String[] args) {
        int[] q = {10, 20, 5};
        int[] w = {70, 50, 30};
        int k = 2;
        mincostToHireWorkers2(q, w, k);
    }


    public static double mincostToHireWorkers2(int[] q, int[] w, int K) {
        double[][] workers = new double[q.length][2];
        for (int i = 0; i < q.length; ++i)
            workers[i] = new double[]{(double) (w[i]) / q[i], (double) q[i]};
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        double res = Double.MAX_VALUE, qsum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for (double[] worker : workers) {
            qsum += worker[1];
            pq.add(-worker[1]);
            if (pq.size() > K) qsum += pq.poll();
            if (pq.size() == K) res = Math.min(res, qsum * worker[0]);
        }
        return res;
    }

    /**
     * R*sum(quality[c1]+quality[c2])
     * wage[i]/quality[i]:从小到大
     */
    public static double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        PriorityQueue<Integer> qualityBig = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return quality[o1] - quality[o2];
            }
        });

        PriorityQueue<Integer> ratio = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return wage[o2] / quality[o2] - wage[o1] / quality[o1];
            }
        });

        // 按照这些人的价值，对他们进行升序排序。我们需要在前i名工人中选择K个工作质量最低的。
        return 0;
    }
}
