package solution;

/**
 * @author jade on 2016/12/8 上午8:14
 */
public class _434_Number_of_Segments_in_a_String {

  public int countSegments(String s) {
    if (s == null || s.trim().length() == 0) {
      return 0;
    } else {
      return s.trim().split("\\s+").length;
    }
  }
}
