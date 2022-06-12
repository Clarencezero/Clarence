package leetcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class No_452_findMinArrowShots {
    public static void main(String[] args) {
        int[][] arrays = {{1,2}, {3,4}, {5,6}};
        Arrays.sort(arrays, (p1, p2) ->  p1[1] > p2[1] ? -1 : 1);
        Arrays.sort(arrays, (i1, i2) -> {
            if (i1[0] != i2[0]) return i1[0] > i2[0] ? 1 : -1;
            else return i1[1] > i2[0] ? 1 : -1;
        });
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[0].length; j++) {
                System.out.print(arrays[i][j] + " ");
            }
            System.out.println();
        }

        ArrayList arrayList  = new ArrayList();
        System.out.println(arrays.length);   //
        System.out.println(arrays[0].length);
        System.out.println(arrays[0]);
        System.out.println(arrays[0][0]);
        System.out.println(arrays[0][1]);
        System.out.println(arrays[1][0]);
    }

    public int findMinArrowShots(int[][] points) {
        // 对数组进行排序
        int[][] result = new int[points.length][points[0].length];

        return 0;
    }
}
