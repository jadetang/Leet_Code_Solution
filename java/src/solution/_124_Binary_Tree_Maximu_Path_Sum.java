package solution;

import ds.TreeNode;

/**
 * @author sanguan.tangsicheng on 2017/7/2 下午2:59
 */
public class _124_Binary_Tree_Maximu_Path_Sum {


    private int max = Integer.MIN_VALUE;


    public int maxPathSum(TreeNode root) {


        if (root == null){
            return 0;
        }else {
            maxSum(root);
            return max;
        }
    }

    private int maxSum(TreeNode root) {
        if (root == null){
            return 0;
        }else {
            int left = maxSum(root.left);

            int right = maxSum(root.right);

            max = Math.max(max,root.val+left+right);


            //这个只会取一条边
            int ret = Math.max(left,right)+root.val;

            //这个 ret 是表示经过 这个 root 的 path 最大的和，如果这个和为负数的话，就返回
            //0,告诉上层节点，不要取这个。
            return ret > 0 ? ret : 0;

        }
    }

}
