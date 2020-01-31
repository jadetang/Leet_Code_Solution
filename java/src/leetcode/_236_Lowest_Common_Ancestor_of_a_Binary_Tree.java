package leetcode;

import ds.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jade on 2017/6/14 下午7:18
 */
public class _236_Lowest_Common_Ancestor_of_a_Binary_Tree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    _236_Lowest_Common_Ancestor_of_a_Binary_Tree q = new _236_Lowest_Common_Ancestor_of_a_Binary_Tree();
    q.lowestCommonAncestor(root, root, root.left);
  }

  //遍历，记录从跟节点到目标节点的路径，然后从底往上比较。
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    Queue<TreeNode> stackP = new LinkedList<>();
    Queue<TreeNode> stackQ = new LinkedList<>();
    traverse(root, p, stackP);
    traverse(root, q, stackQ);
    Queue<TreeNode> highStack = null;
    Queue<TreeNode> lowStack = null;
    if (stackP.size() > stackQ.size()) {
      highStack = stackP;
      lowStack = stackQ;
    } else {
      highStack = stackQ;
      lowStack = stackP;
    }
    while (highStack.size() > lowStack.size()) {
      highStack.poll();
    }
    while (highStack.peek().val != lowStack.peek().val) {
      highStack.poll();
      lowStack.poll();
    }
    return highStack.peek();

  }

  private boolean traverse(TreeNode node, TreeNode target, Queue<TreeNode> stack) {
    if (node == null) {
      return false;
    }
    if (node.val == target.val) {
      stack.offer(target);
      return true;
    }
    if (traverse(node.left, target, stack) || traverse(node.right, target, stack)) {
      stack.offer(node);
      return true;
    } else {
      return false;
    }
  }

  /**
   * The idea is to traverse the tree starting from root. If any of the given keys (n1 and n2)
   * matches with root, then root is LCA (assuming that both keys are present). If root doesn’t
   * match with any of the keys, we recur for left and right subtree. The node which has one key
   * present in its left subtree and the other key present in right subtree is the LCA. If both keys
   * lie in left subtree, then left subtree has LCA also, otherwise LCA lies in right subtree.
   */
  public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) {
      return root;
    } else {
      TreeNode left = lowestCommonAncestor2(root.left, p, q);
      TreeNode right = lowestCommonAncestor2(root.right, p, q);
      if (left != null && right != null) {
        return root;
      } else {
        return left != null ? left : right;
      }
    }

  }

}
