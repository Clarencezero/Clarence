package jianzhioffer;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * 这一题需要是考查图的知识。
 */
public class No_12_ThePathInMatrix {
    public static void main(String[] args) {
        char[][] board = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
        System.out.println(exist_1(board, "bfce"));
    }

    /**
     * DFS + 剪枝
     *
     * @param board
     * @param word
     * @return
     */
    public static boolean exist_1(char[][] board, String word) {
        char[] wordChars = word.toCharArray();

        // 二数组每个位置都可做起始点
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 从该点做DFS搜索，如果字符串存在，则返回 true，否则继续下一个节点
                if (doRecursion(i, j, 0, board, wordChars)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean doRecursion(int i, int j, int k, char[][] board, char[] word) {
        // 边界条件判断
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word[k] != board[i][j]) {
            return false;
        }

        // 成功找到最后一个元素
        if (k == word.length - 1) {
            return true;
        }

        // 对已遍历的数据做标记
        char temp = board[i][j];
        board[i][j] = '\0';

        // 从四个方向查找
        // 重点: 不能用k++替代k+1，因为，这会改变后续的指针情况
        boolean ret = doRecursion(i, j - 1, k+1, board, word)           // 向左
                || doRecursion(i, j + 1, k+1, board, word)              // 向右
                || doRecursion(i - 1, j, k+1, board, word)              // 向上
                || doRecursion(i + 1, j, k+1, board, word);             // 向下


        // 重点: 还原数据
        board[i][j] = temp;
        return ret;
    }
}
