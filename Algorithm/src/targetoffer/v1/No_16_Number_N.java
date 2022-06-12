package jianzhioffer;

/**
 * Java
 */
public class No_16_Number_N {
    public static void main(String[] args) {
        double x = 2.0;
        int n = -2147483648;
        System.out.println(myPow_2(x, n));
    }


    public static double myPow_(double x, int n) {
        double result = 1.0;
        for (int i = n; i != 0; i /= 2, x *= x) {
            System.out.println(String.format("x:%s, i:%s, result:%s", x, i, result));
            if (i % 2 != 0) {
                //i是奇数
                result *= x;
            }
        }
        return n < 0 ? 1.0 / result : result;
    }

    /**
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow_2(double x, int n) {
        if (n == 0)
            return 1;
        long b = n;
        if (n < 0) {
            x = 1/x;
            b = -b;
        }


        double contributeValue = x;
        double ans = 1.0;
        while (b > 0) {
            // if (b % 2 == 1) {
            if ((b & 1) == 1) {
                ans *= contributeValue;
            }

            // b /=2;
            b >>>=1;
            contributeValue *= contributeValue;
        }

        return ans;
    }

}
