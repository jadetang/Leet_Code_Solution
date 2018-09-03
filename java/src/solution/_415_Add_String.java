package solution;

import java.util.Arrays;

/**
 * @author jade on 2016/10/24 下午8:07
 */
public class _415_Add_String {

  public String addStrings(String num1, String num2) {
    if (num1 == null || num1.length() == 0) {
      return num2 == null || num2.length() == 0 ? "0" : num2;
    }
    if (num2 == null || num2.length() == 0) {
      return num1 == null || num1.length() == 0 ? "0" : num1;
    }
    String longString = null;
    String shortString = null;
    if (num1.length() >= num2.length()) {
      longString = num1;
      shortString = num2;
    } else {
      longString = num2;
      shortString = num1;
    }
    char[] longStringChar = longString.toCharArray();
    int[] longIntArray = convertToIntArray(longStringChar);
    char[] shortStringChar = shortString.toCharArray();
    int[] shortIntArray = convertToIntArray(shortStringChar);
    int diff = longIntArray.length - shortIntArray.length;
    int carry = 0;
    for (int i = shortIntArray.length - 1; i >= 0; i--) {
      int sum = longIntArray[diff + i] + shortIntArray[i] + carry;
      if (sum < 10) {
        longIntArray[diff + i] = sum;
        carry = 0;
      } else {
        carry = 1;
        longIntArray[diff + i] = sum % 10;
      }
    }
    if (carry == 0) {
      return intArrayToString(longIntArray);
    } else {
      int index = longString.length() - shortString.length() - 1;
      while (carry != 0 && index >= 0) {
        int sum = longIntArray[index] + carry;
        if (sum < 10) {
          longIntArray[index] = sum;
          carry = 0;
          break;
        } else {
          longIntArray[index] = sum % 10;
          index--;
        }
      }
      if (carry == 1) {
        return "1" + intArrayToString(longIntArray);
      } else {
        return intArrayToString(longIntArray);
      }
    }
  }

  private String intArrayToString(int[] intArray) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < intArray.length; i++) {
      sb.append(intArray[i]);
    }
    return sb.toString();
  }

  private int[] convertToIntArray(char[] charArray) {
    int[] result = new int[charArray.length];
    for (int i = 0; i < charArray.length; i++) {
      result[i] = (int) charArray[i] - 48;
    }
    return result;
  }

  public static void main(String[] args) {
    int[] a = new int[]{3, 2, 1};
    Arrays.sort(a);
    System.out.println(a);
  }

}
