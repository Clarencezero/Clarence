package status.advance;

public class HasQuarterState implements State{
    GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("已经塞入25分钱，请勿重复塞入钱币");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("钱币已退回");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void trunCrank() {
        System.out.println("转动曲柄，即将发放糖果");
        gumballMachine.setState(gumballMachine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("请先转动曲柄，才能发放糖果");
    }

    @Override
    public String toString() {
        return "已投币";
    }
}
