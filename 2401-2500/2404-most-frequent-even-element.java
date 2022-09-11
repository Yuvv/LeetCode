import java.util.*;

/*
 * 2404-most-frequent-even-element.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/09/12
 */
public class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums ) {
            if (num % 2 == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        int maxCount = 0;
        int maxEle = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxEle = entry.getKey();
            }
        }
        return maxEle;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.mostFrequentEven(new int[] {0,1,2,2,4,4,1}));
        // 3346
        System.out.println(s.mostFrequentEven(new int[] {8154,9139,8194,3346,5450,9190,133,8239,4606,8671,8412,6290}));
    }
}