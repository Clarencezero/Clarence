package adaptor.targetadaptor;

public class T {
    public static void main(String[] args) {
        Logger logger = new LogAdaptor();
        logger.info("hello");

        String str1 = "3444";
        String[] split = str1.split(",");

        for (String s : split) {
            System.out.println(s);
        }
    }
}
