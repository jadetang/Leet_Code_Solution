package lintcode;

import util.Assert;

public class _1255_Remove_K_Digits {


  public static void main(String[] args) {
    _1255_Remove_K_Digits q = new _1255_Remove_K_Digits();
    Assert.assertEqual("132219", q.removeOneDigit("1432219"));
    Assert.assertEqual("1345", q.removeOneDigit("13456"));
    Assert.assertEqual("13456", q.removeOneDigit("913456"));
    Assert.assertEqual("000", q.removeOneDigit("2000"));
  }

  String removeOneDigit(String num) {
    StringBuilder sb = new StringBuilder();
    int i = 0;
    char[] chars = num.toCharArray();
    for (; i < chars.length - 1; i++) {
      if (chars[i] > chars[i + 1]) {
        i++;
        break;
      } else {
        sb.append(chars[i]);
      }
    }
    if (sb.length() != chars.length - 1) {
      for (; i < chars.length; i++) {
        sb.append(chars[i]);
      }
    }
    return sb.toString();
  }

}
