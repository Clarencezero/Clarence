package status.advance;

public interface State {
    /**
     * 投币动作
     */
    void insertQuarter();

    /**
     * 退回动作
     */
    void ejectQuarter();

    /**
     * 转动曲柄动作
     */
    void trunCrank();

    /**
     * 发放糖果
     */
    void dispense();
}
