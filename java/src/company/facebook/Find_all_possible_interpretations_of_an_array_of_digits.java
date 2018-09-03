package company.facebook;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * http://www.geeksforgeeks.org/find-all-possible-interpretations/
 *
 * @author jade on 2017/6/27 下午11:08
 */
public class Find_all_possible_interpretations_of_an_array_of_digits {

  private static final String[] alphabet = {"", "a", "b", "c", "d", "e",
      "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
      "s", "t", "u", "v", "w", "x", "v", "z"};

  public static class Node {

    String data;

    public Node(String data) {
      this.data = data;
    }

    Node left;

    Node right;

  }

  public static List<String> interpretations(int[] array) {

    if (array == null || array.length == 0) {
      return Collections.emptyList();
    } else {
      Node root = createNode(0, "", array);

      List<String> acc = new LinkedList<>();

      traverse(root, acc);

      return acc;
    }
  }

  private static void traverse(Node node, List<String> acc) {
    if (node == null) {
      return;
    } else {
      if (node.left == null && node.right == null) {
        acc.add(node.data);
      }
      traverse(node.right, acc);
      traverse(node.left, acc);
    }
  }

  private static Node createNode(int data, String preString, int[] array) {

    String str = preString + alphabet[data];
    Node n = new Node(str);
    if (array.length != 0) {
      int newData = array[0];
      int[] newArray = Arrays.copyOfRange(array, 1, array.length);
      n.left = createNode(newData, str, newArray);
      if (array.length > 1) {
        int num = array[0] * 10 + array[1];
        if (num < 26) {
          newArray = Arrays.copyOfRange(array, 2, array.length);
          n.right = createNode(num, str, newArray);
        }
      }
    }
    return n;

  }

  public static void main(String[] args) {
    int[] array = new int[]{1, 0};
    System.out.println(interpretations(array));
  }

}
