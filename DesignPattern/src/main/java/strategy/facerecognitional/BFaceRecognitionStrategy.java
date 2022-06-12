package strategy.facerecognitional;

public class BFaceRecognitionStrategy implements FaceRecognitionStrategy{
    @Override
    public String faceRecognition(String param) {
        System.out.println("工厂B: 基于深度学习");
        return "工厂B: 基于深度学习";
    }
}
