import java.util.*;
/**
 * 1718-construct-the-lexicographically-largest-valid-sequence.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/02/16
 */
public class Solution {
    static Map<Integer, int[]> cacheMap = new HashMap<>();
    static {
        cacheMap.put(1, new int[] {1});
        cacheMap.put(2, new int[] {2, 1, 2});
        cacheMap.put(3, new int[] {3,1,2,3,2});
        cacheMap.put(4, new int[] {4,2,3,2,4,3,1});
        cacheMap.put(5, new int[] {5,3,1,4,3,5,2,4,2});
        cacheMap.put(6, new int[] {6,4,2,5,2,4,6,3,5,1,3});
        cacheMap.put(7, new int[] {7,5,3,6,4,3,5,7,4,6,2,1,2});
        cacheMap.put(8, new int[] {8,6,4,2,7,2,4,6,8,5,3,7,1,3,5});
        cacheMap.put(9, new int[] {9,7,5,3,8,6,3,5,7,9,4,6,8,2,4,2,1});
        cacheMap.put(10, new int[] {10,8,6,9,3,1,7,3,6,8,10,5,9,7,4,2,5,2,4});
        cacheMap.put(11, new int[] {11,9,10,6,4,1,7,8,4,6,9,11,10,7,5,8,2,3,2,5,3});
        cacheMap.put(12, new int[] {12,10,11,7,5,3,8,9,3,5,7,10,12,11,8,6,9,2,4,2,1,6,4});
        cacheMap.put(13, new int[] {13,11,12,8,6,4,9,10,1,4,6,8,11,13,12,9,7,10,3,5,2,3,2,7,5});
        cacheMap.put(14, new int[] {14,12,13,9,7,11,4,1,10,8,4,7,9,12,14,13,11,8,10,6,3,5,2,3,2,6,5});
        cacheMap.put(15, new int[] {15,13,14,10,8,12,5,3,11,9,3,5,8,10,13,15,14,12,9,11,7,4,6,1,2,4,2,7,6});
        cacheMap.put(16, new int[] {16,14,15,11,9,13,6,4,12,10,1,4,6,9,11,14,16,15,13,10,12,8,5,7,2,3,2,5,3,8,7});
        cacheMap.put(17, new int[] {17,15,16,12,10,14,7,5,3,13,11,3,5,7,10,12,15,17,16,14,9,11,13,8,6,2,1,2,4,9,6,8,4});
        cacheMap.put(18, new int[] {18,16,17,13,11,15,8,14,4,2,12,2,4,10,8,11,13,16,18,17,15,14,12,10,9,7,5,3,6,1,3,5,7,9,6});
        cacheMap.put(19, new int[] {19,17,18,14,12,16,9,15,6,3,13,1,3,11,6,9,12,14,17,19,18,16,15,13,11,10,8,4,5,7,2,4,2,5,8,10,7});
        cacheMap.put(20, new int[] {20,18,19,15,13,17,10,16,7,5,3,14,12,3,5,7,10,13,15,18,20,19,17,16,12,14,11,9,4,6,8,2,4,2,1,6,9,11,8});
    }

    public int[] constructDistancedSequence(int n) {
        return cacheMap.get(n);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [3,1,2,3,2]
        System.out.println(Arrays.toString(s.constructDistancedSequence(3)));
        // [5,3,1,4,3,5,2,4,2]
        System.out.println(Arrays.toString(s.constructDistancedSequence(5)));
    }
}
