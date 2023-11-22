import java.util.*;

/**
 * 1845-seat-reservation-manager
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/11/22
 */
public class SeatManager {

    private TreeMap<Integer, Integer> treeMap;

    public SeatManager(int n) {
        this.treeMap = new TreeMap<>();
        this.treeMap.put(1, n);
    }

    public int reserve() {
        if (treeMap.isEmpty()) {
            return 0;
        }
        Map.Entry<Integer, Integer> entry = treeMap.pollFirstEntry();
        if (entry.getKey() < entry.getValue()) {
            treeMap.put(entry.getKey() + 1, entry.getValue());
        }
        return entry.getKey();
    }

    public void unreserve(int seatNumber) {
        Map.Entry<Integer, Integer> le = treeMap.lowerEntry(seatNumber);
        Map.Entry<Integer, Integer> he = treeMap.higherEntry(seatNumber);
        if (le == null || le.getValue() - 1 != seatNumber) { // no need merge `le`
            if (he == null || he.getKey() - 1 != seatNumber) { // no need merge `he`
                treeMap.put(seatNumber, seatNumber);
                return;
            } else { // merge to `he`
                treeMap.remove(he.getKey());
                treeMap.put(seatNumber, he.getValue());
            }
        } else { // merge to `le`
            treeMap.put(le.getKey(), seatNumber);
            if (he != null && he.getKey() - 1 == seatNumber) { // merge `le`+seatNumber+`he`
                treeMap.remove(he.getKey());
                treeMap.put(le.getKey(), he.getValue());
            }
        }
    }

    public static void main(String[] args) {
        SeatManager sm = new SeatManager(5);
        System.out.println(sm.reserve()); // 1
        System.out.println(sm.reserve()); // 2
        sm.unreserve(2);
        System.out.println(sm.reserve()); // 2
        System.out.println(sm.reserve()); // 3
        System.out.println(sm.reserve()); // 4
        System.out.println(sm.reserve()); // 5
        sm.unreserve(5);
    }
}
