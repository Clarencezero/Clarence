package status.advance;

public class NoQuarterState implements State{
    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("塞入25分钱");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("别这么厚脸皮，根本就没有投币");
    }

    @Override
    public void trunCrank() {
        System.out.println("别这么厚脸皮，根本就没有投币，也就不能获取糖果");
    }

    @Override
    public void dispense() {
        System.out.println("别这么厚脸皮，根本就没有投币");
    }

    @Override
    public String toString() {
        return "未投币";
    }
}
