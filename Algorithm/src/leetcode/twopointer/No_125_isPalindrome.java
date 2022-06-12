package leetcode.twopointer;

public class No_125_isPalindrome {
    public static void main(String[] args) {
        No_125_isPalindrome go = new No_125_isPalindrome();
        System.out.println(go.isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int l = 0, r = s.length() - 1;
        // char a1 = 'A', a2 = 'a', z1 = 'Z', z2 = 'z';
        // System.out.println(String.format("%s, %s, %s, %s", (int)a1, (int)a2, (int)z1, (int)z2));
        while (l < r) {
            char c1, c2;
            while ((c1 = format(s.charAt(l))) == ' ') { l++; }
            while ((c2 = format(s.charAt(r))) == ' ') { r--; }
            System.out.println(c1 + " " + c2);
            if (c1 != c2) return false;
            l++;
            r--;
        }
        return true;
    }

    private char format(char c) {
        if (65 <= c && c <= 90) return (char)(c + 32);
        else if (97 <= c && c <= 122) return c;
        else return ' ';
    }
}
