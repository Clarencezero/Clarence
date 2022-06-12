package leetcode.backtracking;

public class No_37_solveSudoku {
    public static void main(String[] args) {
        No_37_solveSudoku go = new No_37_solveSudoku();
        char[][] chars = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        go.solveSudoku(chars);
        int len = chars.length;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                System.out.print(chars[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void solveSudoku(char[][] board) {
        if (board.length == 0) return ;

        backTracking(board);
    }

    private boolean backTracking(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.println(String.format("当前行: %s, 当前列: %s", i + 1, j + 1));
                if (board[i][j] != '.') continue;
                for (char k = '1'; k <= '9'; k++) {
                    if (isValid(board, i, j, k)) {
                        board[i][j] = k;
                        if (backTracking(board)) return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int row, int col, int k) {
        // 判断行是否重复
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == k) return false;
        }

        // 判断列是否重复
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == k) return false;
        }

        // 判断方格内是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == k) return false;
            }
        }

        return true;
    }
}
