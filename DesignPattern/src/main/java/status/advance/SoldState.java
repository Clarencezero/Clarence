package status.advance;

public class SoldState implements State {
    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("糖果正在发放，请勿投币");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("你都已经转动曲柄了，没有后悔药了");
    }

    @Override
    public void trunCrank() {
        System.out.println("不要重复转动曲柄");
    }

    @Override
    public void dispense() {
        gumballMachine.releaesBall();
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getSoldOutState());
            System.out.println("本次糖果已发放");
        } else {
            System.out.println("Ops, 本机器已没有糖果可给大家了");
            gumballMachine.setState(gumballMachine.soldOutState);
        }
    }

    @Override
    public String toString() {
        return "发送中";
    }
}
