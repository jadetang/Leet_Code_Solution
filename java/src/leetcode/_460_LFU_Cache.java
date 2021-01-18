package leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class _460_LFU_Cache {

    @Test
    public void test() {
        var cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        Assert.assertEquals(1, cache.get(1));
        cache.put(3, 3);
        Assert.assertEquals(-1, cache.get(2));
    }

    @Test
    public void test1() {
        var cache = new LFUCache(0);
        cache.put(0, 0);
    }

    public static class LFUCache {

        int size;

        Map<Integer, Node> cache;

        Map<Integer, LinkedHashSet<Node>> frequencyToNode;

        int minFrequency;

        public LFUCache(int capacity) {
            this.size = capacity;
            this.cache = new HashMap<>();
            this.frequencyToNode = new HashMap<>();
            this.minFrequency = 1;
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) {
                return -1;
            }
            increaseFrequency(node);
            return node.value;
        }

        private void increaseFrequency(Node node) {
            var frequency = node.frequency;
            var sameFrequencySet = frequencyToNode.get(frequency);
            sameFrequencySet.remove(node);
            if (frequency == minFrequency && sameFrequencySet.isEmpty()) {
                minFrequency++;
            }
            node.frequency++;
            frequencyToNode.computeIfAbsent(node.frequency, i -> new LinkedHashSet<>()).add(node);
        }

        public void put(int key, int value) {
            Node node = cache.get(key);
            if (node != null) {
                node.value = value;
                increaseFrequency(node);
            } else {
                Node newNode = new Node(key, value);
                if (cache.size() >= size) {
                    remove();
                }
                cache.put(key, newNode);
                frequencyToNode.computeIfAbsent(newNode.frequency, i -> new LinkedHashSet<>()).add(newNode);
                minFrequency = 1;
            }
        }

        private void remove() {
            var nodes = frequencyToNode.get(minFrequency);
            var firstNode = nodes.iterator().next();
            cache.remove(firstNode.key);
            nodes.remove(firstNode);
        }

        public static class Node {
            int value;

            int frequency;

            int key;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
                this.frequency = 1;
            }
        }
    }
}
