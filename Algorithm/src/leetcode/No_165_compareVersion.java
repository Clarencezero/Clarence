package leetcode;

public class No_165_compareVersion {
    public static void main(String[] args) {
        No_165_compareVersion go = new No_165_compareVersion();
        String v1 = "1.0.1", v2 = "1";
        System.out.println(go.compareVersion(v1, v2));
    }

    public int compareVersion(String v1, String v2) {
        if (v1 == null || v2 == null || v1.length() == 0 || v2.length() == 0) return 0;
        String[] sp1 = v1.split("\\.");
        String[] sp2 = v2.split("\\.");
        int i = 0, j = 0, n = sp1.length, m = sp2.length;
        while (i < n || j < m) {
            int a = 0, b = 0;
            if (a < n) a = Integer.valueOf(sp1[i++]);
            if (b < m) b = Integer.valueOf(sp2[j++]);
            System.out.println(a + " : " + b);
            return a > b ? 1 : -1;
        }
        return 0;
    }
}
