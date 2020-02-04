package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

public class _212_word_searchII {

    char[][] board;

    Set<String> ans = new HashSet<>();

    Trie trie = new Trie();

    boolean[][] used;

    int row;

    int col;

    int[] dir = new int[] {1, 0, -1 ,0, 1};

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        row = board.length;
        col = board[0].length;
        used = new boolean[row][col];
        for (String w : words) {
            trie.add(w);
        }
        outloop:
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(new StringBuilder(), i, j);
                if (ans.size() == words.length) {
                    break outloop;
                }
            }
        }
        return new ArrayList<>(ans);
    }

    private void dfs(StringBuilder sb, int i, int j) {
        if (sb.length() > 0){
            TrieNode node = trie.getNode(sb.toString());
            if (node == null) {
                return;
            }
            if (node.value != null) {
                ans.add(node.value);
            }
        }
        if (i < 0 || i >= row || j < 0 || j >= col) {
            return;
        }
        if (used[i][j]) {
            return;
        }
        sb.append(board[i][j]);
        used[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int nextR = i + dir[k];
            int nextC = j + dir[k + 1];
            dfs(new StringBuilder(sb.toString()), nextR, nextC);
        }
        used[i][j] = false;
    }

    public static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void add(String s) {
            if (s == null || s.isEmpty()) {
                return;
            }
            TrieNode node = root;
            for (char c : s.toCharArray()) {
                TrieNode next = node.array[c - 'a'];
                if (next == null) {
                    next = new TrieNode();
                }
                node.array[c - 'a'] = next;
                node = next;
            }
            node.value = s;
        }

        private TrieNode getNode(String s) {
            if (s == null || s.isEmpty()) {
                return null;
            }
            TrieNode node = root;
            for (char c : s.toCharArray()) {
                node = node.array[c - 'a'];
                if (node == null) {
                    return null;
                }
            }
            return node;
        }
    }

    public static class TrieNode {
        TrieNode[] array = new TrieNode[26];
        String value;
        public TrieNode() {
        }
        public TrieNode(String value) {
            this.value = value;
        }
    }

    @Test
    public void test1() {
        Trie t = new Trie();
        t.add("abc");
        Assert.assertNotNull(t.getNode("a"));
        Assert.assertNotNull(t.getNode("abc"));
        Assert.assertNotNull(t.getNode("ab"));
    }

    @Test
    public void test2() {
        char[][] b = new char[][]  {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = new  String[]{"oath","pea","eat","rain"};
        _212_word_searchII q = new _212_word_searchII();
        Assert.assertEquals(2, q.findWords(b, words).size());
    }

}

