package leetcode;

import ds.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class _662_Maximum_Width_of_Binary_Tree {

  Map<Integer, int[]> map = new HashMap<>();

  public int widthOfBinaryTree(TreeNode root) {
    dfs(root, 0, 0);
    int max = 0;
    for (int[] dist : map.values()) {
      max = Math.max(max, dist[1] - dist[0] + 1);
    }
    return max;
  }

  private void dfs(TreeNode node, int level, int num) {
    if (node == null) {
      return;
    }
    map.putIfAbsent(level, new int[2]);
    int[] dists = map.get(level);
    dists[0] = Math.min(dists[0], num);
    dists[1] = Math.max(dists[1], num);
    dfs(node.left, level + 1, num * 2 + 1);
    dfs(node.right, level + 1, num * 2 + 2);
  }
}
