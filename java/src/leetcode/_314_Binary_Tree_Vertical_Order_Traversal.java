package leetcode;

import ds.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class _314_Binary_Tree_Vertical_Order_Traversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        TreeMap<Integer, List<Integer>> ans = new TreeMap<>();
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            ans.computeIfAbsent(current.distance, k -> new ArrayList<>()).add(current.node.val);
            if (current.node.left != null) {
                queue.offer(new Pair(current.node.left, current.distance - 1));
            }
            if (current.node.right != null) {
                queue.offer(new Pair(current.node.right, current.distance + 1));
            }
        }
        return new ArrayList<>(ans.values());
    }

    public static class Pair {
        TreeNode node;
        int distance;

        public Pair(TreeNode node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
