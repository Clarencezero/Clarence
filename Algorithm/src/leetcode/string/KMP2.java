package leetcode.string;

public class KMP2 {
    public static void main(String[] args) {
        KMP2 go = new KMP2();
        String pat = "";
        // int[] next = go.getNext(pat);
        // Util.printArray(next);
        String src = "";
        System.out.println(go.findStr(src, pat));
    }

    private int findStr(String src, String pat) {
        // #1 获取模式串 next 数组
        int[] next = getNext(pat);

        // #2 遍历目标字符串
        int j = -1;
        for (int i = 0; i < src.length(); i++) {
            while (j >= 0 && src.charAt(i) != pat.charAt(j + 1)) {
                // 字符串不匹配，那么就重新定位 j
                j = next[j];
            }

            // 字符串匹配，则更新 j
            if (src.charAt(i) == pat.charAt(j + 1)) j++;

            // 判断是否 src 中出现模式串 pat
            if (j == (pat.length() - 1))
                return ( i - pat.length() + 1);
        }
        return -1;
    }

    /**
     * 根据模式串 {@param pat} 获取 next 数组
     *
     * @param pat   模式串
     * @return
     */
    private int[] getNext(String pat) {
        if (pat.length() == 0) return new int[0];
        // next[i] 表示 s[0, i] 最长相等前、后缀长度
        int[] next = new int[pat.length()];

        // 1. 初始化：定义两个指针 i 和 j，j指向前缀起始位置，i 指向后缀起始位置
        int j = -1;
        // next[0] = -1 是为了计算方便
        next[0] = j;

        for (int i = 1; i < pat.length(); i++) {
            // 2. 处理前后缀不相同的情况（s[i] != s[j+1]）：需要向前回退，从 next[] 数组中找 j+1 前一个元素所在的 next 数组里的值（即 next[j]）
            // 注意，这里使用 while
            while (pat.charAt(i) != pat.charAt(j + 1) && j >= 0) {
                j = next[j];
            }

            // 3. 处理前后缀相同的情况
            if (pat.charAt(i) == pat.charAt(j + 1)) j++;

            // 4. 更新 next[i] 的值
            next[i] = j;
        }

        return next;
    }
}
