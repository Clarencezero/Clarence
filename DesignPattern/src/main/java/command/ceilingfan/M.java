package command.ceilingfan;


import command.RemoteControl;

public class M {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();
        CeilingFan home = new CeilingFan("home");
        CeilingFanHighCommand high= new CeilingFanHighCommand(home);
        CeilingFanMediumCommand medium = new CeilingFanMediumCommand(home);
        CeilingFanLowCommand low = new CeilingFanLowCommand(home);
        CeilingFanOffCommand off = new CeilingFanOffCommand(home);

        remoteControl.setCommand(0, medium, off);
        remoteControl.setCommand(1, high, off);

        // 以中速开启风扇
        remoteControl.onButtonWasPushed(0);
        // 风扇关闭
        remoteControl.offButtonWasPushed(0);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();
        remoteControl.onButtonWasPushed(1);
        remoteControl.undoButtonWasPushed();
    }
}
