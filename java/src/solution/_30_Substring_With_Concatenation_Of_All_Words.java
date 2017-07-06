package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author sanguan.tangsicheng on 16/9/22 下午8:36
 */
public class _30_Substring_With_Concatenation_Of_All_Words {


    //建立一个字典，每次匹配了一个，就减去字典的一个计数，如果字典被兼程
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> dict = new HashMap<>();
        int length = words[0].length();
        List<Integer> result = new LinkedList<>();
        for (String w : words) dict.put(w, dict.containsKey(w) ? dict.get(w) + 1 : 1);


        for (int i = 0; i <= s.length() -length*words.length; i++) {
            Map<String, Integer> temp = new HashMap<>(dict);
            for (int j = i; j <= s.length()-length; j += length) {
                System.out.println("method 1");
                String tempStr = s.substring(j, j + length);
                if (!temp.containsKey(tempStr)) {
                    break;
                } else {
                    if (temp.get(tempStr) == 1) {
                        temp.remove(tempStr);
                        if (temp.isEmpty()) {
                            result.add(i);
                            break;
                        }
                    } else {
                        temp.put(tempStr, temp.get(tempStr) - 1);
                    }
                }
            }
        }
        return result;

    }


    public static List<Integer> findSubstring2(String S, String[] L) {
        List<Integer> res = new ArrayList<Integer>();
        if (S == null || L == null || L.length == 0) return res;
        int len = L[0].length(); // length of each word

        Map<String, Integer> map = new HashMap<String, Integer>(); // map for L
        for (String w : L) map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);

        for (int i = 0; i <= S.length() - len * L.length; i++) {
            Map<String, Integer> copy = new HashMap<String, Integer>(map);
            for (int j = 0; j < L.length; j++) { // checkc if match
                System.out.println("method 2");
                String str = S.substring(i + j*len, i + j*len + len); // next word
                if (copy.containsKey(str)) { // is in remaining words
                    int count = copy.get(str);
                    if (count == 1) copy.remove(str);
                    else copy.put(str, count - 1);
                    if (copy.isEmpty()) { // matches
                        res.add(i);
                        break;
                    }
                } else break; // not in L
            }
        }
        return res;
    }

    public static void main(String[] args) {

        _30_Substring_With_Concatenation_Of_All_Words q = new _30_Substring_With_Concatenation_Of_All_Words();
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[] {"word","good","best","good"};
        System.out.println(q.findSubstring(s, words));
        System.out.println(q.findSubstring2(s, words));
        // System.out.println(q.findSubstring2(s, words));
    }
}
