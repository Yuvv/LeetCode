import java.util.*;

/*
 * 0989-add-to-array-form-of-integer.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/10
 */
public class Solution {
    public List<Integer> addToArrayForm(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        while (k > 0) {
            res.add(k % 10);
            k /= 10;
        }
        int carry = 0;
        int i;
        for (i = 0; i < nums.length; i++) {
            int num = nums[nums.length - 1 - i];
            if (i < res.size()) {
                num += res.get(i) + carry;
                res.set(i, num % 10);
                carry = num / 10;
            } else {
                num += carry;
                res.add(num % 10);
                carry = num / 10;
            }
        }
        while (carry > 0 && i < res.size()) {
            int num = carry + res.get(i);
            res.set(i, num % 10);
            carry = num / 10;
            i++;
        }
        if (carry > 0) {
            res.add(carry);
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,2,3,4]
        System.out.println(s.addToArrayForm(new int[] {1,2,0,0}, 34));
        // [4,5,5]
        System.out.println(s.addToArrayForm(new int[] {2,7,4}, 181));
        // [1,0,2,1]
        System.out.println(s.addToArrayForm(new int[] {2,1,5}, 806));
        // [8,1,5]
        System.out.println(s.addToArrayForm(new int[] {6}, 809));
    }
}