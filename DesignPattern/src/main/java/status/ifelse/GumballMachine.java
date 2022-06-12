package status.ifelse;

public class GumballMachine {
    // 卖完了
    final static int SOLD_OUT = 0;
    // 无25分钱
    final static int NO_QUARTER = 1;
    // 有25分钱
    final static int HAS_QUARTER = 2;
    // 在售状态
    final static int SOLD = 3;
    // 初始状态
    int state = SOLD_OUT;
    int count = 0;

    public GumballMachine(int count) {
        this.count = count;
        if (count > 0) {
            state = NO_QUARTER;
        }
    }

    /**
     * 塞入 25 分钱
     */
    public void insertQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("机器已经塞入25分钱，请勿重复塞入");
        } else if (state == SOLD_OUT) {
            System.out.println("当前机器已经售完，塞入25分钱也没用");
        } else if (state == SOLD) {
            System.out.println("请不要心急，机器正在准备给你一个小惊喜");
        } else if (state == NO_QUARTER) {
            state = HAS_QUARTER;
            System.out.println("塞入25分钱成功.可以转动曲柄获取惊喜吧");
        }
    }

    /**
     * 退回25分钱
     */
    public void ejectQuarter() {
        if (state == HAS_QUARTER) {
            state = NO_QUARTER;
            System.out.println("成功退回25分钱.");
        } else if (state == SOLD_OUT) {
            System.out.println("没有惊喜了. 糖果已经卖完了，你怎么还有脸来退钱呢");
        } else if (state == SOLD) {
            System.out.println("你都已经转动曲柄了，没有后悔药了");
        } else if (state == NO_QUARTER) {
            System.out.println("别这么厚脸皮，根本就没有投币");
        }
    }

    /**
     * 转动曲柄
     */
    public void turnCrank() {
        if (state == HAS_QUARTER) {
            System.out.println("转动曲柄，即将发放糖果");
            state = SOLD;
        } else if (state == SOLD_OUT) {
            System.out.println("已经没有糖果了");
        } else if (state == SOLD) {
            System.out.println("别想骗我们拿两次糖果");
        } else if (state == NO_QUARTER) {
            System.out.println("需要投入25分钱才能转动曲柄");
        }
    }

    /**
     * 发放糖果
     */
    public void dispense() {
        if (state == HAS_QUARTER) {
            System.out.println("无法发放糖果");
        } else if (state == SOLD_OUT) {
            System.out.println("无法发放糖果");
        } else if (state == SOLD) {
            count -=1;
            if (count == 0) {
                System.out.println("Oh, 糖果已经卖完了");
                state = SOLD_OUT;
            } else {
                state = NO_QUARTER;
                System.out.println("已售出糖果");
            }
        } else if (state == NO_QUARTER) {
            System.out.println("无法发放糖果");
        }
    }

    @Override
    public String toString() {
        return  "当前糖果机器状态: " + state + ", 剩余糖果数: " + count;
    }
}
