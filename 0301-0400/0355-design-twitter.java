import java.util.*;

/*
 * 0355-design-twitter.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/07
 */
public class Twitter {
    /**
     * follower -> followee
     */
    private Map<Integer, Set<Integer>> followerMap;

    /**
     * user feeds
     */
    private Map<Integer, LinkedList<Integer>> userFeedMap;

    /**
     * tweetId -> auto increment id
     */
    private Map<Integer, Integer> tweetIdMap;

    private int tweetIdCount;

    public Twitter() {
        this.followerMap = new HashMap<>();
        this.userFeedMap = new HashMap<>();
        this.tweetIdMap = new HashMap<>();
        this.tweetIdCount = 0;
    }

    public void postTweet(int userId, int tweetId) {
        LinkedList<Integer> feeds = this.userFeedMap.computeIfAbsent(userId, k -> new LinkedList<>());
        feeds.addFirst(tweetId);
        if (feeds.size() > 10) {
            feeds.removeLast();
        }
        tweetIdMap.put(tweetId, tweetIdCount++);
    }

    public List<Integer> getNewsFeed(int userId) {
        TreeSet<Integer> set = new TreeSet<>(Comparator.comparing(e -> tweetIdMap.getOrDefault(e, 0)).reversed());
        for (Integer followeeId : followerMap.getOrDefault(userId, new HashSet<>(0))) {
            set.addAll(userFeedMap.getOrDefault(followeeId, new LinkedList<>()));
        }
        set.addAll(userFeedMap.getOrDefault(userId, new LinkedList<>()));
        return set.stream().limit(10).collect(Collectors.toList());
    }

    public void follow(int followerId, int followeeId) {
        this.followerMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        this.followerMap.computeIfAbsent(followerId, k -> new HashSet<>()).remove(followeeId);
    }
}
}