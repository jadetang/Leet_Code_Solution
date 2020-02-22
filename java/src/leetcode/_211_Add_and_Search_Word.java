package leetcode;

import org.junit.Test;
import util.Assert;

public class _211_Add_and_Search_Word {

    @Test
    public void test() {
        _211_Add_and_Search_Word q = new _211_Add_and_Search_Word();
        q.addWord("abc");
        Assert.assertTrue(q.search("abc"));
        Assert.assertTrue(q.search("ab."));
        Assert.assertTrue(q.search(".bc"));
        Assert.assertFalse(q.search("ab"));
        Assert.assertFalse(q.search("abcd"));
    }

    TrieNode root = new TrieNode();

    /** Initialize your data structure here. */
    public _211_Add_and_Search_Word() {

    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode n = root;
        for (char c : word.toCharArray()) {
            if (n.array[c - 'a'] == null) {
                n.array[c - 'a'] = new TrieNode();
            }
            n = n.array[c - 'a'];
        }
        n.hasValue = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(root,word.toCharArray(), 0);
    }

    private boolean search(TrieNode node, char[] chars, int i) {
        if (node == null) {
            return false;
        }
        if (i >= chars.length) {
            return node.hasValue;
        }
        char c = chars[i];
        if (c != '.') {
            return search(node.array[c - 'a'], chars, i + 1);
        }else {
            boolean result;
            for (int j = 0; j < 26; j++) {
                result = search(node.array[j], chars, i + 1);
                if (result) {
                    return result;
                }
            }
            return false;
        }
    }

    public static class TrieNode {
        TrieNode[] array = new TrieNode[26];
        boolean hasValue;
    }

}
