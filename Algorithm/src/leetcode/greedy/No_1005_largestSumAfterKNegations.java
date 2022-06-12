package leetcode.greedy;

import java.util.Arrays;

public class No_1005_largestSumAfterKNegations {
    public static void main(String[] args) {
        No_1005_largestSumAfterKNegations go = new No_1005_largestSumAfterKNegations();
        int[] nums = {2,-3,-1,5,-4};

        int i = go.largestSumAfterKNegations(nums, 6);
        System.out.println(i);
    }

    public int largestSumAfterKNegations(int[] A, int K) {
        if (A.length == 1) return K % 2 == 0 ? A[0] : -A[0];
        Arrays.sort(A);
        int sum = 0;
        int idx = 0;
        for (int i = 0; i < K; i++) {
            if (i < A.length - 1 && A[idx] < 0) {
                A[idx] = -A[idx];
                if (A[idx] >= Math.abs(A[idx + 1])) idx++;
                continue;
            }
            A[idx] = -A[idx];
        }

        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        return sum;
    }

}
