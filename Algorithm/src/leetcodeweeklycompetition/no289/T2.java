package leetcodeweeklycompetition.no289;

import java.util.Arrays;

public class T2 {
    public static void main(String[] args) {
        T2 go = new T2();
        int[] arr = {2,2,3,3,2,4,4,4,4,4}; // 4
        System.out.println(go.minimumRounds(arr));
    }

    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int total = 0;

        for (int i = 0; i < tasks.length; i++) {
            int k = tasks[i];
            int count = 1;
            while (i + 1 < tasks.length && tasks[i + 1] == k) {
                count++;
                i++;
            }
            if (count < 2) {
                return -1;
            }

            total += ((count + 3 - 1) / 3);
        }

        return total;
    }
}
