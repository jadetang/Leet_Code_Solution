package leetcode;

import ds.TreeNode;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jade on 2017/7/9 上午9:59
 */
public class _637_Average_of_Levels_in_Binary_Tree {


  public List<Double> averageOfLevels(TreeNode root) {
    LinkedHashMap<Integer, List<Long>> value = new LinkedHashMap<>();
    dfs(value, root, 0);
    List<Double> d = new LinkedList<>();
    for (List<Long> v : value.values()) {
      long sum = v.stream().reduce((i1, i2) -> i1 + i2).get();
      int size = v.size();
      d.add((sum) / (double) size);
    }
    return d;
  }

  private void dfs(LinkedHashMap<Integer, List<Long>> value, TreeNode root, int i) {
    if (root == null) {
      return;
    } else {
      if (!value.containsKey(i)) {
        value.put(i, new LinkedList<>());
      }
      value.get(i).add((long) root.val);
      dfs(value, root.left, i + 1);
      dfs(value, root.right, i + 1);

    }


  }

}
