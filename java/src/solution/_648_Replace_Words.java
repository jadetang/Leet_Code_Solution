package solution;

import java.util.Arrays;
import java.util.List;

/** 用 trie
 * @author sanguan.tangsicheng on 2017/7/30 下午6:57
 */
public class _648_Replace_Words {
    public String replaceWords(List<String> dict, String sentence) {
        if (sentence == null || sentence.length() == 0 || dict == null || dict.isEmpty()) {
            return sentence;
        }
        Trie trie = buildTrie(dict);
        List<String> sentencsWord = Arrays.asList(sentence.split(" "));
        return sentencsWord.stream().map(s -> trie.getShortestPrefix(s)).reduce((s1, s2) -> s1 + " " + s2).get();
    }


    private Trie buildTrie(List<String> dict) {
        Trie t = new Trie();
        dict.forEach(s -> t.add(s));
        return t;
    }


    public static class Trie {

        Node root;

        public Trie() {
            root = new Node();
        }

        public void add(String word) {
            Node node = root;
            for (char s : word.toCharArray()) {
                if (node.next[s - 'a'] == null) {
                    node.next[s - 'a'] = new Node();
                }
                node = node.next[s - 'a'];
            }
            node.val = word;
        }

        public String getShortestPrefix(String word) {
            int length = word.length();
            Node n = root;
            for( int i = 0 ; i < length; i++ ){
                n = n.next[word.charAt(i) - 'a'];
                if ( n == null ){
                    return word;
                }else if (n.val != null ){
                    return n.val;
                }
            }
            return word;
        }

    }

    public static class Node {

        Node[] next;
        String val;

        public Node() {
            next = new Node[26];
        }

    }
}
