import java.util.Set;
import java.util.HashSet;


/*
 * 0128-longest-consecutive-sequence.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/06/07
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		Set<Integer> set = new HashSet<>(nums.length);
		for (int num : nums) {
			set.add(num);
		}
		// check
		int maxCount = 1;
		for (int num : nums) {
			// 当不包含 num-1 时才开始循环检测（此时可能是一段区间的起始位置）
			if (!set.contains(num - 1)) {
				int count = 0;
				while (set.contains(num)) {
					count++;
					num++;
				}
				if (count > maxCount) {
					maxCount = count;
				}
			}
		}
		return maxCount;
    }

	public static void main(String[] args) {
		Solution s = new Solution();

		// 4
		System.out.println(s.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
		// 9
		System.out.println(s.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
	}
}

