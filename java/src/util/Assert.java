package util;

/**
 * @author sanguan.tangsicheng on 2017/7/9 上午8:18
 */
public class Assert {

    public static void assertEqual(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError(String.format("expect : %d, actual: %d", expected, actual));
        }
    }


    public static void assertEqual(String expected, String actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError(String.format("expect : %s, actual: %s", expected, actual));
        }
    }

    public static void assertTrue(boolean state){
        if (!state){
            throw  new AssertionError("not true.");
        }
    }

    public static void assertFalse(boolean state) {
        if (state){
            throw  new AssertionError("not false.");
        }
    }
}
