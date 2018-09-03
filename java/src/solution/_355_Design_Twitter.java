package solution;

import java.util.*;

/**
 * @author jade on 16/7/13 下午9:27
 */
public class _355_Design_Twitter {


  public static class Twitter {

    public static Integer COUNT = 0;

    private static class Tweet implements Comparable<Tweet> {

      private Integer userId;

      private Integer id;

      private Integer cnt;

      @Override
      public int compareTo(Tweet o) {
        return o.cnt.compareTo(this.cnt);
      }

      public Tweet(Integer userId, Integer id) {
        this.userId = userId;
        this.id = id;
        this.cnt = COUNT++;
      }
    }

    private Map<Integer, LinkedList<Integer>> user = new HashMap<>();
    private Map<Integer, LinkedList<Tweet>> tweets = new HashMap<>();


    /**
     * Initialize your data structure here.
     */
    public Twitter() {

    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
      if (tweets.containsKey(userId)) {
        tweets.get(userId).add(new Tweet(userId, tweetId));
      } else {
        LinkedList<Tweet> tweet = new LinkedList<>();
        tweet.add(new Tweet(userId, tweetId));
        tweets.put(userId, tweet);
      }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed
     * must be posted by users who the user followed or by the user herself. Tweets must be ordered
     * from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
      PriorityQueue<Tweet> queue = new PriorityQueue<>(Tweet::compareTo);
      if (tweets.get(userId) != null) {
        queue.addAll(tweets.get(userId));
      }
      LinkedList<Integer> followees = user.get(userId);
      if (followees != null) {
        for (Integer followee : followees) {
          if (tweets.get(followee) != null) {
            queue.addAll(tweets.get(followee));
          }
        }
      }
      List<Integer> result = new LinkedList<>();
      while (result.size() < 10 && !queue.isEmpty()) {
        result.add(queue.poll().id);
      }
      return result;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
      if (followeeId == followerId) {
        return;
      }
      if (user.get(followerId) != null) {
        if (!user.get(followerId).contains(followeeId)) {
          user.get(followerId).add(followeeId);
        }
      } else {
        LinkedList<Integer> followee = new LinkedList<>();
        followee.add(followeeId);
        user.put(followerId, followee);
      }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
      if (followerId == followeeId) {
        return;
      }
      if (user.get(followerId) != null) {
        user.get(followerId).remove((Object) followeeId);
      }
    }


  }

  public static void main(String[] args) {
    Twitter t = new Twitter();
    t.postTweet(1, 5);
    t.getNewsFeed(1);
    t.follow(1, 2);
    t.postTweet(2, 6);
    t.getNewsFeed(1);
    t.unfollow(1, 2);
    t.getNewsFeed(1);
  }

}
