package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import org.junit.Test;

public class _1057_Campus_Bikes {

  @Test
  public void test() {
    int[][] workers = new int[][]{{0, 0}, {2, 1}};
    int[][] bikes = new int[][]{{1, 2}, {3, 3}};
    _1057_Campus_Bikes q = new _1057_Campus_Bikes();
    System.out.println(Arrays.toString(q.assignBikes(workers, bikes)));
  }

  public int[] assignBikes(int[][] workers, int[][] bikes) {
    PriorityQueue<Pair> pairs = new PriorityQueue<>((p1, p2) -> {
      if (p1.distance() == p2.distance()) {
        return p1.workerId - p2.workerId;
      }
      return p1.distance() - p2.distance();
    });
    for (int i = 0; i < workers.length; i++) {
      for (int j = 0; j < bikes.length; j++) {
        pairs.offer(new Pair(workers[i], bikes[j], i, j));
      }
    }
    Set<Integer> assignedBikes = new HashSet<>();
    Set<Integer> assignedWorkers = new HashSet<>();
    int[] ans = new int[workers.length];
    while (!pairs.isEmpty() && assignedBikes.size() < workers.length) {
      Pair pair = pairs.poll();
      if (!assignedBikes.contains(pair.bikeId) && !assignedWorkers.contains(pair.workerId)) {
        assignedBikes.add(pair.bikeId);
        assignedWorkers.add(pair.workerId);
        ans[pair.workerId] = pair.bikeId;
      }
    }
    return ans;
  }

  public static class Pair {

    int[] workerPosition;

    int[] bikePosition;

    int workerId;

    int bikeId;

    public Pair(int[] workerPosition, int[] bikePosition, int workerId, int bikeId) {
      this.workerPosition = workerPosition;
      this.bikePosition = bikePosition;
      this.workerId = workerId;
      this.bikeId = bikeId;
    }

    public int distance() {
      return Math.abs(this.workerPosition[0] - this.bikePosition[0]) +
          Math.abs(this.workerPosition[1] - this.bikePosition[1]);
    }

    @Override
    public String toString() {
      return "Pair{" +
          "workerPosition=" + Arrays.toString(workerPosition) +
          ", bikePosition=" + Arrays.toString(bikePosition) +
          ", workerId=" + workerId +
          ", bikeId=" + bikeId +
          ", distance=}" + this.distance();
    }
  }

}
