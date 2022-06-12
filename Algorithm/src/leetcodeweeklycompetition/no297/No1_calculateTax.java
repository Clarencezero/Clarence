package leetcodeweeklycompetition.no297;

public class No1_calculateTax {
    public static void main(String[] args) {
        No1_calculateTax go = new No1_calculateTax();
        int[][] brackets = {{1, 0}, {4, 25}, {5, 50}};
        int income = 2;
        System.out.println(go.calculateTax(brackets, income));
    }

    public double calculateTax(int[][] brackets, int income) {
        double disCount = 0.0d;
        int preCent = 0;
        for (int[] bracket : brackets) {
            int min = Math.min(bracket[0], income);
            disCount += (min - preCent) * bracket[1] * 0.01;
            preCent = bracket[0];
            if (income < bracket[0]) {
                break;
            }
        }
        return disCount;
    }
}
