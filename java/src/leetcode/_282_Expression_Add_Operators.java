package leetcode;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class _282_Expression_Add_Operators {

  @Test
  public void test() {
    _282_Expression_Add_Operators q = new _282_Expression_Add_Operators();
    System.out.println(q.addOperators("105", 5));
  }

  List<String> ans = new ArrayList<>();
  int target;
  public List<String> addOperators(String num, int target) {
    this.target = target;
    dfs("", num, 0, 0, 0);
    return ans;
  }

  private void dfs(String sb, String num, int pre, int currentValue, int index) {
    if (index == num.length() && currentValue == target) {
      ans.add(sb);
    }else {
      for(int i = index; i < num.length(); i++) {
        if (num.charAt(index) == '0' && i > index) {
          break;
        }
        String sub = num.substring(index, i + 1);
        long longValue = Long.parseLong(sub);
        if (longValue > Integer.MAX_VALUE){
          break;
        }
        int n = (int) longValue;
        if (index == 0) {
          dfs(sb + n, num, n, n, i + 1);
        }else {
          dfs(sb + "+" + n, num, n, currentValue + n, i + 1);
          dfs(sb + "-" + n, num, -n, currentValue - n, i + 1);
          dfs(sb + "*" + n, num, pre * n, currentValue - pre + pre * n, i + 1);
        }
      }
    }
  }

}
