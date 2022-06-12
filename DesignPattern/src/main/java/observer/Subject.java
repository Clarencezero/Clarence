package observer;

/**
 * 主题接口
 * 注册、通知、移除
 */
public interface Subject {
    /**
     * 注册观察者
     * @param o
     */
    void registerObserver(Observer o);

    /**
     * 移除观察者
     * @param o
     */
    void removeObserver(Observer o);

    /**
     * 当主题状态改变时，这个方法会被调用，以通知所有的观察者
     */
    void notifyObservers();
}
