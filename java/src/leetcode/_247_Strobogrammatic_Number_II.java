package leetcode;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;
import org.junit.Test;

public class _247_Strobogrammatic_Number_II {

    @Test
    public void test() {
        _247_Strobogrammatic_Number_II q = new _247_Strobogrammatic_Number_II();
        List<String> list = q.findStrobogrammatic2(4);
        System.out.println(list);
    }

    @Test
    public void test2() {
        _247_Strobogrammatic_Number_II q = new _247_Strobogrammatic_Number_II();
        List<String> list = q.findStrobogrammatic2(3);
        System.out.println(list);
    }

    Map<Character, Character> map = new HashMap<>(){{
        put('1', '1');
        put('6', '9');
        put('9', '6');
        put('8', '8');
        put('0', '0');
    }};

    char[] chars = new char[] {'1', '6', '8', '9', '0'};

    List<String> ans = new ArrayList<>();

    public List<String> findStrobogrammatic2(int n) {
        if (n == 0 ) {
            return ans;
        }
        if (n == 1) {
            ans.add("1");
            ans.add("0");
            ans.add("8");
            return ans;
        }
        char[] buffer = new char[n];
        Queue<char[]> queue = new LinkedList<>();
        queue.offer(buffer);
        for (int i = 0; i < n / 2; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                char[] current = queue.poll();
                for (int k = 0; k < chars.length; k++) {
                    if (i == 0 && chars[k] == '0') {
                        continue;
                    }else {
                        char[] newChars = Arrays.copyOf(current, current.length);
                        newChars[i] = chars[k];
                        newChars[newChars.length - 1 - i] = map.get(chars[k]);
                        queue.offer(newChars);
                    }

                }
            }
        }
        if (n % 2 == 1) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char[] chars = queue.poll();
                for (char c : new char[] {'1', '0', '8'}) {
                    char[] newChars = Arrays.copyOf(chars, chars.length);
                    newChars[ n / 2] = c;
                    queue.offer(newChars);
                }
            }
        }
        return queue.stream().map(String::new).collect(Collectors.toList());
    }

    public List<String> findStrobogrammatic(int n) {
        dfs("", n);
        return ans;
    }

    private void dfs(String s, int n) {
        if (s.length() == n ){
            if (isValid(s)) {
                ans.add(s);
            }
        }else {
            for (int i = 0; i < chars.length; i++) {
                if (s.length() == 0 && chars[i] == '0') {
                    continue;
                }
                dfs(s + chars[i], n);
            }
        }
    }

    private boolean isValid(String s){
        if (s.length() == 0) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(map.get(c));
        }
        return sb.reverse().toString().equals(s);
    }
}
