package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _146_LRU_Cache {

  public static class LRUCache {

    Map<Integer, Node> map = new HashMap<>();
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int capacity;

    public LRUCache(int capacity) {
      this.capacity = capacity;
      head.pre = head.next = tail;
      tail.pre = tail.next = head;
    }

    public int get(int key) {
      Node node = map.get(key);
      if (node == null) {
        return -1;
      }
      unlink(node);
      insertFront(node);
      return node.value;
    }

    public void put(int key, int value) {
      Node node = map.get(key);
      if (node != null && node.value == value) {
        return;
      }
      if (node != null) {
        unlink(node);
        map.remove(key);
        Node newNode = new Node(key, value);
        insertFront(newNode);
        map.put(key, newNode);
      } else {
        if (map.size() >= this.capacity) {
          map.remove(tail.pre.key);
          unlink(tail.pre);
        }
        Node newNode = new Node(key, value);
        insertFront(newNode);
        map.put(key, newNode);
      }

    }

    private void unlink(Node node) {
      node.pre.next = node.next;
      node.next.pre = node.pre;
      node.next = null;
      node.pre = null;
    }

    private void insertFront(Node node) {
      node.pre = head;
      node.next = head.next;
      head.next.pre = node;
      head.next = node;
    }

    public static class Node {

      int value;

      int key;

      Node pre;

      Node next;

      public Node(int key, int value) {
        this.key = key;
        this.value = value;
      }

    }

  }

}
