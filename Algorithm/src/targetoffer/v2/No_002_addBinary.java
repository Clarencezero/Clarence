package targetoffer.v2;

public class No_002_addBinary {
    public static void main(String[] args) {
        No_002_addBinary go = new No_002_addBinary();
        String s1 = "1010", s2 = "1011";
        System.out.println(go.addBinary(s1, s2));
    }
    public String addBinary(String a, String b) {
        if (a == null && a.length() == 0 && b == null && b.length() == 0) return "";
        if (a == null || b == null) return a == null ? b : a;
        StringBuilder sb = new StringBuilder();
        int len = Math.max(a.length(), b.length());
        int carry = 0, aL = a.length() - 1, bL = b.length() - 1;

        // 从后往前
        // 计算当前位的值：cur = (carry + a.charAt(i) + b.charAt(i)) % 2;
        // 计算进位：(carry + a.chat(i) + b.chatAt(i)) / 2
        //
        for (int i = 0; i < len; i++) {
            int res = carry;
            if (i < a.length()) {
                res += a.charAt(aL - i) - '0';
            }
            if (i < b.length()) {
                res += b.charAt(bL - i) - '0';
            }
            carry = res / 2;
            res %= 2;
            sb.append(res);
        }
        if (carry != 0) sb.append(carry);

        return sb.reverse().toString();
    }

}
