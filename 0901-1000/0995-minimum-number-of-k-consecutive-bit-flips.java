import java.util.Scanner;
/*
 * 0995-minimum-number-of-k-consecutive-bit-flips.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/02
 */
public class Solution {
    // 1 <= nums.length <= 10^5 && 1 <= k <= nums.length
    public int minKBitFlips_tle(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length && nums[i] == 1) {
                i++;
            }
            if (i >= nums.length) {
                return count;
            }
            if (i + k > nums.length) {
                return -1;
            }
            for (int j = i; j < i + k; j++) {
                nums[j] = 1 - nums[j];
            }
            count++;
        }
        return count;
    }

    public int minKBitFlips(int[] nums, int k) {
        // just record right-most modified index,
        // and every number flip times equals list.size
        LinkedList<Integer> rightIndexList = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (((rightIndexList.size() % 2) ^ nums[i]) == 0) {
                int rangeEnd = i + k - 1;
                if (rangeEnd >= nums.length) {
                    return -1;
                }
                count++;
                rightIndexList.add(rangeEnd);
            }
            if (rightIndexList.size() > 0 && i == rightIndexList.peekFirst()) {
                rightIndexList.pollFirst();
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.minKBitFlips(new int[] {0,1,0}, 1));
        // -1
        System.out.println(s.minKBitFlips(new int[] {1,1,0}, 2));
        // 3
        System.out.println(s.minKBitFlips(new int[] {0,0,0,1,0,1,1,0}, 3));

        // a
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        String[] arrStr = line.substring(1, line.length() - 1).split(",");
        int[] nums = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            nums[i] = Integer.parseInt(arrStr[i]);
        }
        int k = scanner.nextInt();
    }
}