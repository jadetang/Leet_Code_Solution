package solution;

import java.util.ArrayDeque;
import java.util.Deque;
import level.Medium;
import util.Util;

/**
 * Given a list of daily temperatures, produce a list that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

 For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

 Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */
public class _739_Daily_Temperatures implements Medium{

  public static void main(String[] args) {
    _739_Daily_Temperatures q = new _739_Daily_Temperatures();
    int[] temp = new int[]{73,74,75,71,69,72,76,73};
    int[] ans = q.dailyTemperatures(temp);
    Util.print(ans);
  }


  public int[] dailyTemperatures(int[] temperatures) {
    Deque<Temp> stack = new ArrayDeque<>();
    stack.offer(new Temp( temperatures[0], 0));
    int[] ans = new int[temperatures.length];
    for(int i = 1; i < temperatures.length; i ++){
      Temp next = new Temp(temperatures[i],i);
      while( !stack.isEmpty() && next.temperature > stack.peek().temperature){
        Temp before = stack.pop();
        ans[before.index] = next.index - before.index;
      }
      stack.push(next);
    }
    while(stack.isEmpty()){
      ans[stack.pop().index] = 0;
    }
    return ans;
  }

  public static class Temp{

    public int temperature;

    public int index;

    @Override
    public String toString() {
      return "Temp{" +
          "temperature=" + temperature +
          ", index=" + index +
          '}';
    }

    public Temp(int temperature, int index){
      this.temperature = temperature;
      this.index = index;
    }

  }

}
