package ds;

public class SegmentTree {

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 4, 5};
        SegmentTree segmentTree = new SegmentTree(array);
        System.out.println(segmentTree.query(0, 0));
        System.out.println(segmentTree.query(0, 1));
        System.out.println(segmentTree.query(0, 2));
        System.out.println(segmentTree.query(0, 3));
        System.out.println(segmentTree.query(0, 4));
        segmentTree.update(0, 10);
        System.out.println(segmentTree.query(0, 0));
        System.out.println(segmentTree.query(0, 1));
        System.out.println(segmentTree.query(0, 2));
        System.out.println(segmentTree.query(0, 3));
        System.out.println(segmentTree.query(0, 4));
    }

    SegmentTreeNode root;

    public SegmentTree(int[] vals) {
        root = build(0, vals.length - 1, vals);
    }

    private SegmentTreeNode build(int start, int end, int[] vals) {
        if (start == end) {
            return new SegmentTreeNode(start, end, vals[start]);
        }else {
            int mid = start + (end - start) / 2;
            SegmentTreeNode left = build(start, mid, vals);
            SegmentTreeNode right = build(mid + 1, end, vals);
            return new SegmentTreeNode(start, end, left.sum + right.sum, left, right);
        }
    }

    public void update(int index, int newValue) {
        update(root, index, newValue);
    }

    private void update(SegmentTreeNode node, int index, int newValue) {
        if (node.start == node.end && node.start == index) {
            node.sum = newValue;
            return;
        }
        int mid = node.start + (node.end - node.start) / 2;
        if (index <= mid) {
            update(node.left, index, newValue);
        }else {
            update(node.right, index, newValue);
        }
        node.sum = node.left.sum + node.right.sum;
    }

    public int query(int start, int end) {
        return query(root, start, end);
    }

    private int query(SegmentTreeNode node, int start, int end) {
        if (node.start == start && node.end == end) {
            return node.sum;
        }else {
            int mid = node.start + (node.end - node.start) / 2;
            if (end <= mid) {
                return query(node.left, start, end);
            }else if (start >= mid + 1) {
                return query(node.right, start, end);
            }else {
                return query(node.left, start, mid) + query(node.right, mid + 1, end);
            }
        }
    }


    public static class SegmentTreeNode {

        public SegmentTreeNode(int start, int end, int val) {
            this.start = start;
            this.end = end;
            this.sum = val;
        }

        public SegmentTreeNode(int start, int end, int sum, SegmentTreeNode left, SegmentTreeNode right) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            this.left = left;
            this.right = right;
        }

        int sum;
        int start;
        int end;
        SegmentTreeNode left;
        SegmentTreeNode right;
    }

}
