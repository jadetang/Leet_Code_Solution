package leetcode;

/**
 * @author jade on 2017/7/2 下午4:38
 */
public class _134_Gas_Station {

  /**
   * The idea is simple.
   *
   * Whenever the sum is negative, reset it and let the car start from next point. In the mean time,
   * add up all of the left gas to total. If it's negative finally, return -1 since it's impossible
   * to finish. If it's non-negative, return the last point saved in res;
   */
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int sum = 0;
    int res = 0;
    int total = 0;
    for (int i = 0; i < gas.length; i++) {
      sum += gas[i] - cost[i];
      if (sum < 0) {
        total += sum;
        sum = 0;
        res = i + 1;
      }
    }
    total += sum;
    return total < 0 ? -1 : res;
  }
}
