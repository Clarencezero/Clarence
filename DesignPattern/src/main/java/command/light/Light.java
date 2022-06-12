package command.light;

/**
 * Receiver
 * 具体指令执行者
 */
public class Light {

    public void on() {
        System.out.println("Light ON.");
    }
    public void off() {
        System.out.println("Light OFF.");
    }
}
