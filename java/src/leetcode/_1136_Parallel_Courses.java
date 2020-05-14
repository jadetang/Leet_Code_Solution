package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.junit.Test;
import util.Assert;

public class _1136_Parallel_Courses {

  @Test
  public void test() {
    _1136_Parallel_Courses q = new _1136_Parallel_Courses();
    int n = 3;
    int[][] relations = new int[][]{{1, 3}, {2, 3}};
    Assert.assertEqual(2, q.minimumSemesters(3, relations));
  }

  public int minimumSemesters(int n, int[][] relations) {
    int[] inboudDegree = new int[n + 1];
    Map<Integer, List<Integer>> course = new HashMap<>();
    for (int i = 0; i < relations.length; i++) {
      int preCourse = relations[i][0];
      int afterCourse = relations[i][1];
      inboudDegree[afterCourse]++;
      course.computeIfAbsent(preCourse, k -> new ArrayList<>()).add(afterCourse);
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      if (inboudDegree[i] == 0) {
        queue.add(i);
      }
    }
    int ans = 0;
    int studiedCourse = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int currentCourse = queue.poll();
        studiedCourse++;
        for (int nextCourse : course.getOrDefault(currentCourse, Collections.emptyList())) {
          inboudDegree[nextCourse]--;
          if (inboudDegree[nextCourse] == 0) {
            queue.offer(nextCourse);
          }
        }
      }
      ans++;
    }
    return studiedCourse == n ? ans : -1;
  }

}
