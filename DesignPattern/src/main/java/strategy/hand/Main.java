package strategy.hand;

/**
 * @author Clarence
 * @date 2020-06-01 20:33
 */
public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("P1", new WinningStrategy(314));
        Player p2 = new Player("P2", new ProbStrategy(15));
        for (int i = 0; i < 10000; i++) {
            Hand nextHand1 = p1.nextHand();
            Hand nextHand2 = p2.nextHand();
            if (nextHand1.isStrongerThan(nextHand2)) {
                System.out.println("Winner: " + p1);
                p1.win();
                p2.lose();
            } else if (nextHand2.isStrongerThan(nextHand1)) {
                System.out.println("Lose: " + p2);
                p2.win();
                p1.lose();
            } else {
                System.out.println("Even...");
                p1.even();
                p2.even();
            }
        }

        System.out.println(p1);
        System.out.println(p2);
    }
}
