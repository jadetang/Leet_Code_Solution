package leetcode;

public class _796_Rotate_String {

  public boolean rotateString(String A, String B) {
    return A.length() == B.length() && (A + A).contains(B);
  }

}
