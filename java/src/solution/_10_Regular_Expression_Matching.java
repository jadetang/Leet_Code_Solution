package solution;

import ds.Digraph;
import ds.DirectedDFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author sanguan.tangsicheng on 16/7/16 上午11:50
 */
public class _10_Regular_Expression_Matching {

    public boolean isMatch(String s, String p) {
        NFA n  = new NFA(p);
        return n.recognizes(s);
    }


    public static class NFA {

        private char[]  re;
        private Digraph G;
        private int     M;

        // match transitions
        // epsilon transitions
        // number of states
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

}
