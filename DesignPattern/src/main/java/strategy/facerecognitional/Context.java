package strategy.facerecognitional;

/**
 * 持有具体策略实现的引用，调用具体策略实现类的接口方法
 */
public class Context {
    private FaceRecognitionStrategy faceRecognitionStrategy;
    public Context(FaceRecognitionStrategy faceRecognitionStrategy ) {
        this.faceRecognitionStrategy = faceRecognitionStrategy;
    }

    public String faceRecognition(String param) {
        return this.faceRecognitionStrategy.faceRecognition(param);
    }
}
