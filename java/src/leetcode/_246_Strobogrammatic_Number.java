package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _246_Strobogrammatic_Number {

    public boolean isStrobogrammatic(String num) {
        if (num.length() == 0) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('1', '1');
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        map.put('0', '0');
        StringBuilder sb = new StringBuilder();
        for (char c : num.toCharArray()) {
            Character nc = map.get(c);
            if (nc == null) {
                return false;
            }
            sb.append(map.get(c));
        }
        return sb.reverse().toString().equals(num);
    }

}
