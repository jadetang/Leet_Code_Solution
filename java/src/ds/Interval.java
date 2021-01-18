package ds;

/**
 * @author jade on 2016/11/14 上午7:29
 */
public class Interval {

  public int start;
  public int end;

  public String label;

  public Interval() {
    start = 0;
    end = 0;
  }

  public Interval(int s, int e) {
    start = s;
    end = e;
  }

  public Interval(int s, int e, String label) {
    start = s;
    end = e;
    this.label = label;
  }

  @Override
  public String toString() {
    return "[" + start + ":" + end + "]";
  }

}
