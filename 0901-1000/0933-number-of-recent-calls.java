import java.util.TreeSet;

/*
 * 0933-number-of-recent-calls.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/19
 */
public class RecentCounter {
    static final int MAX_TIME_RANGE = 3000;

    private TreeSet<Integer> treeSet;

    public RecentCounter() {
        treeSet = new TreeSet<>();
    }

    public int ping(int t) {
        treeSet.add(t);
        Integer last = treeSet.last();
        while (!treeSet.isEmpty() && last - treeSet.first() > MAX_TIME_RANGE) {
            treeSet.pollFirst();
        }
        return treeSet.size();
    }
}
