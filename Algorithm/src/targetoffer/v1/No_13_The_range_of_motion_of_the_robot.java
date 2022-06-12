package jianzhioffer;

public class No_13_The_range_of_motion_of_the_robot {
    public static void main(String[] args) {
        No_13_The_range_of_motion_of_the_robot t = new No_13_The_range_of_motion_of_the_robot();
        System.out.println(t.movingCount_1(3, 2, 17));
    }

    static int total = 0;
    public int movingCount_1(int m, int n, int k) {
        if (k == 0)
            return 1;
        boolean[][] array = new boolean[m][n];
        doRecursion(0, 0, k, array);
        return total;
    }

    private boolean doRecursion(int i, int j, int k, boolean[][] array) {
        if (i < 0 || i > array.length - 1 || j < 0 || j > array[0].length - 1 || array[i][j])
            return false;

        int sum = i / 10 + i % 10 + j / 10 + j % 10;
        if (sum > k)
            return false;

        // 记录
        array[i][j] = true;
        boolean ret = doRecursion(i - 1, j, k, array)
                || doRecursion(i + 1, j, k, array)
                || doRecursion(i, j - 1, k, array)
                || doRecursion(i, j + 1, k, array);
        total++;
        return ret;
    }
}
