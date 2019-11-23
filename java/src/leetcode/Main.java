package leetcode;

public class Main {


  public static boolean equals(String s, String t) {

    s = s.equals("") ? "B" : s;
    t = t.equals("") ? "B" : t;

    int i = s.length() - 1;
    int j = t.length() - 1;
    for (; i >= 0 && j >= 0; ) {
      char sc = s.charAt(i);
      char tc = t.charAt(j);
      if (sc == tc && sc != 'B') {
        i--;
        j--;
      } else if (sc != tc && sc != 'B' && tc != 'B') {
        return false;
      }
      if (sc == 'B') {
        int length = 0;
        while (i >= 0 && s.charAt(i) == 'B') {
          i--;
          length++;
        }
        i -= length;
      }
      if (tc == 'B') {
        int length = 0;
        while (j >= 0 && t.charAt(j) == 'B') {
          j--;
          length++;
        }
        j -= length;
      }
    }
    return i <= 0 && j <= 0;
  }


  public static void main(String[] args) {
    System.out.println(Integer.toBinaryString(77));
    System.out.println(Integer.toBinaryString(77 >> 1));
    System.out.println(Integer.toBinaryString(77 >> 2));
    System.out.println(Integer.toBinaryString(77 >> 3));
    System.out.println(Integer.toBinaryString(77 >> 4));
  }
}
