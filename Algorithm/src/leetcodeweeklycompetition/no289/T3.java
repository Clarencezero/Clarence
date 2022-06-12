package leetcodeweeklycompetition.no289;

import java.util.Arrays;

public class T3 {
    static int rowLength;
    static int colLength;
    int maxResult = Integer.MIN_VALUE;
    public static void main(String[] args) {
        T3 go = new T3();
        int[][] grid = {{23, 17, 15, 3, 20}, {8, 1, 20, 27, 11}, {9, 4, 6, 2, 21}, {40, 9, 1, 10, 6}, {22, 7, 4, 5, 3}};
        rowLength = grid.length;
        colLength = grid[0].length;
        // 记录含有 5 因素的个数
        int[][] count = new int[rowLength][colLength];
        for (int i = 0; i < rowLength; i++) {
            Arrays.fill(count[i], -1);
        }
        System.out.println(go.maxTrailingZeros(grid));
    }

    public int maxTrailingZeros(int[][] grid) {
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                // int count = dfs(grid, i, j);
                // if (count < maxResult) {
                //     maxResult = count;
                // }
            }
        }

        return maxResult;
    }

    private void dfs(int[][] grid, int[][] count, int x, int y) {
        // 相当于缓存
        if (count[x][y] == -1) {
            count[x][y] = cal(count[x][y]);
        }

        if (y < colLength) {
            // 一直向右走
        }
    }

    private int cal(int number) {
        int temp = number;
        int cnt = 0;
        while (temp % 5 == 0) {
            cnt++;
            temp = temp / 5;
        }
        return cnt;
    }
}
