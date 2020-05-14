package leetcode;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class _271_Encode_and_Decode_Strings {

    @Test
    public void test() {
        _271_Encode_and_Decode_Strings q = new _271_Encode_and_Decode_Strings();
        List<String> s = List.of("aabbbbbbbbbb", "bb", "cc");
        Assert.assertEquals(s, q.decode(q.encode(s)));
    }

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(encode(s));
        }
        return sb.toString();
    }

    private char[] encode(String sb) {
        char[] chars = new char[sb.length() + 4];
        int length = sb.length();
        for (int i = 3; i >= 0; i--) {
            chars[i] = (char) ((length >> (8 * (i - 3))) & 0xff);
        }
        for (int i = 4; i < chars.length; i++) {
            chars[i] = sb.charAt(i - 4);
        }
        return chars;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if (s.length() == 0) {
            return new ArrayList<>();
        }
        List<String> strings = new ArrayList<>();
        int i = 0;
        char[] data = s.toCharArray();
        while (i < s.length()) {
            int length = dataLength(i, data);
            i += 4;
            strings.add(s.substring(i, i + length));
            i += length;
        }
        return strings;
    }

    private int dataLength(int i, char[] data) {
        int length = 0;
        for (int j = 3 + i; j >= i; j--) {
            length += (int) data[j] << (8 * (i + 3 - j));
        }
        return length;
    }

}
