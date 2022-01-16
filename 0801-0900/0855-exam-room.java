import java.util.*;

/*
 * 0855-exam-room.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/16
 */
class ExamRoom {

    private final int count;
    private final TreeSet<Integer> seats;
    private final TreeMap<Integer, TreeSet<Range>> lenMap;

    public ExamRoom(int n) {
        this.count = n;
        this.seats = new TreeSet<>();
        this.lenMap = new TreeMap<>();
    }

    public int seat() {
        if (seats.isEmpty()) {
            seats.add(0);
            lenMap.computeIfAbsent(count - 1, k -> new TreeSet<>()).add(new Range(1, count - 1));
            return 0;
        }
        Map.Entry<Integer, TreeSet<Range>> lastEntry = lenMap.lastEntry();
        Range candidateRange = lastEntry.getValue().pollFirst();
        if (lastEntry.getValue().isEmpty()) {
            lenMap.remove(lastEntry.getKey());
        }
        int candidate = (candidateRange .low + candidateRange .high) / 2;
        if (this.seats.floor(candidate) == null) {
            candidate = candidateRange .low;

            candidateRange.low = candidate + 1;
            int len = candidateRange.getLen(count);
            if (len > 0) {
                lenMap.computeIfAbsent(len, k -> new TreeSet<>()).add(candidateRange);
            }
        } else if (this.seats.ceiling(candidate) == null) {
            candidate = candidateRange.high;

            candidateRange.high = candidate - 1;
            int len = candidateRange.getLen(count);
            if (len > 0) {
                lenMap.computeIfAbsent(len, k -> new TreeSet<>()).add(candidateRange);
            }
        } else {
            Range nRange = new Range(candidateRange.low, candidate - 1);
            int len = nRange.getLen(count);
            if (len > 0) {
                lenMap.computeIfAbsent(len, k -> new TreeSet<>()).add(nRange);
            }

            candidateRange.low = candidate + 1;
            len = candidateRange.getLen(count);
            if (len > 0) {
                lenMap.computeIfAbsent(len, k -> new TreeSet<>()).add(candidateRange);
            }
        }
        this.seats.add(candidate);
        return candidate;
    }

    private void removeRange(int low, int high) {
        Range lr = new Range(low, high);
        int len = lr.getLen(count);
        if (len > 0) {
            TreeSet<Range> rangeSet = lenMap.get(len);
            rangeSet.remove(lr);
            if (rangeSet.isEmpty()) {
                lenMap.remove(len);
            }
        }
    }

    public void leave(int p) {
        seats.remove(p);
        if (seats.isEmpty()) {
            lenMap.clear();
            return;
        }
        int low = Optional.ofNullable(seats.floor(p)).orElse(-1);
        int high = Optional.ofNullable(seats.ceiling(p)).orElse(count);

        // left range
        removeRange(low + 1, p - 1);
        // right range
        removeRange(p + 1, high - 1);

        // add new range
        Range nr = new Range(low + 1, high - 1);
        lenMap.computeIfAbsent(nr.getLen(count), k -> new TreeSet<>()).add(nr);
    }
}

class Range implements Comparable<Range> {
    int low;
    int high;

    public Range(int low, int high) {
        this.low = low;
        this.high = high;
    }

    public int getLen(int count) {
        if (high < low) {
            return 0;
        }
        if (low == 0 || high == count - 1) {
            return high - low + 1;
        }
        return (high - low) / 2 + 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Range tuple2 = (Range) o;
        return Objects.equals(low, tuple2.low) && Objects.equals(high, tuple2.high);
    }

    @Override
    public int hashCode() {
        return Objects.hash(low, high);
    }

    @Override
    public int compareTo(Range o) {
        int r = low - o.low;
        if (r == 0) {
            r = high - o.high;
        }
        return r;
    }
}


public class Solution {
    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom(10);
        System.out.println(examRoom.seat()); // return 0, no one is in the room, then the student sits at seat number 0.
        System.out.println(examRoom.seat()); // return 9, the student sits at the last seat number 9.
        System.out.println(examRoom.seat()); // return 4, the student sits at the last seat number 4.
        System.out.println(examRoom.seat()); // return 2, the student sits at the last seat number 2.
        examRoom.leave(4);
        System.out.println(examRoom.seat()); // return 5, the student sits at the last seat number 5.
    }
}