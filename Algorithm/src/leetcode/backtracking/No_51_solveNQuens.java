package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class No_51_solveNQuens {
    public static void main(String[] args) {
        char[][] c = new char[1][1];
        c[0][0] = 3;

        No_51_solveNQuens go = new No_51_solveNQuens();
        List<List<String>> lists = go.solveNQueens(4);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) return res;
        char[][] path = new char[n][n];
        initCharArray(path);
        backTracking(n, n, 0, path);
        return res;
    }

    private void initCharArray(char[][] path) {
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[0].length; j++) {
                path[i][j] = '.';
            }
        }
    }

    private void backTracking(int n, int remain, int row, char[][] path) {
        if (remain == 0) {
            if (row == n) {
                res.add(new ArrayList<>(arrayToList(path)));
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!canPlace(path, row, i)) continue;
            path[row][i] = 'Q';
            backTracking(n, remain - 1, row + 1, path);
            path[row][i] = '.';
        }
    }

    private List<String> arrayToList(char[][] path) {
        List<String> strings = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < path.length; i++) {
            stringBuilder.setLength(0);
            for (int j = 0; j < path[0].length; j++) {
                stringBuilder.append(path[i][j]);
                strings.add(stringBuilder.toString());
            }
        }

        return strings;
    }


    private boolean canPlace(char[][] path, int row, int col) {
        // 判断所在的行的不为Q
        for (int i = 0; i < path[0].length; i++) {
            if (path[row][i] == 'Q') return false;
        }

        // 判断所在的列不为Q
        for (int i = 0; i < path.length; i++) {
            if (path[i][col] == 'Q') return false;
        }

        // 判断左上角是否出现冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            System.out.println("45° 检查: " + i + ", " + j);
            if (path[i][j] == 'Q') return false;
        }

        // 判断右上角是否出现冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < path.length; i--, j++) {
            if (path[i][j] == 'Q') return false;
        }

        return true;
    }

}
