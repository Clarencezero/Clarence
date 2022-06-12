package strategy.hand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Clarence
 * @date 2020-06-01 20:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hand {
    public static final int HANDVALUE_GUU = 0; // 石头
    public static final int HANDVALUE_CHO = 1; // 剪刀
    public static final int HANDVALUE_PAA = 2; // 布

    public static final Hand[] HAND = {
            new Hand(HANDVALUE_CHO),
            new Hand(HANDVALUE_CHO),
            new Hand(HANDVALUE_CHO)
    };

    public static final String[] NAME = {"石头", "剪刀", "布"};
    private int handValue;
    public static Hand getHAND(int handValue) {
        return HAND[handValue];
    }

    public boolean isStrongerThan(Hand h) {
        return fight(h) == 1;
    }

    private int fight(Hand h) {
        if (this == h) {
            // 平
            return 0;
        } else if ((this.handValue + 1) % 3 == h.handValue) {
            // 胜
            return 1;
        }else {
            // 负
            return -1;
        }
    }

    @Override
    public String toString() {
        return NAME[handValue];
    }
}
