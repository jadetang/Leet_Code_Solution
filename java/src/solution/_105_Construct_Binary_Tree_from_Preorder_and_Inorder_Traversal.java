package solution;

import ds.TreeNode;

/**
 * @author sanguan.tangsicheng on 2017/6/3 上午9:06
 */
public class _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

    int[] preorder;

    int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        } else {
            this.preorder = preorder;
            this.inorder = inorder;
            return build(0, preorder.length - 1, 0, inorder.length - 1);
        }
    }

    private TreeNode build(int preorderStart, int preorderEnd, int inorderStart, int inorderEnd) {
        if (preorderStart == preorderEnd && inorderStart == inorderEnd) {
            assert preorder[preorderStart] == inorder[inorderStart];
            return new TreeNode(preorder[preorderStart]);
        } else {
            int rootVal = preorder[preorderStart];
            TreeNode cur = new TreeNode(rootVal);
            int nodeInorderIndex = findIndex(this.inorder, rootVal);
            if (nodeInorderIndex == inorderStart) {
                cur.left = null;
                cur.right = build(preorderStart + 1, preorderEnd, nodeInorderIndex+1, inorderEnd);
                return cur;

            } else if (nodeInorderIndex == inorderEnd) {

                cur.left = build(preorderStart + 1, preorderEnd, inorderStart, nodeInorderIndex-1);

                cur.right = null;

                return cur;
            } else {

                int lefMost = inorder[nodeInorderIndex + 1];

                int preOrderLeftMostIndex = findIndex(preorder, lefMost);

                cur.left = build(preorderStart + 1, preOrderLeftMostIndex - 1, inorderStart, nodeInorderIndex - 1);

                cur.right = build(preOrderLeftMostIndex , preorderEnd, nodeInorderIndex + 1, inorderEnd);

                return cur;
            }

        }

    }

    private int findIndex(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal q
            = new _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal();
        int[] preOrder = new int[] {3, 2, 1,4};
        int[] inOrder = new int[] {1, 2, 3,4};
        System.out.println(q.buildTree(preOrder, inOrder));
    }

}
