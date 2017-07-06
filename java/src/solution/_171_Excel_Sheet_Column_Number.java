package solution;

/**
 * @author sanguan.tangsicheng on 2017/7/2 下午11:09
 */
public class _171_Excel_Sheet_Column_Number {

    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        return toInt(chars);
    }

    private int toInt(char[] chars) {
        int radix = 26;
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            result = result * radix + mapCharToInt(chars[i]);
        }
        return result;
    }

    private int mapCharToInt(char aChar) {
        return aChar - 'A' + 1;
    }
}
