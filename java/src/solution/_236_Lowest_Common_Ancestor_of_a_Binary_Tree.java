package solution;

import java.util.LinkedList;
import java.util.Queue;

import ds.TreeNode;

/**
 * @author sanguan.tangsicheng on 2017/6/14 下午7:18
 */
public class _236_Lowest_Common_Ancestor_of_a_Binary_Tree {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> stackP = new LinkedList<>();
        Queue<TreeNode> stackQ = new LinkedList<>();
        traverse(root,p,stackP);
        traverse(root,q,stackQ);
        Queue<TreeNode> highStack = null;
        Queue<TreeNode> lowStack = null;
        if( stackP.size() > stackQ.size()){
            highStack = stackP;
            lowStack = stackQ;
        }else{
            highStack = stackQ;
            lowStack = stackP;
        }
        while(highStack.size() > lowStack.size() ){
            highStack.poll();
        }
        while(highStack.peek().val != lowStack.peek().val){
            highStack.poll();
            lowStack.poll();
        }
        return highStack.peek();


    }

    private boolean traverse(TreeNode node , TreeNode target, Queue<TreeNode> stack){
        if(node == null ){
            return false;
        }
        if(node.val == target.val){
            stack.offer(target);
            return true;
        }
        if( traverse(node.left,target,stack) || traverse(node.right,target,stack)){
            stack.offer(node);
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        _236_Lowest_Common_Ancestor_of_a_Binary_Tree q = new _236_Lowest_Common_Ancestor_of_a_Binary_Tree();
        q.lowestCommonAncestor(root,root,root.left);
    }


}
