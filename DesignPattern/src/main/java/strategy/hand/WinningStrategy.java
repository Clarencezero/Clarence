package strategy.hand;

import java.util.Random;

/**
 * 如果上一局手势获胜了，下一局的手势相同
 * @author Clarence
 * @date 2020-06-01 20:14
 */
public class WinningStrategy implements Strategy{
    private Random random;
    private boolean won = false;
    private Hand prevHand;

    public WinningStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        if (!won) {
            prevHand = Hand.getHAND(random.nextInt(3));
        }
        return prevHand;
    }

    @Override
    public void study(boolean win) {
        won = win;
    }
}
