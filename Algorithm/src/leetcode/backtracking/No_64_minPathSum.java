package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 最小路径和：使用回溯算法
 */
class Pair {
    public int row;
    public int col;
    public int val;

    public Pair(int row, int col, int val) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "(" + row + "," + col + ")";
    }
}

/**
 *
 */
public class No_64_minPathSum {
    private int minVal = Integer.MAX_VALUE;
    private List<Integer> minValToPath;

    public static void main(String[] args) {
        No_64_minPathSum go = new No_64_minPathSum();
        int[][] grids = {{1, 2, 3}, {4, 5, 6}};
        List<Integer> minPath = go.getMinPath(grids);
        for (Integer integer : minPath) {
            System.out.print(integer + " ");
        }
    }

    private List<Integer> getMinPath(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row][col];
        Pair[][] path = new Pair[row][col];

        // base case
        dp[0][0] = grid[0][0];
        path[0][0] = new Pair(0, 0, grid[0][0]);
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
            path[0][i] = new Pair(0, i - 1, grid[0][i - 1]);
        }

        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
            path[i][0] = new Pair(i - 1, 0, grid[i - 1][0]);
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                int left = dp[i - 1][j];
                int up = dp[i][j - 1];
                if (left < up) {
                    dp[i][j] = left + grid[i][j];
                    path[i][j] = new Pair(i - 1, j, grid[i - 1][j]);
                } else {
                    dp[i][j] = up + grid[i][j];
                    path[i][j] = new Pair(i, j - 1, grid[i][j - 1]);
                }
            }
        }

        // 复原路径
        Pair last = path[row - 1][col - 1];
        List<Integer> res = new ArrayList<>();
        res.add(grid[row - 1][col - 1]);
        while (last.col > 0) {
            res.add(grid[last.row][last.col]);
            last = path[last.row][last.col];
        }
        res.add(grid[0][0]);

        Collections.reverse(res);
        return res;
    }

    private void print(Pair[][] arr) {
        for (Pair[] pairs : arr) {
            for (Pair pair : pairs) {
                System.out.print(pair + " ");
            }
            System.out.println();
        }
    }


    public void testmemo() {
        No_64_minPathSum go = new No_64_minPathSum();

        int[][] grids = {{1, 3, 1}, {1, 5, 1}};
        int row = grids.length, col = grids[0].length;
        int[][] memo = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(memo[i], -1);
        }
        System.out.println(go.dp(grids, row - 1, col - 1, memo));
    }



    /**
     * 理解这个函数的含义：计算从左上角到右下角的最小路径和
     *
     * 我们需要求 D->A 的最小路径，而只有两个点才能到 A，也就是 B 和 C
     * 因为，我们将问题转化为 D -> B 和 D -> C 的子问题，然后求这两者最小值 + val[A] 就可以得到 D->A 的最小路径
     *
     *
     * @param grids
     * @param row
     * @param col
     * @return
     */
    private int dp(int[][] grids, int row, int col, int[][] memo) {
        if (row == 0 && col == 0) return grids[0][0];

        // 越界
        if (row < 0 || col < 0) return Integer.MAX_VALUE;
        if (memo[row][col] != -1) return memo[row][col];
        // System.out.println("row: " + row + ", col: " + col);
        int left = dp(grids, row - 1, col, memo);
        int up = dp(grids, row, col - 1, memo);

        System.out.println(String.format("计算[%s, %s]", col, row));
        memo[row][col] = Math.min(left, up) + grids[row][col];

        return memo[row][col];
    }


    /**
     * 这个回溯可以写出来，但是 memo 概念不能加入，所以理解是有歧义的
     *
     * @param grids
     * @param row
     * @param col
     * @param sum   累加的和
     * @param path  这个和对应的路径
     */
    private int backTracking(int[][] grids, int row, int col, int sum, List<Integer> path, int[][] memo) {
        if (col >= grids[0].length || row >= grids.length) return -1;
        if (row == grids.length - 1 && col == grids[0].length - 1) {
            System.out.println(path);
            if (sum < minVal) {
                minVal = sum;
                minValToPath = new ArrayList<>(path);
                minValToPath.add(grids[row][col]);
            }
        }
        if (memo[row][col] != -1) {
            System.out.println("命中: " + memo[row][col]);
            return memo[row][col];
        }


        // 下面节点到终点的最短路径
        path.add(grids[row][col]);
        // 右节点到终点的最短路径
        int right = backTracking(grids, row, col + 1, sum + grids[row][col], path, memo);
        int down = backTracking(grids, row + 1, col, sum + grids[row][col], path, memo);

        path.remove(path.size() - 1);

        memo[col][row] = Math.min(down, right);
        return memo[col][row];
    }


}
