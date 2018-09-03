package company.booking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jade on 2017/7/8 下午7:16
 */
public class Sorting {


  public static class User {

    private String name;
  }

  public static void main(String[] args) {
    List<User> users = new LinkedList<>();
    users.add(new User());
    users.add(new User());
    users.add(new User());

    Arrays.sort(users.toArray(new User[]{}));


  }


}
