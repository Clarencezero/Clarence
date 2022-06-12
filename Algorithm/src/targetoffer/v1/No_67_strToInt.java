package jianzhioffer;

public class No_67_strToInt {
    public static void main(String[] args) {
        No_67_strToInt go = new No_67_strToInt();
        String str = "45";
        String s2 = "  45";
        String s3 = "  -45";
        System.out.println(go.strToInt(str));
    }
    public int strToInt(String str) {
        if (str == null || str.length() == 0) return 0;
        int res = 0, max = Integer.MAX_VALUE / 10, sign = 1;

        char[] chars = str.toCharArray();
        int i = 0;
        // 处理空字符 ' '
        while (chars[i] == ' ') {
            i++;
            if (i > chars.length) break;
        }

        // 处理 符号
        if (chars[i] == '-') sign = -1;
        if (chars[i] == '-' || chars[i] == '+') i++;
        while (i < chars.length) {
            // 处理越界情况
            if (chars[i] < '0' || chars[i] > '9') break;

            if (res > max || res == max && chars[i] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + (chars[i] - '0');
            i++;
        }
        return sign * res;
    }
}
