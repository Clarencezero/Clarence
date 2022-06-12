package strategy.facerecognitional;

public class AFaceRecognitionStrategy implements FaceRecognitionStrategy{
    @Override
    public String faceRecognition(String param) {
        System.out.println("工厂A: 基于几何特征算法");
        return "工厂A: 基于几何特征算法";
    }
}
