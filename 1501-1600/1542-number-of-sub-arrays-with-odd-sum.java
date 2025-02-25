/**
 * 1542-number-of-sub-arrays-with-odd-sum.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/02/25
 */
public class Solution {
    // let arr = e0..o1..e2..o3..e4..o5..e6...en..on
    // then dp(i) = dp(i-2) + ei+1
    public int numOfSubarrays(int[] arr) {
        int oddCnt = 0;
        int curEvenCnt = 0;
        long res = 0L;
        List<Integer> dp = new ArrayList<>(arr.length/2);
        dp.add(0);
        dp.add(0);
        for (int i = 0; i < arr.length; i++) {
            int val;
            if (arr[i]%2==0) {
                val = dp.get(dp.size()-1);
                curEvenCnt++;
            } else {
                val = dp.get(dp.size()-2) + curEvenCnt + 1;
                dp.add(val);
                curEvenCnt = 0;
            }
            res = (res + val) % 1000000007;
        }
        return (int)(res);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.numOfSubarrays(new int[]{1,3,5}));
        // 0
        System.out.println(s.numOfSubarrays(new int[]{2,4,6}));
        // 16
        System.out.println(s.numOfSubarrays(new int[]{1,2,3,4,5,6,7}));
    }
}
