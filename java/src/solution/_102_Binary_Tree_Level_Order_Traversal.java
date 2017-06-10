package solution;

import ds.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sanguan.tangsicheng on 2016/11/12 下午8:26
 */
public class _102_Binary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null ){
            return Collections.emptyList();
        }
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> secondQueue = new LinkedList<>();
        List<Integer> tempList = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            tempList.add(node.val);
            if(node.left != null) secondQueue.offer( node.left);
            if(node.right != null) secondQueue.offer(node.right);
            if(queue.isEmpty()){
                result.add(tempList);
                tempList = new LinkedList<>();
                queue = secondQueue;
                secondQueue = new LinkedList<>();
            }
        }
        return result;
    }
}
