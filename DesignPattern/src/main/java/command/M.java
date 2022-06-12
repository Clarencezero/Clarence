package command;


import command.Garagedoor.GarageDoor;
import command.Garagedoor.GarageDoorOffCommand;
import command.Garagedoor.GarageDoorOnCommand;
import command.light.Light;
import command.light.LightOffCommand;
import command.light.LightOnCommand;

/**
 * 命令模式可以将`动作的请求者`从`动作的执行者`对象中解耦。
 * 1.遥控器应该知道如何解读按钮被按下的动作，然后发出正确的请求。但是不知道这些家电自动化的细节。
 * 2.使用状态实现撤销。
 * 3.命令模式更多用途: 队列请求。命令可以将运算块打包(一个接收者和一组动作)，然后将它传来传去。就像是一般的对象一样。利用这样的特性衍生出: 日程安排(Scheduler)、线程池、工作队列。
 *   在某一端添加命令，然后另一端则是线程。线程进行如下操作: 从队列中取出一个命令，调用它的execute()方法，等待这个调用完成，然后将此命令对象丢弃，再取出下一个命令。...
 *
 */
public class M {
    /**
     * M 为命令模式的客户。Client
     */
    public static void main(String[] args) {
        // 遥控器就是调用者，会传入一个命令对象，可以用来发出请求
        RemoteControl remoteControl = new RemoteControl();
        // 现在创建了一个电灯对象，此对象也是请求的接收者
        Light light = new Light();
        // 创建一个命令，并将接收者传递给命令
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);

        // 模拟按下按钮
        // 在简单的遥控器中，我们先用一个 `打开电灯`命令加载按钮插槽，后来替换为`打开车库电灯`命令。
        // 遥控器插槽并根本不在乎所拥有的是什么命令对象。只要该命令对象实现了`command`接口就可以。
        GarageDoor garageDoor = new GarageDoor();
        GarageDoorOnCommand garageDoorOnCommand = new GarageDoorOnCommand(garageDoor);
        GarageDoorOffCommand garageDoorOffCommand = new GarageDoorOffCommand(garageDoor);

        remoteControl.setCommand(0, lightOnCommand, lightOffCommand);
        remoteControl.setCommand(1, garageDoorOnCommand, garageDoorOffCommand);

        remoteControl.onButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(0);
        remoteControl.undoButtonWasPushed();
        remoteControl.offButtonWasPushed(1);

    }
}
