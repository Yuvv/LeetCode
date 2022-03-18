import java.util.Arrays;

/*
 * 1860-incremental-memory-leak.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/18
 */
public class Solution {
    public int[] memLeak(int memory1, int memory2) {
        int i = 1;
        while (memory1 >= i || memory2 >= i) {
            if (memory1 >= memory2) {
                memory1 -= i;
            } else {
                memory2 -= i;
            }
            i++;
        }
        return new int[] {i, memory1, memory2};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Integer.MAX_VALUE);
        // [3,1,0]
        System.out.println(Arrays.toString(s.memLeak(2, 2)));
        // [6,0,4]
        System.out.println(Arrays.toString(s.memLeak(8, 11)));
        // [65536, 8, 32767]
        System.out.println(Arrays.toString(s.memLeak(8, 2147483647)));
    }
}