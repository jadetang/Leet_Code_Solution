package leetcode;

import ds.TreeNode;

/**
 * @author jade on 2017/7/6 下午8:48
 */
public class _297_Serialize_and_Deserialize_Binary_Tree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        serialize(stringBuilder, root);
        return stringBuilder.toString();
    }

    private void serialize(StringBuilder stringBuilder, TreeNode node) {
        if (node == null) {
            stringBuilder.append("null,");
        }else {
            stringBuilder.append(node.val+",");
            serialize(stringBuilder, node.left);
            serialize(stringBuilder, node.right);
        }
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] index = new int[]{0};
        return deserialize(data.split(","), index);
    }

    private TreeNode deserialize(String[] data, int[] index) {
        int i = index[0];
        if (i >= data.length) {
            return null;
        }
        String val = data[index[0]++];
        if (val.equals("null")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserialize(data, index);
        node.right = deserialize(data, index);
        return node;
    }

}
