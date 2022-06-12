package leetcode.backtracking;

import util.Util;

import java.util.ArrayDeque;
import java.util.Deque;

public class No_542_updateMatrix {
    public static void main(String[] args) {
        No_542_updateMatrix go = new No_542_updateMatrix();
        int[][] matrix = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] ints = go.updateMatrix1(matrix);
        Util.printTwoDimensionalArray(ints);
    }


    /**
     * 解法一：广度优先搜索
     */
    public int[][] updateMatrix1(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[][] dist = new int[row][col];
        boolean[][] seen = new boolean[row][col];
        Deque<int[]> queue = new ArrayDeque<>();

        // 将所有 0 添加到队列中
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <col; j++) {
                if (matrix[i][j] == 0) {
                    queue.addLast(new int[] {i, j});
                    seen[i][j] = true;
                }
            }
        }



        // 广度优先搜索
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] cell = queue.pollLast();
            int x = cell[0], y = cell[1];
            // 从各个0同时一圈一圈地向 1 扩散，扩散时更新 dist 来记录距离，这个值就是扩散的层次，并且更新访问标志位
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX >= 0 && newX < row && newY >=0 && newY < col && !seen[newX][newY]) {
                    dist[newX][newY] = dist[x][y] + 1;
                    queue.addFirst(new int[]{newX, newY});
                    seen[newX][newY] = true;
                }
            }
         }

        return dist;
    }
}
