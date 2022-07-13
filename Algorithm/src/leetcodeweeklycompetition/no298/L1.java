package leetcodeweeklycompetition.no298;

public class L1 {
    public static void main(String[] args) {
        L1 go = new L1();
        System.out.println(go.greatestLetter("lEeTcOdE"));
    }
    public String greatestLetter(String s) {
        if (s == null || s.length() == 0) return "";
        char[] chars = s.toCharArray();
        boolean[] big = new boolean[26];
        boolean[] small = new boolean[26];
        for (char c : chars) {
            if ((c - 'a') >= 0) {
                small[c - 'a'] = true;
            } else {
                big[c - 'A'] = true;
            }
        }

        for (int i = 25; i >= 0; i--) {
            if (big[i] && small[i] ) {
                return String.valueOf((char)(i + 65));
            }
        }
        return "";
    }
}
