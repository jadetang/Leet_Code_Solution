package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;
import util.Assert;

public class _38_Count_And_Say {

    @Test
    public void test( ) {
        _38_Count_And_Say q = new _38_Count_And_Say();
        Assert.assertEqual("111221", q.countAndSay(5));
    }
    public String countAndSay(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        Queue<Integer> buffer = new LinkedList<>();
        for (int i = 2; i <= n; i++) {
            while (!queue.isEmpty()) {
                int count = 1;
                int number = queue.poll();
                while (!queue.isEmpty() && number == queue.peek()) {
                    count++;
                    queue.poll();
                }
                buffer.offer(count);
                buffer.offer(number);
            }
            queue.addAll(buffer);
            buffer.clear();
        }
        StringBuilder sb = new StringBuilder();
        for (int i : queue) {
            sb.append(i);
        }
        return sb.toString();
    }
}
