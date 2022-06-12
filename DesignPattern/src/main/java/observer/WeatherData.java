package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 主题接口实现类
 */
public class WeatherData implements Subject {
    /**
     * 温度
     */
    private float temperature;
    /**
     * 湿度
     */
    private float humidity;
    /**
     * 压力
     */
    private float pressure;

    /**
     * 观察者列表
     */
    private List<Observer> observerList;

    public WeatherData() {
        observerList = new ArrayList<>();
    }

    /**
     * 注册观察者对象
     *
     * @param o
     */
    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    /**
     * 解除观察者对象
     *
     * @param o
     */
    @Override
    public void removeObserver(Observer o) {
        observerList.remove(o);
    }

    /**
     * 通知所有观察者
     */
    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update(temperature, humidity, pressure);
        }
    }

    /**
     * 当测试值改变时，调用通知方法
     */
    public void measurementsChange() {
        notifyObservers();
    }

    /**
     * 此方法模拟测量值改变
     */
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChange();
    }
}
