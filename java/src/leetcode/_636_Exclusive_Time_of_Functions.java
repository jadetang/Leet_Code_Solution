package leetcode;

import java.util.List;
import java.util.Stack;

/**
 * @author jade on 2017/7/16 上午9:47
 */
public class _636_Exclusive_Time_of_Functions {


  public int[] exclusiveTime(int n, List<String> logs) {
    Stack<Log> stack = new Stack<>();

    int[] logTime = new int[n];

    for (String s : logs) {
      Log log = Log.parse(s);
      if (log.isStart()) {
        stack.push(log);
      } else {
        Log currentLog = stack.pop();
        int time = log.timeStamp - currentLog.timeStamp + 1;
        logTime[currentLog.id] += time;
        if (!stack.isEmpty()) {
          logTime[stack.peek().id] -= time;
        }

      }
    }
    return logTime;
  }


  public static class Log {

    public int id;

    public int timeStamp;

    public boolean start;

    public Log(int id, int timeStamp, boolean start) {
      this.id = id;
      this.timeStamp = timeStamp;
      this.start = start;
    }


    public static Log parse(String s) {
      String[] data = s.split(":");

      boolean start = data[1].equals("start");

      return new Log(Integer.parseInt(data[0]), Integer.parseInt(data[2]), start);
    }

    public boolean isStart() {
      return start;
    }


  }

}
