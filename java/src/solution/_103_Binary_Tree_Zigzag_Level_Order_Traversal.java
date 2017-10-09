package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import ds.TreeNode;

/**
 * @author sanguan.tangsicheng on 2016/12/17 上午10:57
 */
public class _103_Binary_Tree_Zigzag_Level_Order_Traversal {

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    if (root == null) {
      return result;
    }
    boolean leftToRight = true;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    Stack<TreeNode> secondStack = new Stack<TreeNode>();
    List<Integer> tempList = new LinkedList<Integer>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode cur = stack.pop();
      if (cur != null) {
        tempList.add(cur.val);
        if (leftToRight) {
          if (cur.left != null) {
            secondStack.add(cur.left);
          }
          if (cur.right != null) {
            secondStack.add(cur.right);
          }
        } else {
          if (cur.right != null) {
            secondStack.add(cur.right);
          }
          if (cur.left != null) {
            secondStack.add(cur.left);
          }
        }
      }
      if (stack.isEmpty()) {
        System.out.println(secondStack);
        stack = secondStack;
        secondStack = new Stack<TreeNode>();
        leftToRight = !leftToRight;
        result.add(new LinkedList<Integer>(tempList));
        tempList.clear();
      }
    }
    return result;
  }

  public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    Map<Integer, List<Integer>> acc = new HashMap<>();

    dfs(acc, root, 0);

    acc.forEach((key, value) -> {
      if (key % 2 == 1) {
        Collections.reverse(value);

      }
    });
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


  public static void main(String[] args) {
    TreeNode n = new TreeNode(3);
    TreeNode n2 = new TreeNode(5);
    n.right = n2;
    n2.right = new TreeNode(9);
    _103_Binary_Tree_Zigzag_Level_Order_Traversal q = new _103_Binary_Tree_Zigzag_Level_Order_Traversal();
    System.out.println(q.zigzagLevelOrder(n));
  }
}
