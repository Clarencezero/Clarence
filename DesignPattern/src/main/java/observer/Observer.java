package observer;
/**
 * 定义观察者共同行为
 */
public interface Observer {
    /**
     * 所有观察者必须实现接口。当主题值改变时，会调用此方法
     * @param temp
     * @param humidity
     * @param pressure
     */
    void update(float temp, float humidity, float pressure);
}
