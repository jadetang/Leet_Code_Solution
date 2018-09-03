package other;


import ds.TreeNode;
import util.Util;

/**
 * https://www.geeksforgeeks.org/convert-a-given-binary-tree-to-doubly-linked-list-set-2/
 */
public class ConvertAGivenBinaryTreeToDoublyLinkedList {

  static TreeNode pre;

  static TreeNode head;

  public static TreeNode convert(TreeNode root){

    convertHelp(root);

    return head;
  }

  private static void convertHelp(TreeNode root) {
    if (root == null){
      return;
    }else {
      convertHelp(root.left);
      if (pre == null){
        head = root;
      }else {
        pre.right = root;
        root.left = pre;
      }
      pre = root;
      convertHelp(root.right);
    }
  }


  public static void main(String[] args) {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(12);
    root.right = new TreeNode(15);
    root.left.left = new TreeNode(25);
    root.left.right = new TreeNode(30);
    root.right.left = new TreeNode(36);
    TreeNode treeNode = convert(root);
    Util.print(treeNode);
  }




}
