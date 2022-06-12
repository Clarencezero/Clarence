package leetcode.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 * （这里，平面上两点之间的距离是欧几里德距离。）
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的s。
 */
public class No973KClosestPointstoOrigin {
    public static void main(String[] args) {
        int[][] data = {{1,3},{-2,2}};
        int k = 1;
        int[][] ints = KClosest1(data, k);
    }

    // 使用快速排序方法
    public static int[][] KClosest1(int[][] points, int K) {
        // 1.确定一个
        sort(points, 0, points.length - 1);
        return Arrays.copyOfRange(points, 0, K);
    }

    public static void sort(int[][] points, int lo, int hi) {
        if (hi <= lo)
            return;
        int j = partition(points, lo, hi);
        sort(points, lo, j - 1);
        sort(points, j + 1, hi);
    }
    // 快速切分
    // 明确到底是返回i还是j
    public static int partition(int[][] points, int lo, int hi) {
        int i = lo, j = hi+1;
        int res = dist(lo, points);
        while (true) {
            // 两边同时走: i往左走，j往右走
            while (dist(++i, points) < res) if (i == hi) break;
            while (dist(--j, points) > res) if (j == lo) break;
            // 当两者相交 或者j在左边的时候
            if (i >= j) break;
            // 交换
            swap(points, i, j);
        }
        // 最后lo和j交换
        swap(points, lo, j);
        // 返回j
        return j;
    }
    public static void swap(int[][] points, int i, int j) {
        int t0 = points[i][0], t1 = points[i][1];
        points[i][0] = points[j][0];
        points[i][1] = points[j][1];
        points[j][0] = t0;
        points[j][1] = t1;
    }
    public static int dist(int i, int[][] points) {
        return points[i][0] * points[i][0] + points[i][1] * points[i][1];
    }

    public static void quickSort(int begin, int end, int K, int[][] points) {
        // 选择一个中间值
        int point = dist(ThreadLocalRandom.current().nextInt(begin, end), points);
        // 判断
        int i = begin, j = end;
        while (i < j) {
            if (i < j && dist(i, points) < point) i++;
            if (i < j && dist(j, points) > point) j--;
            swap(points, i, j);
        }
        if (i > K) {
            //  如果i> k,则返回
        }

    }










    public static int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }




    public static int[][] kClosest(int[][] points, int K) {
        int[][] res = new int[K][2];
        // 按小到大排序
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return dist(points[o2]) - dist(points[o1]);
            }
        });
        for (int i = 0; i < points.length; i++) {
            queue.offer(i);
            if (queue.size() > K) {
                queue.poll();
            }
        }
        int i = 0;
        while (!queue.isEmpty()) {
            int index = queue.poll();
            res[i][0] = points[index][0];
            res[i][1] = points[index][1];
            i++;
        }

        return res;
    }


}
