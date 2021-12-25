import java.util.*;

class AllOne {

    private Map<String, Integer> countMap;
    private TreeMap<Integer, Set<String>> strMap;

    public AllOne() {
        countMap = new HashMap<>();
        strMap = new TreeMap<>();
    }

    public void inc(String key) {
        int originCnt = countMap.getOrDefault(key, 0);
        int newCnt = originCnt + 1;
        if (strMap.containsKey(originCnt)) {
            Set<String> set = strMap.get(originCnt);
            set.remove(key);
            if (set.isEmpty()) {
                strMap.remove(originCnt);
            }
        }
        strMap.computeIfAbsent(newCnt, k -> new HashSet<>()).add(key);
        countMap.put(key, newCnt);
    }

    public void dec(String key) {
        if (!countMap.containsKey(key)) {
            return;
        }
        int originCnt = countMap.get(key);
        int newCnt = originCnt - 1;
        if (strMap.containsKey(originCnt)) {
            Set<String> set = strMap.get(originCnt);
            set.remove(key);
            if (set.isEmpty()) {
                strMap.remove(originCnt);
            }
        }
        if (newCnt == 0) {
            countMap.remove(key);
        } else {
            strMap.computeIfAbsent(newCnt, k -> new HashSet<>()).add(key);
            countMap.put(key, newCnt);
        }
    }

    public String getMaxKey() {
        if (strMap.isEmpty()) {
            return "";
        }
        Map.Entry<Integer, Set<String>> lastEntry = strMap.lastEntry();
        return lastEntry.getValue().iterator().next();
    }

    public String getMinKey() {
        if (strMap.isEmpty()) {
            return "";
        }
        Map.Entry<Integer, Set<String>> firstEntry = strMap.firstEntry();
        return firstEntry.getValue().iterator().next();
    }
}

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("hello");
        System.out.println(allOne.getMaxKey()); // return "hello"
        System.out.println(allOne.getMinKey()); // return "hello"
        allOne.inc("leet");
        System.out.println(allOne.getMaxKey()); // return "hello"
        System.out.println(allOne.getMinKey()); // return "leet"
    }
}