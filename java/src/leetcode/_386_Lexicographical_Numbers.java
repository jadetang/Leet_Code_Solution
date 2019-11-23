package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import level.Medium;

/**
 * @author jade on 2016/11/30 下午9:01
 */
public class _386_Lexicographical_Numbers implements Medium {

  public static void main(String[] args) {
    _386_Lexicographical_Numbers q = new _386_Lexicographical_Numbers();
    System.out.println(q.lexicalOrder(13));
  }

  public List<Integer> lexicalOrder(int n) {
    PriorityQueue<String> queue = new PriorityQueue<>(n, String::compareTo);
    for (int i = 1; i <= n; i++) {
      queue.add(String.valueOf(i));
    }
    List<Integer> list = new LinkedList<>();
    while (!queue.isEmpty()) {
      list.add(Integer.valueOf(queue.poll()));
    }
    return list;
  }
}
