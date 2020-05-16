package company.google;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class CanAvoidFlood {

  List<Integer> canAvoidFlood(int n, int m, int[] A) {
    Deque<Integer>[] forecast = new Deque[n];           // predict the next time it will rain for each lake
    HashSet<Integer> filledLakes = new HashSet<>();     // which lakes are currently filled with water
    PriorityQueue<Integer> pq = new PriorityQueue<>();  // the greedy strategy of the dragon:
    // pick the lake where a flood will happen the soonest
    List<Integer> assignments = new ArrayList<>();      // history of choices of the dragon

    // Build weather forecast for the dragon O(n + m)
    for (int i = 0; i < n; ++i) {
      forecast[i] = new ArrayDeque<>();
    }
    for (int i = 0; i < m; ++i) {
      if (A[i] == 0) {
        continue; // skip sunny days
      }
      forecast[A[i] - 1].addLast(i);
    }

    // Run a simulation through all the days O(m*log(m))
    for (int i = 0; i < m; ++i) {
      if (A[i] == 0) { // sunny day
        if (pq.size() > 0) {
          int lake = A[pq.poll()];
          filledLakes.remove(lake);
          assignments.add(lake);
        } else {
          assignments.add(1); // pick an arbitrary lake
        }
      } else { // rainy day
        if (filledLakes.contains(A[i])) // flood occurs
        {
          return null;
        }
        filledLakes.add(A[i]);
        Deque<Integer> next = forecast[A[i] - 1];
        next.pollFirst();
        if (next.size() > 0) {
          pq.add(next.peekFirst());
        }
      }
    }
    return assignments;
  }


  public static void main(String[] args) {
    int[] A = {1,2,3,0,2,0,1};
    CanAvoidFlood s = new CanAvoidFlood();
    List<Integer> x = s.canAvoidFlood(3, 7, A);
    if (x == null) {
      System.out.println("null");
    } else {
      for (int i : x) {
        System.out.print(i + " "); // 5 1
      }
    }
  }
}
