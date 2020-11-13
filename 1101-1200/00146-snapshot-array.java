import java.util.*;
import java.utul.concurrent.*;

/*
 * 00146-snapshot-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2020/11/13
 */


class SnapshotArray {

    /**
     * index -> snapId -> value
     *
     * 仅记录每个快照（版本）变化的值，当获取时，按照快照号查找，找不到就找上一个快照的，递归到第一个肯定有值
     */
    private final Map<Integer, Map<Integer, Integer>> snapMap;
    private final AtomicInteger snapIdGenerator;

    public SnapshotArray(int length) {
        this.snapMap = new ConcurrentHashMap<>(length);
        this.snapIdGenerator = new AtomicInteger(0);
        for (int i = 0; i < length; i++) {
            Map<Integer, Integer> innerSnapMap = new HashMap<>();
            innerSnapMap.put(0, 0);
            snapMap.put(i, innerSnapMap);
        }
    }

    public void set(int index, int val) {
        int curSnapId = snapIdGenerator.get();
        snapMap.get(index).put(curSnapId, val);
    }

    public int snap() {
        return snapIdGenerator.getAndIncrement();
    }

    public int get(int index, int snapId) {
        Map<Integer, Integer> innerSnapMap = snapMap.get(index);
        while (snapId > 0) {
            if (innerSnapMap.containsKey(snapId)) {
                return innerSnapMap.get(snapId);
            }
            snapId--;
        }
        return innerSnapMap.get(snapId);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */