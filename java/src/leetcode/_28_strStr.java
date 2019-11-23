package leetcode;

import level.Easy;

/**
 * @author jade on 2017/7/1 下午3:47
 */
public class _28_strStr implements Easy {

  public int strStr(String haystack, String needle) {
    for (int i = 0; ; i++) {
      for (int j = 0; ; j++) {
        if (j == needle.length()) {
          return i;
        }
        if (i + j == haystack.length()) {
          return -1;
        }
        if (needle.charAt(j) != haystack.charAt(i + j)) {
          break;
        }
      }
    }
  }


  public String strStr2(String haystack, String needle) {
    //KMP algorithms
    if (needle.equals("")) {
      return haystack;
    }
    if (haystack.equals("")) {
      return null;
    }
    char[] arr = needle.toCharArray();
    int[] next = makeNext(arr);

    for (int i = 0, j = 0, end = haystack.length(); i < end; ) {
      if (j == -1 || haystack.charAt(i) == arr[j]) {
        j++;
        i++;
        if (j == arr.length) {
          return haystack.substring(i - arr.length);
        }
      }
      if (i < end && haystack.charAt(i) != arr[j]) {
        j = next[j];
      }
    }
    return null;
  }

  private int[] makeNext(char[] arr) {
    int len = arr.length;
    int[] next = new int[len];

    next[0] = -1;
    for (int i = 0, j = -1; i + 1 < len; ) {
      if (j == -1 || arr[i] == arr[j]) {
        next[i + 1] = j + 1;
        if (arr[i + 1] == arr[j + 1]) {
          next[i + 1] = next[j + 1];
        }
        i++;
        j++;
      }
      if (arr[i] != arr[j]) {
        j = next[j];
      }
    }

    return next;
  }


}
