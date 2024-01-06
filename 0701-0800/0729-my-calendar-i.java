import java.util.Map;
import java.util.TreeMap;

/**
 * 0729-my-calendar-i
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/1/6
 */
public class MyCalendar {
    private TreeMap<Integer, Integer> treeMap;

    public MyCalendar() {
        this.treeMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if (treeMap.containsKey(start)) {
            return false;
        }
        Map.Entry<Integer, Integer> el = treeMap.lowerEntry(start);
        if (el != null) {
            if (el.getValue() > start) {
                return false;
            }
            if (start == el.getValue()) {
                start = el.getKey();
            }
        }
        Map.Entry<Integer, Integer> eh = treeMap.lowerEntry(end);
        if (eh != null && eh.getKey() > start) {
            if (eh.getKey() < end) {
                return false;
            }
            if (end == eh.getKey()) {
                treeMap.remove(eh.getKey());
                end = eh.getValue();
            }
        }
        treeMap.put(start, end); 
        return true;
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        myCalendar.book(10, 20); // return True
        myCalendar.book(15, 25); // return False, It can not be booked because time 15 is already booked by
                                 // another event.
        myCalendar.book(20, 30); // return True, The event can be booked, as the first event takes every time
                                 // less than 20, but not including 20.
    }
}
