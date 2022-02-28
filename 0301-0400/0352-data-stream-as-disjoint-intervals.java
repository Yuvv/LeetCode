import java.util.*;


public class Solution {

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(1);      // arr = [1]
        summaryRanges.getIntervals(); // return [[1, 1]]
        summaryRanges.addNum(3);      // arr = [1, 3]
        summaryRanges.getIntervals(); // return [[1, 1], [3, 3]]
        summaryRanges.addNum(7);      // arr = [1, 3, 7]
        summaryRanges.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
        summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
        summaryRanges.getIntervals(); // return [[1, 3], [7, 7]]
        summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
        summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]
   }
}

/*
 * 0352-data-stream-as-disjoint-intervals.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/02/28
 */
class SummaryRanges {

    private final TreeSet<ClosedRange> treeSet;

    public SummaryRanges() {
        this.treeSet = new TreeSet<>();
    }

    public void addNum(int val) {
        ClosedRange range = new ClosedRange(val, val);
        ClosedRange floorRange = treeSet.floor(range);
        ClosedRange ceilingRange = treeSet.ceiling(range);
        if (floorRange == null && ceilingRange == null) {
            treeSet.add(range);
        } else if (floorRange == null) {
            // ceilingRange != null
            if (ceilingRange.getLower() - val > 1) {
                treeSet.add(range);
            } else if (ceilingRange.getLower() - val == 1) {
                ceilingRange.setLower(val);
            }
        } else if (ceilingRange == null) {
            // floorRange != null
            if (val - floorRange.getUpper() > 1) {
                treeSet.add(range);
            } else if (val - floorRange.getUpper() == 1) {
                floorRange.setUpper(val);
            }
        } else {
            if (floorRange.getLower() <= val && floorRange.getUpper() >= val) {
                return;
            }
            if (ceilingRange.getLower() <= val && ceilingRange.getUpper() >= val) {
                return;
            }
            boolean dealed = false;
            if (val - floorRange.getUpper() == 1) {
                floorRange.setUpper(val);
                dealed = true;
            }
            if (ceilingRange.getLower() - val == 1) {
                ceilingRange.setLower(val);
                dealed = true;
            }
            if (ceilingRange.getLower() - floorRange.getUpper() <= 1) {
                // merge
                floorRange.setUpper(ceilingRange.getUpper());
                treeSet.remove(ceilingRange);
                dealed = true;
            }
            if (!dealed) {
                treeSet.add(range);
            }
        }
    }

    public int[][] getIntervals() {
        int[][] res = new int[treeSet.size()][2];
        int i = 0;
        for (ClosedRange range : treeSet) {
            res[i++] = new int[] {range.getLower(), range.getUpper()};
        }
        return res;
    }
}

class ClosedRange implements Comparable<ClosedRange> {
    private Integer lower;
    private Integer upper;

    public ClosedRange(Integer lo, Integer up) {
        this.lower = lo;
        this.upper = up;
    }

    public Integer getLower() {
        return lower;
    }

    public Integer getUpper() {
        return upper;
    }

    public void setLower(Integer lo) {
        this.lower = lo;
    }

    public void setUpper(Integer up) {
        this.upper = up;
    }

    @Override
    public int hashCode() {
        return (lower + "," + upper).hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other instanceof ClosedRange) {
            return Objects.equals(((ClosedRange) other).lower, lower) && Objects.equals(((ClosedRange) other).upper, upper);
        }
        return false;
    }

    @Override
    public int compareTo(ClosedRange other) {
        return Comparator
                .comparingInt(ClosedRange::getLower)
                .thenComparingInt(ClosedRange::getUpper)
                .compare(this, other);
    }

    @Override
    public String toString() {
        return "[" + lower + ", " + upper + "]";
    }
}