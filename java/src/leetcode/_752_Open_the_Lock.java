package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import org.junit.Test;
import util.Assert;

public class _752_Open_the_Lock {

    @Test
    public void test() {
        String[] deadends = new String[] {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target = "8888";
        _752_Open_the_Lock q = new _752_Open_the_Lock();
        Assert.assertEqual(-1, q.openLock(deadends, target));
    }
    public int openLock(String[] deadends, String target) {
        String s = "0000";
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> dead = new HashSet<>();
        for (String d : deadends) {
            dead.add(d);
        }
        queue.offer(s);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
             //   System.out.println(current);
                if (visited.contains(current)) {
                    continue;
                }
                visited.add(current);
                char[] chars = current.toCharArray();
                for (int j = 0; j < 4; j++) {
                    char c = chars[j];
                    chars[j] = nextC(c);
                    String next = new String(chars);
                    if (next.equals(target)) {
                        return ans + 1;
                    }
                    if(!dead.contains(next) && !visited.contains(next)) {
                        queue.offer(next);
                    }
                    chars[j] = preC(c);
                    String pre = new String(chars);
                    if (pre.equals(target)) {
                        return ans + 1;
                    }
                    if(!dead.contains(pre) && !visited.contains(pre)) {
                        queue.offer(pre);
                    }
                    chars[j] = c;
                }
            }
            ans++;
        }
        return -1;
    }

    private char nextC(char c) {
        if (c == '9') {
            return '0';
        }else {
            return (char)(c + 1);
        }
    }

    private char preC(char c) {
        if (c == '0') {
            return '9';
        }else {
            return (char)(c - 1);
        }
    }
}
