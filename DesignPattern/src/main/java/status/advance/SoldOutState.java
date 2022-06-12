package status.advance;

public class SoldOutState implements State{
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("投币成功");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("当前无币，请投币");
    }

    @Override
    public void trunCrank() {
        System.out.println("当前无币，请投币");
    }

    @Override
    public void dispense() {
        System.out.println("当前无币，请投币");
    }

    @Override
    public String toString() {
        return "已发送";
    }
}
