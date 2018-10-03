package lintCode;

import ds.TreeNode;

public class _1561_BST_Node_Distance {


  /**
   * @param numbers: the given list
   * @param node1: the given node1
   * @param node2: the given node2
   * @return: the distance between two nodes
   */
  public int bstDistance(int[] numbers, int node1, int node2) {
    // Write your code here
    boolean flag1 = false;
    boolean flag2 = false;
    TreeNode root = new TreeNode(numbers[0]);
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] == node1) {
        flag1 = true;
      }
      if (numbers[i] == node2) {
        flag2 = true;
      }
      buildBst(root, numbers[i]);
    }
    if (!flag1 || !flag2) {
      return -1;
    }
    TreeNode lca = findLCA(root, node1, node2);
    return dis(lca, node1) + dis(lca, node2);

  }

  private int dis(TreeNode root, int node) {
    if (root.val == node) {
      return 0;
    } else if (node < root.val) {
      return dis(root.left, node) + 1;
    } else {
      return dis(root.right, node) + 1;
    }
  }


  private TreeNode findLCA(TreeNode root, int node1, int node2) {
    if (node1 < root.val && node2 < root.val) {
      return findLCA(root.left, node1, node2);
    }
    if (node1 > root.val && node2 > root.val) {
      return findLCA(root.right, node1, node2);
    }
    return root;
  }


  private void buildBst(TreeNode node, int value) {
    if (node.val < value) {
      if (node.right == null) {
        node.right = new TreeNode(value);
      } else {
        buildBst(node.right, value);
      }
    }
    if (node.val > value) {
      if (node.left == null) {
        node.left = new TreeNode(value);
      } else {
        buildBst(node.left, value);
      }
    }
  }

}
