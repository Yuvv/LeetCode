import java.util.Map;
import java.util.HashMap;

/*
 * 1865-finding-pairs-with-a-certain-sum.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/10/10
 */
public class FindSumPairs {
    private Map<Integer, Integer> nums1Map;
    private Map<Integer, Integer> nums2Map;
    private int[] nums2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        nums1Map = new HashMap<>();
        for (int num : nums1) {
            nums1Map.put(num, nums1Map.getOrDefault(num, 0) + 1);
        }
        nums2Map = new HashMap<>();
        for (int num : nums2) {
            nums2Map.put(num, nums2Map.getOrDefault(num, 0) + 1);
        }
        this.nums2 = nums2;
    }

    public void add(int index, int val) {
        int num2 = nums2[index];
        nums2[index] += val;
        nums2Map.put(nums2[index], nums2Map.getOrDefault(nums2[index], 0) + 1);
        nums2Map.put(num2, nums2Map.getOrDefault(num2, 0) - 1);
    }

    public int count(int tot) {
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : nums1Map.entrySet()) {
            int other = tot - entry.getKey();
            if (nums2Map.containsKey(other)) {
                res += entry.getValue() * nums2Map.get(other);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindSumPairs findSumPairs = new FindSumPairs(new int[]{1, 1, 2, 2, 2, 3}, new int[]{1, 4, 5, 2, 5, 4});
        // return 8; pairs (2,2), (3,2), (4,2), (2,4), (3,4), (4,4) make 2 + 5 and pairs (5,1), (5,5) make 3 + 4
        System.out.println(findSumPairs.count(7));
        findSumPairs.add(3, 2); // now nums2 = [1,4,5,4,5,4]
        // return 2; pairs (5,2), (5,4) make 3 + 5
        System.out.println(findSumPairs.count(8));
        // return 1; pair (5,0) makes 3 + 1
        System.out.println(findSumPairs.count(4));
        findSumPairs.add(0, 1); // now nums2 = [2,4,5,4,5,4]
        findSumPairs.add(1, 1); // now nums2 = [2,5,5,4,5,4]
        // return 11; pairs (2,1), (2,2), (2,4), (3,1), (3,2), (3,4), (4,1), (4,2), (4,4) make 2 + 5 and pairs (5,3), (5,5) make 3 + 4
        System.out.println(findSumPairs.count(7));
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */