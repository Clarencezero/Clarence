package leetcode.dp;

import java.util.Arrays;

public class No_354_maxEnvelopes {
    public static void main(String[] args) {
        No_354_maxEnvelopes go = new No_354_maxEnvelopes();
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        go.maxEnvelopes(envelopes);
    }

    public int maxEnvelopes(int[][] envelopes) {
        // 对 envelopes 进行排序
        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? Integer.compare(o2[1], o1[1]) : Integer.compare(o1[0], o2[0]));

        return 0;
    }
}
