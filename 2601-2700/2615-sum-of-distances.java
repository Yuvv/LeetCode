import java.util.*;

/**
 * 2615-sum-of-distances.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/03/25
 */
public class Solution {
    public long[] distance(int[] nums) {
        Map<Integer, List<Entry>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Entry> list = map.computeIfAbsent(nums[i], k -> {
                List<Entry> l = new ArrayList<>();
                l.add(new Entry(-1, 0));
                return l;
            });
            list.add(new Entry(i, list.get(list.size()-1).prefixSum+i));
        }
        long[] resArr = new long[nums.length];
        for (List<Entry> elist : map.values()) {
            for (int i = 1; i < elist.size(); i++) {
                Entry e = elist.get(i);
                // f(x) = P(n) - P(x) - a(x)*(n-x) + a(x)*(x-1) - P(x-1)
                resArr[e.index] = elist.get(elist.size()-1).prefixSum - e.prefixSum
                       + (long)(e.index) * (i - 1 + i - elist.size()+1)
                       - elist.get(i-1).prefixSum;
            }
        }
        return resArr;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [5,0,3,4,0]
        System.out.println(Arrays.toString(s.distance(new int[]{1,3,1,1,2})));
        // [0,0,0]
        System.out.println(Arrays.toString(s.distance(new int[]{0,5,3})));
    }
}

class Entry {
    int index;
    long prefixSum;
    public Entry(int idx, long sum) {
        this.index = idx;
        this.prefixSum = sum;
    }
}