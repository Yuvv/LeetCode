import java.util.*;

/*
 * 0380-insert-delete-getrandom-o1.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/10/21
 */
class RandomizedSet {

    private Map<Integer, Integer> map;
    private List<Integer> values;
    private Random random;

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.values = new ArrayList<>();
        this.random = new Random(System.currentTimeMillis());
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        map.put(val, values.size());
        values.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int idx = map.get(val);
        values.set(idx, values.get(values.size() - 1));
        map.put(values.get(idx), idx);
        map.remove(val);
        values.remove(values.size() - 1);
        return true;
    }

    public int getRandom() {
        int rnd = random.nextInt(values.size());
        return values.get(rnd);
    }

}

public class Solution {

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
        randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
        randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
        randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
        randomizedSet.insert(2); // 2 was already in the set, so return false.
        randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.

    }
}