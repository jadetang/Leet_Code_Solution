package solution;

/**
 * @author sanguan.tangsicheng on 2016/12/7 下午9:19
 */
public class _467_Unique_Substrings_in_Wraparound_String {

  public int findSubstringInWraproundString(String p) {
    if (p == null || p.length() == 0) {
      return 0;
    }
    int[] count = new int[26];

    int currentMax = 1;
    count[p.charAt(0) - 'a'] = 1;

    for (int i = 1; i < p.length(); i++) {
      if (p.charAt(i) - p.charAt(i - 1) == 1 || (p.charAt(i) == 'a' && p.charAt(i - 1) == 'z')) {
        currentMax++;
      } else {
        currentMax = 1;
      }
      count[p.charAt(i) - 'a'] = Math.max(count[p.charAt(i) - 'a'], currentMax);
    }
    int sum = 0;
    for (int c :
        count) {
      sum += c;
    }
    return sum;
  }

}
