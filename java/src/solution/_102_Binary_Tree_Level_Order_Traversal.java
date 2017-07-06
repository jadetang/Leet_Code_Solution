package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import ds.TreeNode;

/**
 * @author sanguan.tangsicheng on 2016/11/12 下午8:26
 */
public class _102_Binary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> secondQueue = new LinkedList<>();
        List<Integer> tempList = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            tempList.add(node.val);
            if (node.left != null) { secondQueue.offer(node.left); }
            if (node.right != null) { secondQueue.offer(node.right); }
            if (queue.isEmpty()) {
                result.add(tempList);
                tempList = new LinkedList<>();
                queue = secondQueue;
                secondQueue = new LinkedList<>();
            }
        }
        return result;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Map<Integer, List<Integer>> acc = new HashMap<>();

        dfs(acc, root, 0);
        return new ArrayList<>(acc.values());
    }

    private void dfs(Map<Integer, List<Integer>> acc, TreeNode root, int level) {
        if (root == null) {
            return;
        } else {
            if (!acc.containsKey(level)) {
                acc.put(level, new LinkedList<>());
            }
            acc.get(level).add(root.val);
            dfs(acc, root.left, level + 1);
            dfs(acc, root.right, level + 1);

        }
    }

}
