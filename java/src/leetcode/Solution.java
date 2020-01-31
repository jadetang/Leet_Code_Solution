/*
package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

*/
/**
 * @author jade on 16/7/16 下午12:09
 *//*

public class Solution {

    public static class Digraph {

        private static final String NEWLINE = System.getProperty("line.separator");

        private final int             V;           // number of vertices in this digraph
        private       int             E;                 // number of edges in this digraph
        private       List<Integer>[] adj;    // adj[v] = adjacency list for vertex v
        private       int[]           indegree;        // indegree[v] = indegree of vertex v

        public Digraph(int V) {
            if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
            this.V = V;
            this.E = 0;
            indegree = new int[V];
            adj = (List<Integer>[]) new List[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new LinkedList<>();
            }
        }

        public Digraph(Digraph G) {
            this(G.V());
            this.E = G.E();
            for (int v = 0; v < V; v++)
                this.indegree[v] = G.indegree(v);
            for (int v = 0; v < G.V(); v++) {
                // reverse so that adjacency list is in same order as original
                Stack<Integer> reverse = new Stack<Integer>();
                for (int w : G.adj[v]) {
                    reverse.push(w);
                }
                for (int w : reverse) {
                    adj[v].add(w);
                }
            }
        }

        public int V() {
            return V;
        }

        public int E() {
            return E;
        }

        // throw an IndexOutOfBoundsException unless 0 <= v < V
        private void validateVertex(int v) {
            if (v < 0 || v >= V)
                throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V - 1));
        }

        public void addEdge(int v, int w) {
            validateVertex(v);
            validateVertex(w);
            adj[v].add(w);
            indegree[w]++;
            E++;
        }

        public Iterable<Integer> adj(int v) {
            validateVertex(v);
            return adj[v];
        }

        public int outdegree(int v) {
            validateVertex(v);
            return adj[v].size();
        }

        public int indegree(int v) {
            validateVertex(v);
            return indegree[v];
        }

        public Digraph reverse() {
            Digraph reverse = new Digraph(V);
            for (int v = 0; v < V; v++) {
                for (int w : adj(v)) {
                    reverse.addEdge(w, v);
                }
            }
            return reverse;
        }

        public String toString() {
            StringBuilder s = new StringBuilder();
            s.append(V + " vertices, " + E + " edges " + NEWLINE);
            for (int v = 0; v < V; v++) {
                s.append(String.format("%d: ", v));
                for (int w : adj[v]) {
                    s.append(String.format("%d ", w));
                }
                s.append(NEWLINE);
            }
            return s.toString();
        }


    }


    public static class DirectedDFS {

        private boolean[] marked;  // marked[v] = true if v is reachable
        // from source (or sources)
        private int       count;         // number of vertices reachable from s

        public DirectedDFS(Digraph G, int s) {
            marked = new boolean[G.V()];
            dfs(G, s);
        }

        public DirectedDFS(Digraph G, Iterable<Integer> sources) {
            marked = new boolean[G.V()];
            for (int v : sources) {
                if (!marked[v]) dfs(G, v);
            }
        }

        private void dfs(Digraph G, int v) {
            count++;
            marked[v] = true;
            for (int w : G.adj(v)) {
                if (!marked[w]) dfs(G, w);
            }
        }

        public boolean marked(int v) {
            return marked[v];
        }

        public int count() {
            return count;
        }

    }

    public static class NFA {

        private char[]  re;
        private Digraph G;
        private int     M;

        public NFA(String regexp) {  // Create the NFA for the given regular expression.
            Stack<Integer> ops = new Stack<Integer>();
            re = regexp.toCharArray();
            M = re.length;
            G = new Digraph(M + 1);
            for (int i = 0; i < M; i++) {
                int lp = i;
                if (re[i] == '(' || re[i] == '|') ops.push(i);
                else if (re[i] == ')') {
                    int or = ops.pop();
                    if (re[or] == '|') {
                        lp = ops.pop();
                        G.addEdge(lp, or + 1);
                        G.addEdge(or, i);
                    } else lp = or;
                }
                if (i < M - 1 && re[i + 1] == '*')  // lookahead
                {
                    G.addEdge(lp, i + 1);
                    G.addEdge(i + 1, lp);
                }
                if (re[i] == '(' || re[i] == '*' || re[i] == ')') G.addEdge(i, i + 1);
            }
        }

        public boolean recognizes(String txt) {
            List<Integer> pc = new LinkedList<>();
            DirectedDFS dfs = new DirectedDFS(G, 0);
            for (int v = 0; v < G.V(); v++)
                if (dfs.marked(v)) pc.add(v);
            for (int i = 0; i < txt.length(); i++) {  // Compute possible NFA states for txt[i+1].
                List<Integer> match = new LinkedList<>();
                for (int v : pc)
                    if (v < M) if (re[v] == txt.charAt(i) || re[v] == '.') match.add(v + 1);
                pc = new LinkedList<>();
                dfs = new DirectedDFS(G, match);
                for (int v = 0; v < G.V(); v++)
                    if (dfs.marked(v)) pc.add(v);
            }
            for (int v : pc) if (v == M) return true;
            return false;
        }
        // Does the NFA recognize txt? (See page 799.)
    }




    public boolean isMatch(String s, String p) {
        NFA n = new NFA(p);
        return n.recognizes(s);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isMatch("a","a"));
    }

}
*/
