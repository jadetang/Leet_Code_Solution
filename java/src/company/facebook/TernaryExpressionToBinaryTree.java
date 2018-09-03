package company.facebook;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * In the given code, the right child which is created is appended to the current root. But it
 * should be appended as the right child of the parent of the current root (if it is null) otherwise
 * append to the parent of its parent and so on. So the inorder and postorder traversal of the
 * formed tree is different from that of the correctly formed tree. For E.g here, d is appended as
 * the right child of c and e is the right child of d, which is incorrect. Instead d should be right
 * child of b and e should be right child of a.
 *
 * Solution Repeat until the length of the expression:
 *
 * if(expression[i]== "?") push the root in the stack(here: a,b,c)
 *
 * if(expression[i]==":") pop the node(here :pop c) again pop the node and let the newly formed root
 * be the right child of this node. (pop b and then d = b.right) push the right child (here : d)
 *
 * @author jade on 2017/6/15 下午7:44
 */
public class TernaryExpressionToBinaryTree {


  public static TreeNode convert(String expression) {
    return convertHelp(expression.toCharArray());

  }

  //a?b?c:d:e

  private static TreeNode convertHelp(char[] expression) {

    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode root = new TreeNode(expression[0]);
    stack.add(root);

    for (int i = 1; i < expression.length; i++) {
      if (expression[i] == '?') {
        TreeNode treeNode = stack.peek();
        treeNode.left = new TreeNode(expression[i + 1]);
        stack.push(treeNode.left);
      } else if (expression[i] == ':') {
        stack.pop();
        TreeNode treeNode = stack.pop();
        treeNode.right = new TreeNode(expression[i + 1]);
        stack.push(treeNode.right);
      }
    }
    return root;

  }

  public static void main(String[] args) {
    String abc = "a?b?c:d:e";
    TreeNode t = convert(abc);
    System.out.println(t);
  }


  public static class TreeNode {

    char val;

    TreeNode left;

    TreeNode right;


    public TreeNode(char c) {
      this.val = c;
    }

    @Override
    public String toString() {
      return val + "";
    }

  }

}
