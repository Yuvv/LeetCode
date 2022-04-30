import java.util.*;

/*
 * 1985-find-the-kth-largest-integer-in-the-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/30
 */
public class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (a.length() > b.length()) {
                return 1;
            } else if (a.length() < b.length()) {
                return -1;
            } else {
                return a.compareTo(b);
            }
        });
        for (String num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "3"
        System.out.println(s.kthLargestNumber(
            new String[] {"3", "6", "7", "10"}, 4
        ));
        // "2"
        System.out.println(s.kthLargestNumber(
            new String[] {"2", "21", "12", "1"}, 3
        ));
    }
}