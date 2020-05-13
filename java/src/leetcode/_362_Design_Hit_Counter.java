package leetcode;

import org.junit.Test;
import util.Assert;

public class _362_Design_Hit_Counter {

  @Test
  public void test() {
    HitCounter counter = new HitCounter();
    counter.hit(1);
    counter.hit(2);
    counter.hit(3);
    Assert.assertEqual(3, counter.getHits(4));
    counter.hit(300);
    Assert.assertEqual(4, counter.getHits(300));
    Assert.assertEqual(3, counter.getHits(301));
  }


  public static class HitCounter {

    private final Counter[] counters;

    public HitCounter() {
      this.counters = new Counter[300];
    }

    public void hit(int timestamp) {
      Counter counter = counters[timestamp % 300];
      if (counter == null || counter.timeStamp < timestamp) {
        counters[timestamp % 300] = new Counter(1, timestamp);
      } else {
        counter.count++;
      }
    }

    public int getHits(int timestamp) {
      int hits = 0;
      for (int i = 0; i < counters.length; i++) {
        Counter counter = counters[i];
        if (counter != null && timestamp - counter.timeStamp < 300) {
          hits += counter.count;
        }
      }
      return hits;
    }

    public static class Counter {

      int count;
      int timeStamp;

      public Counter(int count, int timeStamp) {
        this.count = count;
        this.timeStamp = timeStamp;
      }

    }
  }
}
