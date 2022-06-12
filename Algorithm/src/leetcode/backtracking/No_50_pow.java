package leetcode.backtracking;

public class No_50_pow {
    public static void main(String[] args) {
        No_50_pow main = new No_50_pow();
        System.out.println(main.myPow(2.00000, 10));

        System.out.println((3 & 1) == 0); // 奇数
        System.out.println((4 & 1) == 0); // 偶数
        System.out.println(2 >>> 1);
        System.out.println(1 >>> 1);
    }

    public double myPow(double x, int n) {
        // 转为负数
        int b = n < 0 ? -n : n;
        return helper(x, n);
    }

    private double helper(double x, int n) {
        if (n == 0) {
            return 1;
        }

        // 除2
        int t = n >>> 1;

        if ((t & 1) == 0) {
            // 偶数s
            double y = helper(x, t);
            return y * y;
        } else {
            double y = helper(x, t);
            return y * y * x;
        }
    }
}
