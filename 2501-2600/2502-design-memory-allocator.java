import java.util.*;

/*
 * 2502-design-memory-allocator.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/01/02
 */
public class Allocator {

    private TreeMap<Integer, Integer> mem; // begin -> end
    private Map<Integer, List<int[]>> alcMap;    // mID -> [begin, end]

    public Allocator(int n) {
        alcMap = new HashMap<>();
        mem = new TreeMap();
        mem.put(0, n-1);
    }

    public int allocate(int size, int mID) {
        int pos = -1;
        for (Map.Entry<Integer, Integer> entry : mem.entrySet()) {
            if (entry.getValue() - entry.getKey() + 1 >= size) {
                pos = entry.getKey();
                break;
            }
        }
        if (pos >= 0) {
            alcMap.computeIfAbsent(mID, k -> new ArrayList<>())
                    .add(new int[] {pos, pos + size - 1});
            int end = mem.get(pos);
            mem.remove(pos);
            int begin = pos + size;
            if (begin <= end) {
                mem.put(begin, end);
            }
            // merge alc
            Iterator<int[]> it = alcMap.get(mID).iterator();
            int[] pre = null;
            while (it.hasNext()) {
                int[] cur = it.next();
                if (pre != null && pre[1] + 1 == cur[0]) {
                    pre[1] = cur[1];
                    it.remove();
                } else {
                    pre = cur;
                }
            }
        }
        return pos;
    }

    public int free(int mID) {
        if (!alcMap.containsKey(mID)) {
            return 0;
        }
        int freeSize = 0;
        for (int[] range : alcMap.get(mID)) {
            freeSize += range[1] - range[0] + 1;

            Integer ceiling = mem.get(range[1]+1);
            if (ceiling != null) {
                mem.remove(range[1]+1);
                range[1] = ceiling;
            }
            Map.Entry<Integer, Integer> floorEntry = mem.floorEntry(range[0]-1);
            if (floorEntry != null && floorEntry.getValue() == range[0]-1) {
                mem.remove(floorEntry.getKey());
                range[0] = floorEntry.getKey();
            }

            mem.put(range[0], range[1]);
        }

        return freeSize;
    }

    public static void main(String[] args) {
        Allocator loc = new Allocator(10); // Initialize a memory array of size 10. All memory units are initially free.
        loc.allocate(1, 1); // The leftmost block's first index is 0. The memory array becomes [1,_,_,_,_,_,_,_,_,_]. We return 0.
        loc.allocate(1, 2); // The leftmost block's first index is 1. The memory array becomes [1,2,_,_,_,_,_,_,_,_]. We return 1.
        loc.allocate(1, 3); // The leftmost block's first index is 2. The memory array becomes [1,2,3,_,_,_,_,_,_,_]. We return 2.
        loc.free(2); // Free all memory units with mID 2. The memory array becomes [1,_, 3,_,_,_,_,_,_,_]. We return 1 since there is only 1 unit with mID 2.
        loc.allocate(3, 4); // The leftmost block's first index is 3. The memory array becomes [1,_,3,4,4,4,_,_,_,_]. We return 3.
        loc.allocate(1, 1); // The leftmost block's first index is 1. The memory array becomes [1,1,3,4,4,4,_,_,_,_]. We return 1.
        loc.allocate(1, 1); // The leftmost block's first index is 6. The memory array becomes [1,1,3,4,4,4,1,_,_,_]. We return 6.
        loc.free(1); // Free all memory units with mID 1. The memory array becomes [_,_,3,4,4,4,_,_,_,_]. We return 3 since there are 3 units with mID 1.
        loc.allocate(10, 2); // We can not find any free block with 10 consecutive free memory units, so we return -1.
        loc.free(7); // Free all memory units with mID 7. The memory array remains the same since there is no memory unit with mID 7. We return 0.
    }
}
