package solution;

/**
 * @author sanguan.tangsicheng on 2016/11/22 上午7:41
 */
public class _459_Repeated_Substring_Pattern {

  public boolean repeatedSubstringPattern(String str) {
    if (str.length() < 2) {
      return false;
    }
    int n = str.length();
    for (int i = 1; i <= n / 2; i++) {
      if (n % i == 0) {
        if (isRepeat(str, i)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean isRepeat(String str, int offset) {
    for (int i = 0; i < str.length() - offset; i += offset) {
      if (!str.substring(i, i + offset).equals(str.substring(i + offset, i + 2 * offset))) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    _459_Repeated_Substring_Pattern q = new _459_Repeated_Substring_Pattern();
    System.out.println(q.repeatedSubstringPattern("aabaaba"));
    System.out.println(q.repeatedSubstringPattern("aabaaaba"));
  }

}
