package solution;

/**
 * @author sanguan.tangsicheng on 2016/11/16 下午8:22
 */
public class _318_Maximum_Product_of_Word_Lengths {

  public int maxProduct(String[] words) {
    int[] bits = new int[words.length];
    for (int i = 0; i < words.length; i++) {
      for (int j = 0; j < words[i].length(); j++) {
        bits[i] |= 1 << (words[i].charAt(j) - 'a');
      }
    }
    int ans = 0;
    for (int i = 0; i < bits.length - 1; i++) {
      for (int j = i + 1; j < bits.length; j++) {
        if ((bits[i] & bits[j]) == 0) {
          ans = Math.max(0, words[i].length() * words[j].length());
        }
      }
    }
    return ans;

  }
}
