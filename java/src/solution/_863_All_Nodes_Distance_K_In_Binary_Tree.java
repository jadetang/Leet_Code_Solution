package solution;

import ds.TreeNode;
import java.util.LinkedList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
 */
public class _863_All_Nodes_Distance_K_In_Binary_Tree {

  public static void main(String[] args) {
    _863_All_Nodes_Distance_K_In_Binary_Tree q = new _863_All_Nodes_Distance_K_In_Binary_Tree();
/*    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(1);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(2);*/
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(5);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(6);
    root.left.right = new TreeNode(2);
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(4);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(8);
    q.distanceK(root, root.left.right, 2);
  }


  private int distance;

  private TreeNode target;

  private List<Integer> ans;

  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    this.distance = K;
    this.target = target;
    this.ans = new LinkedList<>();
    dfs(root);
    return ans;
  }

  private int dfs(TreeNode node) {
    if (node == null) {
      return -1;
    } else {
      if (node == target) {
        findAllSubNode(target, this.distance);
        return 0;
      } else {
        int l = dfs(node.left);
        if (l != -1){
          if ( l + 1 == this.distance){
            ans.add(node.val);
          }else {
            findAllSubNode(node.right,this.distance - l - 2);
          }
          return l+1;
        }else {
          int r = dfs(node.right);
          if (r != -1){
            if (r +1 == this.distance){
              ans.add(node.val);
            }else {
              findAllSubNode(node.left, this.distance - r - 2);
            }
            return r+1;
          }
        }
        return -1;
      }
    }
  }

  private void findAllSubNode(TreeNode node, int dis) {
    if (node == null || dis < 0 ) {
      return;
    } else if (dis == 0) {
      ans.add(node.val);
    } else {
      findAllSubNode(node.left, dis - 1);
      findAllSubNode(node.right, dis - 1);
    }
  }


}
