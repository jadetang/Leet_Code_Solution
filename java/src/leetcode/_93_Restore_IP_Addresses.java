package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author jade on 2017/5/19 下午4:05
 */
public class _93_Restore_IP_Addresses {

  public static void main(String[] args) {
    _93_Restore_IP_Addresses q = new _93_Restore_IP_Addresses();
    System.out.println(q.restoreIpAddresses("25525511135"));
  }

  public List<String> restoreIpAddresses(String s) {

    List<String> acc = new LinkedList<>();
    char[] chars = s.toCharArray();
    driver(chars, acc, new LinkedList<>(), 0);
    return acc;
  }

  private void driver(char[] chars, List<String> acc, List<String> tempList, int start) {
    if (tempList.size() == 4 && start == chars.length) {
      acc.add(join(tempList));
    } else {
      for (int i = start; i < chars.length && tempList.size() < 4; i++) {
        String tempString = string(chars, start, i);
        if (isValid(tempString)) {
          tempList.add(tempString);
          driver(chars, acc, tempList, i + 1);
          tempList.remove(tempList.size() - 1);
        } else {
          break;
        }

      }
    }
  }

  private boolean isValid(String temp) {
    if (temp.startsWith("0") && temp.length() > 1) {
      return false;
    } else {
      Integer i = Integer.valueOf(temp);
      return i >= 0 && i <= 255;
    }
  }

  private String string(char[] chars, int start, int end) {
    StringBuilder sb = new StringBuilder();
    for (int i = start; i <= end; i++) {
      sb.append(chars[i]);
    }
    return sb.toString();
  }

  String join(List<String> list) {
    StringBuilder s = new StringBuilder();
    for (String str : list) {
      s.append(str + ".");
    }
    s.deleteCharAt(s.length() - 1);
    return s.toString();
  }
}
