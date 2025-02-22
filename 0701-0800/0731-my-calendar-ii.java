import java.util.Map;
import java.util.TreeMap;

/**
 * 0729-my-calendar-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/8/20
 */
public class MyCalendarTwo {
    private TreeMap<Integer, Integer> treeMap1;
    private TreeMap<Integer, Integer> treeMap2;

    public MyCalendarTwo() {
        this.treeMap1 = new TreeMap<>();
        this.treeMap2 = new TreeMap<>();
    }

    private boolean checkCross(TreeMap<Integer, Integer> tm, int start, int end) {
        if (tm.containsKey(start)) {
            return true;
        }
        Map.Entry<Integer, Integer> el = tm.lowerEntry(start);
        if (el != null) {
            if (el.getValue() > start) {
                return true;
            }
            if (start == el.getValue()) {
                start = el.getKey();
            }
        }
        Map.Entry<Integer, Integer> eh = tm.lowerEntry(end);
        if (eh != null && eh.getKey() > start) {
            if (eh.getKey() < end) {
                return true;
            }
        }
        return false;
    }

    private boolean book2(int start, int end) {
        if (start == end) {
            return false;
        }
        if (treeMap2.containsKey(start)) {
            return false;
        }
        Map.Entry<Integer, Integer> el = treeMap2.lowerEntry(start);
        if (el != null) {
            if (el.getValue() > start) {
                return false;
            }
            if (start == el.getValue()) {
                start = el.getKey();
            }
        }
        Map.Entry<Integer, Integer> eh = treeMap2.lowerEntry(end);
        if (eh != null && eh.getKey() > start) {
            if (eh.getKey() < end) {
                return false;
            }
            if (end == eh.getKey()) {
                treeMap2.remove(eh.getKey());
                end = eh.getValue();
            }
        }
        treeMap2.put(start, end);
        return true;
    }

    public boolean book(int start, int end) {
        if (checkCross(treeMap2, start, end)) {
            return false;
        }
        Map.Entry<Integer, Integer> el = treeMap1.lowerEntry(start);
        if (el != null && el.getValue() >= start) {
            treeMap1.remove(el.getKey());
            // book cross
            this.book2(Math.max(start, el.getKey()), Math.min(end, el.getValue()));
            start = Math.min(el.getKey(), start);
            end = Math.max(el.getValue(), end);
        }

        Map.Entry<Integer, Integer> eh = treeMap1.higherEntry(start - 1);
        while (eh != null && eh.getKey() <= end) {
            treeMap1.remove(eh.getKey());
            // book cross
            this.book2(Math.max(start, eh.getKey()), Math.min(end, eh.getValue()));
            // find next
            end = Math.max(end, eh.getValue());
            eh = treeMap1.higherEntry(start);
        }
        treeMap1.put(start, end);

        return true;
    }

    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        myCalendarTwo.book(10, 20); // return True, The event can be booked.
        myCalendarTwo.book(50, 60); // return True, The event can be booked.
        myCalendarTwo.book(10, 40); // return True, The event can be double booked.
        myCalendarTwo.book(5, 15);  // return False, The event cannot be booked, because it would result in a triple booking.
        myCalendarTwo.book(5, 10); // return True, The event can be booked, as it does not use time 10 which is already double booked.
        myCalendarTwo.book(25, 55); // return True, The event can be booked, as the time in [25, 40) will be double booked with the third event, the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
    }
}
