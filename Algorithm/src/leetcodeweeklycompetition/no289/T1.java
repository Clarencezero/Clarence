package leetcodeweeklycompetition.no289;

/**
 * 111 112 222 23
 * 3 + 4 + 6 + 5 = 3465
 */
public class T1 {
    public static void main(String[] args) {
        T1 go = new T1();
        String s = "1234"; // 3 + 7
        int k = 2;
        System.out.println(go.digitSum(s, k));
    }

    public String digitSum(String s, int k) {
        if (s.length() <= k) {
            return s;
        }
        String str = s;
        while (str.length() > k) {
            str = recusive(str, k);
        }
        return str;

    }

    public String recusive(String s, int k) {
        if (s.length() <= k) {
            return sum(s);
        }
        String cur = s.substring(0, k);
        String res = recusive(s.substring(k), k);
        return sum(cur) + res;
    }

    private String sum(String s) {
        int result = 0;
        for (char c : s.toCharArray()) {
            result += c - '0';
        }
        return String.valueOf(result);
    }
}
