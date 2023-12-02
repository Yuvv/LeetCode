import java.util.*;

/**
 * 0981-time-based-key-value-store
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023-12-02
 */
public class TimeMap {

    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        this.map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> tm = this.map.get(key);
        if (tm == null) {
            return "";
        }
        Map.Entry<Integer, String> e = tm.lowerEntry(timestamp + 1);
        if (e == null) {
            return "";
        }
        return e.getValue();
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1.
        timeMap.get("foo", 1); // return "bar"
        timeMap.get("foo", 3); // return "bar", since there is no value corresponding to foo at timestamp 3 and
                               // timestamp 2, then the only value is at timestamp 1 is "bar".
        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
        timeMap.get("foo", 4); // return "bar2"
        timeMap.get("foo", 5); // return "bar2"
    }
}
