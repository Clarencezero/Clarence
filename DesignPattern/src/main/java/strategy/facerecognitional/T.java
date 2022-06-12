package strategy.facerecognitional;

public class T {
    public static void main(String[] args) {
        Context context = new Context(new AFaceRecognitionStrategy());
        String recognitionResult = context.faceRecognition("param");

        Context context1 = new Context(new BFaceRecognitionStrategy());
        String recognitionR2 = context1.faceRecognition("param");
    }
}
