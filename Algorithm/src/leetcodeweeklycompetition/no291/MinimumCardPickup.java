package leetcodeweeklycompetition.no291;

import java.util.HashSet;
import java.util.Set;

public class MinimumCardPickup {
    public static void main(String[] args) {
        int[] arr = {95, 11, 8, 65, 5, 86, 30, 27, 30, 73, 15, 91, 30, 7, 37, 26, 55, 76, 60, 43, 36, 85, 47, 96, 6};
        MinimumCardPickup go = new MinimumCardPickup();
        System.out.println(go.minimumCardPickup(arr));
    }

    public int minimumCardPickup(int[] cards) {
        if (cards == null || cards.length == 0) return -1;
        Set<Integer> windows = new HashSet<>();
        int minPickCount = Integer.MAX_VALUE;
        int left = 0, right = 0;
        while (right < cards.length) {
            int target = cards[right];
            if (!windows.contains(target)) {
                windows.add(target);
            } else {
                // 包含，则移除
                while (windows.contains(target)) {
                    windows.remove(cards[left]);
                    left++;
                }
                windows.add(target);
                minPickCount = Math.min(minPickCount, (right - left) + 2);
            }
            right++;
        }
        return minPickCount == Integer.MAX_VALUE ? -1 : minPickCount;
    }
}
