package lintcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class _1562_Number_of_restaurants {


  public List<List<Integer>> nearestRestaurant(List<List<Integer>> restaurant, int n) {
    if (restaurant == null || restaurant.size() == 0) {
      return Collections.emptyList();
    }
    if (restaurant.size() < n) {
      return Collections.emptyList();
    }
    return restaurant.stream().map(l -> new Restaurant(l.get(0), l.get(1))).sorted()
        .collect(Collectors.toList()).subList(0, n).stream().map(r -> {
          List<Integer> list = new ArrayList<>();
          list.add(r.x);
          list.add(r.y);
          return list;
        }).collect(Collectors.toList());
    // Write your code here
  }

  public static class Restaurant implements Comparable<Restaurant> {

    int x;

    int y;

    public Restaurant(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int compareTo(Restaurant that) {
      if (that == null) {
        return 1;
      } else {
        return this.dist() - that.dist();
      }
    }

    public int dist() {
      return this.x * this.x + this.y + this.y;
    }

  }

}
