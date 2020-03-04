package leetcode;

import org.junit.Test;

public class _426_Convert_Binary_Search_Tree_to_Sorted_Doubly_Linked_List {

    @Test
    public void test() {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        _426_Convert_Binary_Search_Tree_to_Sorted_Doubly_Linked_List q = new _426_Convert_Binary_Search_Tree_to_Sorted_Doubly_Linked_List();
        Node head = q.treeToDoublyList(root);
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node[] nodes = connect(root);
        nodes[0].left = nodes[1];
        nodes[1].right = nodes[0];
        return nodes[0];
    }

    private Node[] connect(Node node) {
        Node[] nodes = new Node[] {node, node};
        if (node.left != null) {
            Node[] leftNodes = connect(node.left);
            leftNodes[1].right = node;
            node.left = leftNodes[1];
            nodes[0] = leftNodes[0];
        }
        if (node.right != null) {
            Node[] rightNodes = connect(node.right);
            node.right = rightNodes[0];
            rightNodes[0].left = node;
            nodes[1] = rightNodes[1];
        }
        return nodes;
    }

    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
