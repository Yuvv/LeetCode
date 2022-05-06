import java.util.*;

/*
 * 2197-replace-non-coprime-numbers-in-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/06
 */
public class Solution {
    static final Map<String, Integer> GCD_CACHE = new HashMap<>();

    public int gcd(int a, int b) {
        // let `a` large than `b`
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        String key = a + "," + b;
        if (GCD_CACHE.containsKey(key)) {
            return GCD_CACHE.get(key);
        }
        while (a % b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        GCD_CACHE.put(key, b);
        return b;
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        LinkedList<Integer> stack = new LinkedList<>();
        int i = 0;
        while (i < nums.length) {
            int b = nums[i];
            if (stack.isEmpty()) {
                stack.push(b);
                i++;
            } else {
                int a = stack.peek();
                int abGcd = gcd(a, b);
                if (abGcd > 1) {
                    // non-coprime
                    stack.pop();
                    nums[i] = a / abGcd * b;  // ==> (a * b) / gcd
                } else {
                    stack.push(b);
                    i++;
                }
            }
        }

        List<Integer> resList = new ArrayList<>(stack.size());
        while (!stack.isEmpty()) {
            resList.add(stack.pollLast());
        }
        return resList;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [12,7,6]
        System.out.println(s.replaceNonCoprimes(new int[] {6,4,3,2,7,6,2}));
        // [2,1,1,3]
        System.out.println(s.replaceNonCoprimes(new int[] {2,2,1,1,3,3,3}));
    }
}