package strategy.hand;

import java.util.Random;

/**
 * 随机出手势，但是每种手势出现的概念会根据以前的猜拳结果而改变
 *
 * @author Clarence
 * @date 2020-06-01 20:35
 */
public class ProbStrategy implements Strategy{
    private Random random;
    private int prevHandValue = 0;
    private int currentHandValue = 0;
    private int[][] history = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
    };
    public ProbStrategy(int seed) {
        random = new Random(seed);
    }


    /**
     * 下一个值
     * @return
     */
    @Override
    public Hand nextHand() {
        int bet = random.nextInt(getSum(currentHandValue));
        int handvalue = 0;
        if (bet < history[currentHandValue][0]) {
            handvalue = 0;
        } else if (bet <history[currentHandValue][0] + history[currentHandValue][1] ) {
            handvalue = 1;
        }else {
            handvalue = 2;
        }
        prevHandValue = currentHandValue;
        currentHandValue = handvalue;
        return Hand.getHAND(handvalue);
    }

    private int getSum(int h) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += history[h][i];
        }
        return sum;
    }

    @Override
    public void study(boolean win) {
        if (win) {
            history[prevHandValue][currentHandValue]++;
        }else {
            history[prevHandValue][(currentHandValue + 1) % 3]++;
            history[prevHandValue][(currentHandValue + 2) % 3]++;
        }
    }
}
