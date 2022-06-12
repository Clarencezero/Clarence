package jianzhioffer;

public class No_45_minNumber {
    // 两个数比较
    // x + y < y + x => x < y
    // x + y > y + x => x > y

    // 传递性
    // x + y < y + x => x < y，y + z < z + y => y < z => x + z < z + x 一定成立
    // => x < y < z
    public static void main(String[] args) {
        String s1 = "30";
        String s2 = "3";
        String c1 = s1 + s2; // 303
        String c2 = s2 + s1; // 330
        System.out.println(c1.compareTo(c2)); //  返回 负数，得
        System.out.println(c2.compareTo(c1)); //  返回 正数，得 c2 > c1
    }


}
