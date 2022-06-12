package command.ceilingfan;

public class CeilingFan {
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    String location;
    int speed;

    public CeilingFan(String location) {
        this.location = location;
        this.speed = OFF;
    }

    public int getSpeed() {
        return speed;
    }

    public void high() {
        speed = HIGH;
        System.out.println("Fan Speed In HIGH");
    }

    public void medium() {
        speed = MEDIUM;
        System.out.println("Fan Speed In MEDIUM");
    }

    public void low() {
        speed = LOW;
        System.out.println("Fan Speed In LOW");
    }

    public void off() {
        speed = OFF;
        System.out.println("Fan Speed In OFF");
    }
}
