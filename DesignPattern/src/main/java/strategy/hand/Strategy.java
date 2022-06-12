package strategy.hand;

/**
 * @author Clarence
 * @date 2020-06-01 20:13
 */
public interface Strategy {
    Hand nextHand();
    void study(boolean win);
}
