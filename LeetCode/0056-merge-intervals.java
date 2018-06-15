/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort((o1, o2) -> {
            return o1.start - o2.start;
        });
        if (intervals.size() < 2) {
            return intervals;
        }
        
        List<Interval> list = new ArrayList<>();

        for (int i = 1; i < intervals.size(); i++) {
            Interval i1 = intervals.get(i - 1);
            Interval i2 = intervals.get(i);
            if (i2.start <= i1.end) {
                i2.start = i1.start;
                if (i2.end < i1.end) {
                    i2.end = i1.end;
                }
            } else {
                list.add(i1);
            }
            
            if (i == intervals.size() - 1) {
                list.add(i2);
            }
        }
        
        return list;
    }
}