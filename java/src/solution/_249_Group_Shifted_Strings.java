package solution;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 * <p>
 * "abc" -> "bcd" -> ... -> "xyz"
 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
 * <p>
 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 * A solution is:
 * <p>
 * [
 * ["abc","bcd","xyz"],
 * ["az","ba"],
 * ["acef"],
 * ["a","z"]
 * ]
 *
 * @author sanguan.tangsicheng on 2017/7/31 上午9:58
 */
public class _249_Group_Shifted_Strings {


    public List<List<String>> groupStrings(String[] strings) {
        if (strings == null || strings.length == 0) {
            return Collections.EMPTY_LIST;
        } else {
            List<String> stringList = Arrays.asList(strings);
            Collection<List<String>> group = stringList.stream().collect(Collectors.groupingBy(s -> signature(s))).values();
            return new LinkedList<>(group);
        }
    }

    private String signature(String s) {
        int[] array = new int[s.length()];
        array[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            array[i] = s.charAt(i) - s.charAt(i - 1);
            array[i] = array[i] < 0 ? array[i] + 26 : array[i];
        }
        StringBuilder sb = new StringBuilder();
        for (int i : array) {
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _249_Group_Shifted_Strings q = new _249_Group_Shifted_Strings();
        String[] str = new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        System.out.println(q.groupStrings(str));
    }


}
