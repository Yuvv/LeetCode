import java.util.*;

/*
 * 0381-insert-delete-getrandom-o1-duplicates-allowed.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/10/21
 */
class RandomizedCollection {

    private Map<Integer, Set<Integer>> map;
    private List<Integer> values;
    private Random random;

    public RandomizedCollection() {
        this.map = new HashMap<>();
        this.values = new ArrayList<>();
        this.random = new Random(System.currentTimeMillis());
    }

    public boolean insert(int val) {
        boolean res = !map.containsKey(val);

        map.computeIfAbsent(val, k -> new HashSet<>()).add(values.size());
        values.add(val);
        return res;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        Set<Integer> idxSet1 = map.get(val);
        Set<Integer> idxSet2 = map.get(values.get(values.size() - 1));
        if (idxSet1.equals(idxSet2)) {
            idxSet1.remove(values.size() - 1);
            values.remove(values.size() - 1);
        } else {
            int idx = idxSet1.iterator().next();
            values.set(idx, values.get(values.size() - 1));
            idxSet1.remove(idx);
            idxSet2.remove(values.size() - 1);
            idxSet2.add(idx);
            values.remove(values.size() - 1);
        }
        if (idxSet1.isEmpty()) {
            map.remove(val);
        }
        return true;
    }

    public int getRandom() {
        int rnd = random.nextInt(values.size());
        return values.get(rnd);
    }
}


public class Solution {
    public static void main(String[] args) {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        randomizedCollection.insert(1);   // return True. Inserts 1 to the collection. Returns true as the collection did not contain 1.
        randomizedCollection.insert(1);   // return False. Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
        randomizedCollection.insert(2);   // return True. Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
        randomizedCollection.getRandom(); // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
        randomizedCollection.remove(1);   // return True. Removes 1 from the collection, returns true. Collection now contains [1,2].
        randomizedCollection.getRandom(); // getRandom should return 1 and 2 both equally likely.
    }
}