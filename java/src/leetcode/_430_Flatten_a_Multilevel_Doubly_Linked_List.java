package leetcode;

import org.junit.Test;

public class _430_Flatten_a_Multilevel_Doubly_Linked_List {

    @Test
    public void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.prev = node1;
        node1.child = node3;
        node3.next = node4;
        node4.prev = node3;
        node2.next = node5;
        node5.prev = node2;
        _430_Flatten_a_Multilevel_Doubly_Linked_List q = new _430_Flatten_a_Multilevel_Doubly_Linked_List();
        Node n = q.flatten(node1);
    }

    public Node flatten(Node head) {
        return connect(head)[0];
    }

    private Node[] connect(Node head) {
        if (head == null) {
            return new Node[2];
        }
        if (head.child != null) {
            Node[] nodes = connect(head.child);
            Node preNext = head.next;
            nodes[0].prev = head;
            head.next = nodes[0];
            head.child = null;
            if (preNext != null) {
                Node[] nodes1 = connect(preNext);
                nodes1[0].prev = nodes[1];
                nodes[1].next = nodes1[0];
                return new Node[] {head, nodes1[1]};
            }
            return new Node[] {head, nodes[1]};
        }else if (head.next != null) {
            Node[] nodes = connect(head.next);
            head.next = nodes[0];
            nodes[0].prev = head;
            return new Node[] {head, nodes[1]};
        }else {
            return new Node[] {head, head};
        }
    }

    public static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }
    };
}


