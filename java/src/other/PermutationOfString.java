package other;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * see http://www.geeksforgeeks.org/lexicographic-permutations-of-string/
 *
 * @author jade on 2017/5/18 上午10:51
 */
public class PermutationOfString {


  public List<String> permutation(String s) {
    char[] chars = s.toCharArray();
    Arrays.sort(chars);
    List<String> result = new LinkedList<>();
    boolean finish = false;
    while (!finish) {
      result.add(new String(chars));
      int i = chars.length - 2;
      for (; i >= 0; i--) {
        if (s.charAt(i) < s.charAt(i + 1)) {
          break;
        }
      }
      if (i == -1) {
        break;
      } else {
        int ceilIndex = findCeil(chars, i);
        swap(chars, i, ceilIndex);
        reverse(chars, i + 1, chars.length - 1);
      }
    }
    return result;

  }

  private void reverse(char[] chars, int i, int i1) {

  }

  private void swap(char[] chars, int i, int ceilIndex) {

  }

  private int findCeil(char[] chars, int i) {
    return 0;
  }

}
