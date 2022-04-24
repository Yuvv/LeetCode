/*
 * 1720-decode-xored-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/24
 */
public class Solution {
    public int[] decode(int[] encoded, int first) {
        int[] res = new int[encoded.length + 1];
        res[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            res[i + 1] = encoded[i] ^ res[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,0,2,1]
        System.out.println(java.util.Arrays.toString(s.decode(new int[] {1,2,3}, 1)));
        // [4,2,0,7,4]
        System.out.println(java.util.Arrays.toString(s.decode(new int[] {6,2,7,3}, 4)));
    }
}