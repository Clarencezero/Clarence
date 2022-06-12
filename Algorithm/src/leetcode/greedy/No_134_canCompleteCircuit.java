package leetcode.greedy;

public class No_134_canCompleteCircuit {
    public static void main(String[] args) {
        No_134_canCompleteCircuit go = new No_134_canCompleteCircuit();
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        int i = go.canCompleteCircuit(gas, cost);
        System.out.println(i);
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }

        return spare < 0 ? -1 : (minIndex + 1) % len;
    }
}
