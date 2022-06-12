package status.advance;


public class M {
    public static void main(String[] args) {
        int i = 1;
        int j = i++;
        // if ((i == (++j)) && ((i++) == j)) {
        //     i += j;
        // }
        System.out.println(j);
        System.out.println("i = " + i);
        // GumballMachine gumballMachine = new GumballMachine(2);
        // System.out.println(gumballMachine);
        //
        // // 测试非法操作
        // gumballMachine.turnCrank();
        // gumballMachine.ejectQuarter();
        //
        // // 正常流程
        // gumballMachine.insertQuarter();
        // gumballMachine.turnCrank();
        // System.out.println(gumballMachine);
    }
}
