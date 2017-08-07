package company.booking;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * http://techieme.in/word-frequency-in-stream/
 *
 * Output the words found in a stream of characters.
 * - Input: Dictionary<string>, Stream
 * - Output: Dictionary containing words and their occurences.
 * - Complexity, best case, worst case
 *
 * @author sanguan.tangsicheng on 2017/7/8 下午4:06
 */
public class Output_the_words_found_in_a_stream_of_characters {

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("aca");
        dict.add("cat");
        dict.add("hell");
        dict.add("hello");
        dict.add("lock");
        dict.add("world");
        char[] c = "acacathellockword".toCharArray();
        match(dict,c);
    }


    public static void match(Set<String> dict, char[] stream) {

        Trie t = new Trie();
        for (String word : dict) {
            t.insert(word);
        }
        Deque<TrieNode> queue = new ArrayDeque<>();
        Deque<TrieNode> tempNodes = new ArrayDeque<>();
        for (char c : stream) {
            queue.add(t.root); //从 C 开始新一轮 的 查找
            while (!queue.isEmpty()) {
                TrieNode first = queue.removeFirst();
                // This code just prints the word, the moment it is detected. You can put the word in map here
                if (first.value != null) {
                   // System.out.println(first.data[c - 'a'].value);
                    System.out.println(first.value);
                }

                TrieNode tn = first.data[c - 'a'];
                if (tn != null) {
                    tempNodes.add(tn);
                }
            }

            queue.addAll(tempNodes);
            tempNodes.clear();
            System.out.println(c + " queue:"+queue);
        }
        // once the character stream ends, and the queue still has some nodes, check if the nodes end in valid words and print them accordingly
        while (!queue.isEmpty()) {
            TrieNode first = queue.removeFirst();
            if (first.data != null) {
                System.out.println(first.data);
            }
        }
    }





    public static class Trie {

        String empty;

        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode('0');
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            if (word == null || word.length() == 0) {
                empty = word;
            } else {
                TrieNode n = root;
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
                TrieNode n = root;
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
                TrieNode n = root;
                for (char c : prefix.toCharArray()) {
                    if ((n = n.get(c)) == null) {
                        return false;
                    }
                }
                return true;
            }
        }

    }

    public static class TrieNode {

        public TrieNode[] data;

        public String value;

        private char c;

        public TrieNode(char c) {
            this.c = c;
            data = new TrieNode[26];
        }

        public TrieNode get(char c) {
            return data[c - 'a'];
        }

        public String getValue() {
            return value;
        }

        public void putValue(String value) {
            this.value = value;
        }

        public TrieNode add(char c) {
            if (get(c) == null) {
                data[c - 'a'] = new TrieNode(c);
            }
            return get(c);
        }

        @Override
        public String toString(){
            return this.c + ":"+this.value;
        }

    }



}
