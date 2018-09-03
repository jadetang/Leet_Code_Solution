package solution;

import java.util.LinkedList;
import java.util.List;

import ds.TreeNode;

/**
 * @author jade on 2017/7/2 上午10:28
 */
public class _94_Binary_Tree_Inorder_Traversal {

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new LinkedList<>();
    driver(root, result);
    return result;
  }

  private void driver(TreeNode node, List<Integer> acc) {
    if (node != null) {
      driver(node.left, acc);
      acc.add(node.val);
      driver(node.right, acc);
    }
  }
}
