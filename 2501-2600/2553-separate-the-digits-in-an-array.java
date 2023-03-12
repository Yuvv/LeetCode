import java.util.*;
import java.util.stream.*;

/*
 * 2553-separate-the-digits-in-an-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/03/12
 */
public class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int e : nums) {
            List<Integer> tmp = new ArrayList<>(4);
            while (e > 0) {
                tmp.add(e % 10);
                e /= 10;
            }
            Collections.reverse(tmp);
            list.addAll(tmp);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,3,2,5,8,3,7,7]
        System.out.println(Arrays.toString(s.separateDigits(
            new int[] {13,25,83,77}
        )));
        // [7,1,3,9]
        System.out.println(Arrays.toString(s.separateDigits(
            new int[] {7,1,3,9}
        )));
    }
}
