package solution;

import ds.TreeNode;

/**
 * @author sanguan.tangsicheng on 2017/7/29 上午10:24
 */
public class _222_Count_Complete_Tree_Nodes {


    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            TreeNode left = root, right = root;
            int height = 0;
            while (right != null) {
                left = left.left;
                right = right.right;
                height++;
            }
            if (left == null) {    //如果 left 等于 null 表示一个 perfect bst
                return (1 << height) - 1;
            } else {
                return 1 + countNodes(root.left) + countNodes(root.right);
            }
        }
    }
}
