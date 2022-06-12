package observer;

/**
 * 当前观察者实现类之二
 */
public class TempConditionDisplay implements Observer, DisplayElement{
    private float temp;
    public TempConditionDisplay(Subject subject) {
        subject.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Temp Condition Display，Current temp is " + temp);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        display();
    }
}
