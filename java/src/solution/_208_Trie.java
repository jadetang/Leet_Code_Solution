package solution;

/**
 * @author sanguan.tangsicheng on 2017/7/4 上午7:49
 */
public class _208_Trie {

    String empty;

    Node root;

    /**
     * Initialize your data structure here.
     */
    public _208_Trie() {
        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            empty = word;
        } else {
            Node n = root;
            for (char c : word.toCharArray()) {
                n = n.add(c);
            }
            n.putValue(word);
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null) {
            return false;
        } else if (word.length() == 0) {
            return empty != null;
        } else {
            Node n = root;
            for (char c : word.toCharArray()) {
                if ((n = n.get(c)) == null) {
                    return false;
                }
            }
            return word.equals(n.getValue());
        }
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        } else if (prefix.length() == 0) {
            return empty != null;
        } else {
            Node n = root;
            for (char c : prefix.toCharArray()) {
                if ((n = n.get(c)) == null) {
                    return false;
                }
            }
            return true;
        }
    }

    public static class Node {

        Node[] data;

        String value;

        public Node() {
            data = new Node[26];
        }

        public Node get(char c) {
            return data[c - 'a'];
        }

        public String getValue() {
            return value;
        }

        public void putValue(String value) {
            this.value = value;
        }

        public Node add(char c) {
            if (get(c) == null) {
                data[c - 'a'] = new Node();
            }
            return get(c);
        }

    }

}
