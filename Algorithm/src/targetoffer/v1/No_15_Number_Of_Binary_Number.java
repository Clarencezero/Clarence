package jianzhioffer;

public class No_15_Number_Of_Binary_Number {
    public static void main(String[] args) {
        System.out.println(hammingWeight_2(4));
    }

    public static int hammingWeight(int n) {
        int i = 1;
        int count = 0;
        while (i > 0) {
            if ((i & n) > 0) {
                count++;
            }
            i = i << 1;
        }
        return count;
    }

    public static int hammingWeight_2(int n) {
        int count = 0;
        while(n != 0) {
            if ((n & (n - 1)) > 0) {
                count++;
            }
            n-=1;
        }

        return count;
    }
}
