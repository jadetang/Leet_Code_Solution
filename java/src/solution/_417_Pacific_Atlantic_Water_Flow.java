package solution;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author sanguan.tangsicheng on 2016/10/13 上午10:39
 */
public class _417_Pacific_Atlantic_Water_Flow {


    public List<int[]> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return Collections.emptyList();
        }
        List<int[]> result = new LinkedList<>();
        List<Node> pacific = new LinkedList<>();
        List<Node> atlantic = new LinkedList<>();
        Set<Node> reachPacific = new ConcurrentSkipListSet<>();
        Set<Node> reachAtlatic = new ConcurrentSkipListSet();
        for (int i = 0; i < matrix.length; i++) {
            pacific.add(new Node(i, 0, matrix));
        }
        for (int i = 1; i < matrix[0].length; i++) {
            pacific.add(new Node(0, i, matrix));
        }
        for (int i = 0; i < matrix.length - 1; i++) {
            atlantic.add(new Node(i, matrix[0].length -1 , matrix));
        }
        for (int i = 0; i < matrix[0].length; i++) {
            atlantic.add(new Node(matrix.length - 1, i, matrix));
        }
        pacific.parallelStream().forEach(node -> {
            TravelNode n = new TravelNode(node, matrix, reachPacific);
            n.startDfs();
        });
        atlantic.parallelStream().forEach(node -> {
            TravelNode n = new TravelNode(node, matrix, reachAtlatic);
            n.startDfs();
        });

        reachPacific.retainAll(reachAtlatic);

        for (Node n : reachPacific) {
            result.add(new int[]{n.x, n.y});
        }
        return result;
    }


    public static class TravelNode  {

        int[][] matrix;

        Set<Node> reachAbleNodes;

        public Node beginNode;


        public TravelNode(Node n, int[][] matrix, Set<Node> reachAbleNodes) {
            this.matrix = matrix;
            this.reachAbleNodes = reachAbleNodes;
            this.beginNode = n;
        }


        public void startDfs() {
            dfs(this.beginNode);
        }


        private void dfs(Node n) {
            if (reachAbleNodes.contains(n)) {
                reachAbleNodes.add(n);
                for (Node adj : n.flowTo()) {
                    dfs(adj);
                }
            }

        }


    }


    public static class Node implements Comparable<Node> {

        int x;
        int y;
        int[][] matrix;

        public Node(int x, int y, int[][] matrix) {
            this.x = x;
            this.y = y;
            this.matrix = matrix;
        }

        public int value() {
            return matrix[x][y];
        }

        public List<Node> flowTo() {
            List<Node> result = new LinkedList<>();
            for (int i = -1; i < 2; i += 2) {
                try {
                    Node n = new Node(x + i, y, matrix);
                    if (n.value() >= this.value()) {
                        result.add(n);
                    }
                } catch (IndexOutOfBoundsException ignore) {
                    continue;
                }
            }
            for (int i = -1; i < 2; i += 2) {
                try {
                    Node n = new Node(x, y + i, matrix);
                    if (n.value() >= this.value()) {
                        result.add(n);
                    }
                } catch (IndexOutOfBoundsException ignore) {
                    continue;
                }
            }
            return result;
        }

        @Override
        public boolean equals(Object that) {
            if (that instanceof Node) {
                Node right = (Node) that;
                return this.x == right.x && this.y == right.y;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = result * 31 + this.x;
            result = result * 31 + this.y;
            return result;
        }

        @Override
        public String toString() {
            return "[" + this.x + "," + this.y + "|" + matrix[this.x][this.y] + "]";
        }


        @Override
        public int compareTo(Node o) {
            if (this.x > o.x){
                return  1;
            }else if (this.x < o.x){
                return -1;
            }else {
                if (this.y > o.y){
                    return 1;
                }else if (this.y < o.y){
                    return -1;
                }else {
                    return 0;
                }
            }

        }
    }

    public static void main(String[] args) {
        int[][] martix = new int[][]{{2, 15, 13, 12, 12, 11, 9, 7, 0, 10, 0, 7, 11, 14, 17, 14, 7, 7, 0, 13, 10, 16, 16, 5, 9, 17, 12, 17, 15, 8, 6, 10, 4, 17, 2, 18, 18, 17, 19, 1, 19, 2, 17, 2, 9, 5, 11, 5, 16, 5, 11, 3, 14, 12, 13, 7, 9, 9, 1, 17, 1, 12, 14, 1}, {8, 4, 16, 5, 4, 11, 0, 12, 17, 19, 3, 19, 0, 0, 17, 18, 16, 1, 17, 12, 0, 1, 11, 9, 9, 3, 9, 12, 14, 12, 10, 17, 6, 14, 5, 13, 11, 5, 3, 17, 9, 16, 18, 6, 9, 13, 14, 6, 12, 18, 4, 0, 16, 13, 9, 14, 11, 1, 8, 0, 7, 11, 17, 6}, {2, 11, 19, 6, 6, 3, 17, 12, 13, 18, 10, 15, 7, 3, 11, 12, 5, 9, 1, 15, 7, 3, 16, 3, 9, 17, 14, 19, 4, 6, 1, 19, 7, 9, 13, 0, 17, 2, 14, 11, 11, 17, 7, 6, 7, 3, 19, 17, 9, 10, 5, 18, 4, 16, 15, 15, 0, 12, 15, 19, 11, 3, 19, 8}, {3, 10, 3, 4, 9, 17, 13, 1, 12, 1, 5, 3, 12, 15, 7, 9, 17, 17, 19, 11, 19, 18, 3, 14, 8, 6, 8, 3, 11, 16, 10, 3, 4, 15, 14, 12, 9, 0, 11, 8, 4, 6, 17, 18, 2, 17, 7, 15, 17, 9, 15, 15, 5, 11, 8, 18, 14, 6, 11, 14, 9, 12, 16, 13}, {16, 0, 16, 5, 1, 8, 4, 16, 15, 15, 17, 11, 14, 17, 7, 19, 1, 4, 1, 6, 1, 3, 10, 12, 11, 18, 6, 18, 15, 4, 2, 1, 1, 9, 11, 19, 18, 12, 11, 18, 1, 14, 7, 15, 7, 17, 10, 18, 0, 4, 17, 1, 8, 12, 12, 15, 18, 12, 0, 2, 5, 14, 11, 4}, {16, 9, 10, 7, 0, 8, 9, 18, 6, 5, 6, 16, 14, 11, 4, 4, 12, 13, 7, 14, 13, 16, 7, 16, 10, 5, 1, 17, 5, 4, 5, 5, 14, 9, 1, 7, 14, 17, 2, 19, 18, 8, 14, 3, 6, 10, 15, 16, 0, 5, 8, 7, 4, 14, 2, 14, 11, 4, 17, 1, 6, 6, 5, 17}, {5, 9, 8, 1, 12, 13, 1, 5, 0, 9, 12, 4, 15, 19, 17, 14, 7, 14, 3, 14, 14, 3, 18, 15, 12, 19, 4, 17, 5, 10, 10, 19, 2, 5, 15, 3, 18, 2, 15, 2, 10, 14, 6, 4, 18, 17, 7, 7, 18, 14, 11, 16, 18, 1, 19, 19, 11, 4, 11, 13, 16, 18, 13, 13}, {0, 9, 2, 3, 17, 0, 12, 15, 6, 4, 6, 13, 10, 12, 8, 7, 2, 15, 2, 6, 9, 2, 9, 19, 6, 4, 17, 1, 15, 5, 14, 11, 13, 12, 14, 19, 13, 1, 3, 18, 2, 3, 14, 4, 16, 16, 5, 13, 17, 13, 16, 10, 10, 13, 15, 14, 3, 15, 1, 5, 8, 12, 8, 6}, {4, 11, 18, 17, 8, 3, 9, 15, 4, 15, 4, 10, 7, 1, 14, 2, 16, 2, 19, 6, 14, 11, 1, 17, 0, 12, 17, 13, 6, 5, 4, 9, 12, 14, 10, 3, 13, 13, 10, 13, 9, 16, 15, 13, 19, 4, 14, 1, 3, 8, 0, 9, 0, 3, 17, 16, 18, 5, 13, 17, 14, 2, 14, 13}, {3, 13, 2, 15, 9, 4, 1, 17, 1, 9, 16, 3, 1, 0, 18, 11, 6, 12, 4, 14, 12, 17, 17, 14, 17, 12, 7, 17, 6, 7, 17, 14, 11, 19, 2, 15, 2, 14, 11, 14, 4, 11, 17, 14, 12, 10, 6, 7, 13, 18, 18, 7, 19, 17, 18, 11, 5, 14, 12, 13, 18, 14, 6, 7}, {1, 13, 10, 13, 0, 5, 19, 1, 10, 14, 12, 12, 17, 0, 9, 14, 0, 6, 2, 19, 12, 16, 11, 12, 10, 3, 13, 9, 13, 5, 13, 17, 18, 7, 11, 16, 14, 5, 3, 14, 11, 17, 19, 11, 3, 0, 4, 7, 6, 7, 0, 13, 7, 17, 5, 5, 7, 6, 1, 17, 15, 3, 13, 7}, {16, 17, 4, 0, 4, 8, 16, 3, 18, 18, 12, 17, 14, 2, 19, 11, 17, 18, 0, 15, 9, 16, 8, 1, 10, 0, 4, 9, 12, 9, 7, 13, 16, 3, 0, 8, 18, 4, 5, 15, 17, 3, 6, 17, 19, 12, 13, 6, 11, 15, 15, 16, 10, 1, 11, 17, 14, 17, 2, 9, 14, 17, 3, 1}, {2, 16, 17, 18, 17, 12, 0, 0, 10, 1, 17, 14, 2, 8, 7, 19, 2, 10, 15, 8, 4, 9, 15, 8, 14, 9, 15, 9, 2, 9, 16, 0, 5, 5, 15, 5, 1, 1, 6, 2, 3, 11, 2, 6, 9, 13, 17, 10, 16, 6, 6, 6, 14, 3, 8, 15, 15, 0, 15, 18, 6, 8, 15, 9}, {3, 10, 0, 13, 5, 9, 2, 14, 6, 19, 19, 4, 14, 0, 6, 0, 18, 5, 3, 0, 13, 7, 1, 9, 10, 9, 15, 2, 9, 15, 16, 1, 19, 7, 13, 14, 17, 14, 14, 4, 12, 15, 14, 4, 13, 7, 15, 5, 16, 1, 10, 13, 3, 6, 15, 15, 1, 17, 18, 2, 12, 9, 10, 7}, {8, 3, 15, 0, 10, 19, 11, 3, 10, 16, 9, 9, 1, 4, 0, 4, 2, 7, 19, 9, 15, 3, 18, 12, 9, 4, 0, 2, 14, 2, 10, 13, 0, 0, 17, 11, 15, 13, 4, 12, 10, 10, 10, 17, 14, 14, 4, 6, 8, 18, 6, 0, 18, 6, 5, 5, 10, 10, 17, 7, 4, 6, 4, 7}, {9, 16, 15, 7, 4, 19, 7, 6, 1, 5, 17, 19, 9, 10, 4, 14, 2, 8, 12, 2, 7, 8, 9, 10, 4, 14, 5, 15, 4, 6, 7, 14, 16, 12, 5, 8, 10, 1, 9, 13, 10, 0, 12, 15, 5, 15, 7, 8, 7, 11, 0, 15, 7, 7, 9, 10, 7, 6, 8, 0, 13, 5, 16, 13}, {1, 19, 15, 2, 4, 3, 13, 11, 19, 0, 16, 9, 14, 17, 7, 10, 13, 12, 13, 7, 5, 9, 7, 13, 10, 4, 11, 8, 8, 3, 2, 9, 13, 15, 9, 13, 19, 18, 0, 9, 19, 13, 18, 5, 13, 0, 17, 17, 7, 19, 1, 14, 1, 10, 13, 8, 11, 9, 16, 16, 16, 0, 18, 6}, {5, 6, 12, 5, 18, 9, 10, 10, 5, 3, 16, 3, 18, 5, 0, 8, 12, 19, 4, 4, 12, 0, 19, 11, 16, 4, 5, 13, 2, 17, 0, 11, 8, 9, 15, 2, 2, 16, 18, 3, 7, 1, 16, 3, 15, 7, 14, 16, 17, 2, 4, 14, 9, 9, 10, 9, 7, 11, 1, 5, 12, 9, 8, 13}, {5, 19, 6, 8, 14, 11, 5, 3, 3, 13, 17, 13, 19, 14, 12, 16, 10, 18, 18, 10, 17, 0, 6, 6, 6, 12, 16, 14, 1, 13, 17, 3, 12, 6, 13, 19, 18, 15, 3, 4, 3, 13, 0, 13, 15, 18, 1, 10, 16, 8, 19, 1, 19, 9, 11, 3, 14, 12, 6, 7, 10, 7, 8, 1}, {12, 0, 4, 0, 3, 7, 16, 2, 9, 10, 19, 15, 1, 8, 7, 6, 17, 4, 14, 3, 16, 5, 16, 8, 0, 19, 0, 11, 14, 1, 4, 12, 7, 18, 11, 9, 8, 16, 3, 2, 10, 11, 19, 15, 8, 3, 11, 1, 18, 17, 7, 17, 18, 19, 14, 4, 18, 12, 12, 8, 10, 6, 6, 12}, {15, 8, 3, 7, 17, 16, 4, 3, 2, 14, 1, 2, 17, 11, 8, 18, 2, 4, 14, 17, 4, 7, 8, 4, 9, 9, 12, 5, 1, 3, 18, 4, 10, 14, 6, 10, 15, 17, 1, 14, 5, 1, 16, 10, 19, 1, 4, 18, 15, 17, 19, 4, 19, 10, 3, 11, 1, 8, 7, 13, 11, 14, 4, 13}, {6, 3, 10, 7, 10, 6, 8, 11, 15, 17, 4, 8, 19, 16, 0, 1, 16, 8, 2, 11, 1, 15, 19, 18, 5, 18, 17, 2, 17, 13, 19, 10, 4, 12, 6, 12, 17, 12, 9, 13, 15, 10, 1, 12, 0, 0, 7, 6, 8, 9, 12, 12, 6, 14, 4, 16, 15, 6, 6, 19, 18, 16, 12, 12}};
        _417_Pacific_Atlantic_Water_Flow q = new _417_Pacific_Atlantic_Water_Flow();
        for (int[] n : q.pacificAtlantic(martix)) {
            System.out.println(n[0] + ":" + n[1]);
        }
    }

}
