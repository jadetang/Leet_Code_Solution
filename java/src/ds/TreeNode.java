package ds;

/**
 * @author jade on 2016/11/12 下午8:27
 */
public class TreeNode {

  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int x) {
    val = x;
  }

  @Override
  public String toString(){
    return this.val+"";
  }
}
