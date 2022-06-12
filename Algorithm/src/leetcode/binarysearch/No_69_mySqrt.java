package leetcode.binarysearch;

public class No_69_mySqrt {
    public static void main(String[] args) {
        No_69_mySqrt go = new No_69_mySqrt();
        System.out.println(go.mySqrt2(8));
    }

    public int mySqrt(int x) {
        if (x == 0) return 0;
        double c = x, x0 = x;
        while (true) {
            // xi+1 = 1/2(xi + C/xi)
            double xi = 0.5 * (x0 + c/x0);
            if (Math.abs(x0 - xi) < 1e-7) break;
            x0 = xi;
        }

        return (int)x0;
    }

    public int mySqrt2(int x) {
        if (x == 0) return 0;
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println(String.format("搜索区间: [%s, %s], mid:%s", left, right, mid));
            int sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            } else if (sqrt > mid) {
                left = mid + 1;
            } else if (sqrt < mid) {
                right = mid - 1;
            }
        }
        System.out.println(String.format("搜索区间: [%s, %s]", left, right));

        return right;
    }
}
