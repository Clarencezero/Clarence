package util;

public class AssertUtil {
    public static void assertEquals(int expect, int target) {
        if (expect != target) {
            throw new NullPointerException("expect: " + expect + ", target: " + target);
        }
    }
}
