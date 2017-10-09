package company.booking;

/**
 * @author sanguan.tangsicheng on 2017/6/25 上午9:46
 */
public class CompressString {

  public static void main(String[] args) {
    System.out.println(charFrequency("aaaabbbbccca"));
  }

  public static String charFrequency(String s) {
    String res = "";
    int ind = 0;
    while (ind < s.length()) {
      char cur = s.charAt(ind);
      int num = 1;
      while (ind < s.length() - 1 && cur == s.charAt(ind + 1)) {
        ind++;
        num++;
      }
      ind++;
      res += String.format("%s%s", cur, num);
    }
    return res;
  }
}
