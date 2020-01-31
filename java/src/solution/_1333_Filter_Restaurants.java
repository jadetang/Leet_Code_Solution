package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _1333_Filter_Restaurants {

    public static class Restaurant {
        int id;
        int vegan;
        int price;
        int distance;
        int rating;

        public Restaurant(int id, int rating, int vegan, int price, int distance) {
            this.id = id;
            this.rating = rating;
            this.vegan = vegan;
            this.price = price;
            this.distance = distance;
        }
    }


    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Restaurant> restaurantList = new ArrayList<>();
        for (int[] r : restaurants) {
            restaurantList.add(new Restaurant(r[0], r[1], r[2], r[3], r[4]));
        }
        return restaurantList.stream().filter(r -> {
                    return r.vegan == veganFriendly && r.price <= maxPrice && r.distance <= maxDistance;
                }
        ).sorted( (r1, r2) -> {
            if (r1.rating == r2.rating) {
                return r2.id - r1.id;
            }else {
                return r2.rating - r1.rating;
            }
        }).map( r -> r.id).collect(Collectors.toList());
    }

}
