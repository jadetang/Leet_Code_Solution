package solution;

/**
 * @author sanguan.tangsicheng on 2016/11/29 上午12:45
 */
public class _388_Longest_Absolute_File_Path {

  public int lengthLongestPath(String input) {
    String reg = "\n(?!\t)";
    String[] dirs = input.split(reg);
    int max = 0;
    for (int i = 0; i < dirs.length; i++) {
      max = Math.max(max, max(dirs[i], "\n\t(?!\t)"));
    }
    return max;
  }


  private int max(String input, String level) {

    if (!input.contains(".")) {
      return 0;
    }

    String[] subPaths = input.split(level);
    if (subPaths.length == 1) {
      return subPaths[0].contains(".") ? subPaths[0].length() : 0;
    } else {
      int max = 0;
      for (int i = 1; i < subPaths.length; i++) {
        max = Math.max(max, max(subPaths[i], nextLevel(level)));
      }
      return subPaths[0].length() + 1 + max;
    }
  }

  private String nextLevel(String level) {
    String nextLevel = "\n\t" + level.substring(1);
    if (level.equals(nextLevel)) {
      throw new RuntimeException("");
    }
    return nextLevel;
  }

  public static void main(String[] args) {
    _388_Longest_Absolute_File_Path q = new _388_Longest_Absolute_File_Path();
    System.out.println(q.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
  }
}
