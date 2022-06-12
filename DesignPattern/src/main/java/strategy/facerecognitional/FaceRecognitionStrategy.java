package strategy.facerecognitional;

/**
 * 人脸识别算法策略
 * 各个厂商需要按规划实现该接口
 */
public interface FaceRecognitionStrategy {
    /**
     * 人脸识别算法接口
     * @param param
     * @return
     */
    String faceRecognition(String param);
}
