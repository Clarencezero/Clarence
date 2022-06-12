package leetcode.binarysearch;

public class No_firstBadVersion {
    public static void main(String[] args) {
        No_firstBadVersion go = new No_firstBadVersion();
        System.out.println(go.firstBadVersion(5));
    }


    public int firstBadVersion(int n) {
        if (n < 0) return -1;
        int left = 1, right = n + 1;
        while (left < right) {
            System.out.println(String.format("搜索区间: [%s, %s]", left, right));
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                // 收缩右边界，因为我们需要找到第一个出错的版本
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left > n) return -1;
        return left;
    }

    private boolean isBadVersion(int k) {
        return k >= 9;
    }
}
