package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author jade on 2016/11/12 下午8:10
 */
public class _119_Pascals_Triangle_II {

  public static void main(String[] args) {
    _119_Pascals_Triangle_II q = new _119_Pascals_Triangle_II();
    System.out.println(q.getRow(1));
    System.out.println(q.getRow(2));
    System.out.println(q.getRow(3));
    System.out.println(q.getRow(4));
  }

  public List<Integer> getRow(int rowIndex) {
    if (rowIndex == 0) {
      List<Integer> result = new LinkedList<>();
      result.add(1);
      return result;
    } else {
      int[] array = new int[rowIndex + 1];
      array[0] = 1;
      for (int i = 1; i <= rowIndex; i++) {
        int pre = 0;
        for (int j = 0; j <= i; j++) {
          if (j == 0) {
            pre = array[j];
            array[j] = 1;
          } else if (j == i) {
            array[j] = 1;
          } else {
            int temp = array[j];
            array[j] = array[j] + pre;
            pre = temp;
          }
        }
      }
      List<Integer> result = new LinkedList<>();
      for (int i : array) {
        result.add(i);
      }
      return result;
    }
  }
}
