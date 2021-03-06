package targetoffer.v2;

public class No_001_divide {
    public static void main(String[] args) {
        No_001_divide go = new No_001_divide();
        System.out.println(Integer.MIN_VALUE);
        System.out.println(go.helper(Integer.MIN_VALUE, 2));
        int i = -5;
        System.out.println((long)i);
    }

    public int helper(int dividend, int divisor) {
        // 当除数为1，直接返回被除数
        if (divisor == 1) {
            return dividend;
        }
        // 当除数为-1且被除数为Integer.MIN_VALUE时，将会溢出，返回Integer.MAX_VALUE
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        // 把被除数与除数调整为正数,为防止被除数Integer.MIN_VALUE转换为正数会溢出，使用long类型保存参数
        if (dividend < 0 && divisor < 0) {
            return helper(-(long) dividend, -(long) divisor);
        } else if (dividend < 0 || divisor < 0) {
            return -helper(Math.abs((long) dividend), Math.abs((long) divisor));
        } else {
            return helper((long) dividend, (long) divisor);
        }
    }

    public int helper(long dividend, long divisor) {
        // 如果被除数小于除数，结果明显为0
        if (dividend < divisor) {
            return 0;
        }
        long sum = divisor; // 记录用了count个divisor的和
        int count = 1; // 使用了多少个divisor
        while (dividend >= sum) {
            // 每次翻倍
            sum <<= 1;
            count <<= 1;
        }

        // 此时dividend < sum
        sum >>>= 1;
        count >>>= 1;

        // 此时dividend >= sum
        // 将count个divisor从dividend消耗掉，剩下的还需要多少个divisor交由递归函数处理
        return count + helper(dividend - sum, divisor);
    }
}
