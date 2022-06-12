package command.ceilingfan;


import command.Command;

public class CeilingFanLowCommand implements Command {
    CeilingFan ceilingFan;
    // 增加局部状态变量，以便追踪吊扇之前的速度
    int prevSpeed;
    public CeilingFanLowCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        // 先将它的状态记录下来，以便需要撤销的时候用到
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.low();
    }

    @Override
    public void undo() {
        if (prevSpeed == 3) {
            ceilingFan.high();
        } else if (prevSpeed == 2) {
            ceilingFan.medium();
        } else if (prevSpeed == 1) {
            ceilingFan.low();
        } else {
            ceilingFan.off();
        }
    }
}
