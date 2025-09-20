import java.util.*;
/**
 * 3508-implement-router.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/09/20
 */
public
class Router {

    private int[][] packets;
    private int beg;
    private int end;
    private Map<Integer, RouterDst> map;

    public Router(int memoryLimit) {
        this.packets = new int[memoryLimit][];
        this.beg = 0; // the first entry
        this.end = 0; // next index to store entry
        this.map = new HashMap<>(memoryLimit); // dst -> RouterDst
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        // check if duplicated
        RouterDst dst = map.get(destination);
        if (dst != null) {
            Object[] objs = dst.map.get(timestamp);
            if (objs != null) {
                if (((Set<Integer>) objs[2]).contains(source)) {
                    return false;
                }
            }
        }
        // add current
        if (beg == end) {
            if (packets[beg] != null) { // remove exists
                int[] entry = packets[beg];
                dst = map.get(entry[1]);
                dst.removeFirst(entry[2], entry[0]);
                // move beg to next
                beg = (beg + 1) % packets.length;
            }
        }
        // store to end
        if (packets[end] != null) {
            packets[end][0] = source;
            packets[end][1] = destination;
            packets[end][2] = timestamp;
        } else {
            packets[end] = new int[]{source, destination, timestamp};
        }
        // add current to map
        map.computeIfAbsent(destination, RouterDst::new)
                .add(timestamp, source);
        // move end to next
        end = (end + 1) % packets.length;

        return true;
    }

    public int[] forwardPacket() {
        if (beg == end && packets[beg] == null) {
            return new int[]{};
        }
        if (packets[beg] == null) {
            return new int[]{};
        }
        int[] entry = packets[beg];
        packets[beg] = null; // reset entry
        beg = (beg + 1) % packets.length;
        // remove fron map
        RouterDst dst = map.get(entry[1]);
        dst.removeFirst(entry[2], entry[0]);
        return entry;
    }

    public int getCount(int destination, int startTime, int endTime) {
        RouterDst dst = map.get(destination);
        if (dst == null) {
            return 0;
        }
        Map.Entry<Integer, Object[]> b = dst.map.ceilingEntry(startTime);
        Map.Entry<Integer, Object[]> e = dst.map.floorEntry(endTime);
        if (b == null || e == null) {
            return 0;
        }
        int seqB = ((RouterListNode) b.getValue()[0]).seq;
        int seqE = ((RouterListNode) e.getValue()[1]).seq;
        return seqE - seqB + 1;
    }


    public static void main(String[] args) {
        Router obj = new Router(3);
        // true
        System.out.println(obj.addPacket(1, 4, 90));
        // true
        System.out.println(obj.addPacket(2, 5, 90));
        // false
        System.out.println(obj.addPacket(1, 4, 90));
        // true
        System.out.println(obj.addPacket(3, 5, 95));
        // true
        System.out.println(obj.addPacket(4, 5, 105));

        int[] fwd = obj.forwardPacket();
        // [2,5,90]
        System.out.println(Arrays.toString(fwd));
        // true
        System.out.println(obj.addPacket(5, 2, 110));
        // 1
        System.out.println(obj.getCount(5, 100, 110));


        Router obj1 = new Router(4);
        // true
        System.out.println(obj1.addPacket(4, 2, 1));
        // true
        System.out.println(obj1.addPacket(3, 2, 1));
        // 2
        System.out.println(obj1.getCount(2, 1, 1));
    }

}

class RouterDst {
    int seq;
    int dst;
    TreeMap<Integer, Object[]> map;  // ts->[first, last, Set[src]]
    RouterListNode head, tail;

    public RouterDst(int dst) {
        this.seq = 0;
        this.dst = dst;
        this.map = new TreeMap<>();
    }

    private int nextSeq() {
        seq++;
        return seq;
    }

    public void add(int ts, int src) {
        Object[] objs = map.computeIfAbsent(ts, k -> new Object[]{null, null, new HashSet<>()});
        ((Set<Integer>) objs[2]).add(src);
        if (head == null) {
            head = new RouterListNode(ts, this.nextSeq());
            tail = head;
        } else {
            tail.next = new RouterListNode(ts, this.nextSeq());
            tail = tail.next;
        }
        if (objs[0] == null) {
            objs[0] = tail;
        }
        objs[1] = tail;
        map.put(ts, objs);
    }

    public void removeFirst(int ts, int src) {
        if (head == null) {
            return;
        }
        RouterListNode node = head;
        head = head.next;
        if (head == null || head.ts != node.ts) {
            map.remove(node.ts);
        } else {
            Object[] objs = map.get(node.ts);
            objs[0] = head;
            ((Set<Integer>) objs[2]).remove(src);
        }
    }
}

class RouterListNode {
    int ts;
    int seq;
    RouterListNode next;

    public RouterListNode(int ts, int seq) {
        this.ts = ts;
        this.seq = seq;
    }
}