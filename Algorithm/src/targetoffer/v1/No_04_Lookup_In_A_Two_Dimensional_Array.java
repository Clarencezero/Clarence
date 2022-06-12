package jianzhioffer;

/**
 * 剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class No_04_Lookup_In_A_Two_Dimensional_Array {
    static int[][] ARRAY = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}};
    static int[][] ARRAY_NULL = {{}, {}, {}, {}};
    static int[][] ARRAY_NULL_1 = {};
    static int[][] ARRAY_ERROR = {{1, 1}};
    static int[][] ARRAY_ERROR_2 = {{5}, {6}};

    public static void main(String[] args) {
        getTwoDimensionalArrayLength();
        // System.out.println(findNumberIn2DArray_1(ARRAY, 5));
        // System.out.println(findNumberIn2DArray_1(ARRAY_NULL, 5));
        // System.out.println(findNumberIn2DArray_1(ARRAY_NULL, 5));
        System.out.println(findNumberIn2DArray_3(ARRAY, 5));
    }

    public static void getTwoDimensionalArrayLength() {
        // System.out.println(ARRAY_ERROR.length);       // 行数-4
        // System.out.println(ARRAY_ERROR[0].length);    // 列数-5

        // (i,j): j++: 左移 i++: 下移
        System.out.println(ARRAY[0][0]);
        System.out.println(ARRAY[0][1]);
    }

    // 思路一: 暴力循环遍历
    public static boolean findNumberIn2DArray_1(int[][] matrix, int target) {
        // 做任何题之前都需要判断边界条件
        if (matrix == null || matrix.length == 0)
            return false;
        int columnLength = matrix[0].length;
        int lineLength = matrix.length;

        for (int i = 0; i < columnLength; i++) {
            for (int j = 0; j < lineLength; j++) {
                if (matrix[j][i] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // [
    //   [1,   4,  7, 11, 15],
    //   [2,   5,  8, 12, 19],
    //   [3,   6,  9, 16, 22],
    //   [10, 13, 14, 17, 24],
    //   [18, 21, 23, 26, 30]
    // ]
    // 从右上角开始，可以通过第一个数判断
    // 思路二: 从右上角循环遍历
    public static boolean findNumberIn2DArray_2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length < 1) {
            return false;
        }

        // 从右上角遍历
        for (int i = matrix[0].length - 1; i >= 0; i--) {
            if (matrix[0][i] == target) {
                return true;
            } else if (matrix[0][i] < target) {
                // 遍历当前列
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[j][i] == target) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    // 来自Leetcode简洁写法，使用while控制变量，创建两个指针，分别指向横坐标、纵坐标
    public static boolean findNumberIn2DArray_3(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length < 1) {
            return false;
        }

        // 从右上角遍历
        int column = matrix[0].length - 1;  // 列值
        int line = matrix.length - 1;       // 行值
        int i = 0, j = column; // 指针

        while (j >= 0 && i <= line) {
            // 如果目标值大于当前矩阵值，则下移
            if (matrix[i][j] < target) {
                i++;
            } else if (matrix[i][j] == target) {
                return true;
            } else {
                // 如果目标值小于当前矩阵值，则左移
                j--;
            }
        }
        return false;
    }

}
