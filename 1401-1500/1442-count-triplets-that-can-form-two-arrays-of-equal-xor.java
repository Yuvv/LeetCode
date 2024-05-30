/**
 * 1442-count-triplets-that-can-form-two-arrays-of-equal-xor.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/05/30
 */
public class Solution {
    public int countTriplets(int[] arr) {
        int[] prefixxor = new int[arr.length];
        int x = 0;
        for (int i = 0; i < arr.length; i++) {
            x ^= arr[i];
            prefixxor[i] = x;
        }
        int cnt = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (i == 0) {
                    if (prefixxor[j] == 0) {
                        cnt += j;
                    }
                } else if ( (prefixxor[j] ^ prefixxor[i-1]) == 0) {
                    cnt += j - i;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.countTriplets(new int[]{2,3,1,6,7}));
        // 10
        System.out.println(s.countTriplets(new int[]{1,1,1,1,1}));
    }
}