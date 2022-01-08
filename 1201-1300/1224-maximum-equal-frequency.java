import java.util.*;

/*
 * 1224-maximum-equal-frequency.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/29
 */
public class Solution {
   public int maxEqualFreq(int[] nums) {
        int max = 1;
        // num -> count of num
        Map<Integer, Integer> countMap = new HashMap<>();
        // count -> nums with this count
        Map<Integer, Set<Integer>> reverseCountMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int originCount = countMap.getOrDefault(num, 0);
            countMap.put(num, originCount + 1);
            if (originCount > 0) {
                reverseCountMap.get(originCount).remove(num);
                if (reverseCountMap.get(originCount).isEmpty()) {
                    reverseCountMap.remove(originCount);
                }
            }
            reverseCountMap.computeIfAbsent(originCount + 1, k -> new HashSet<>()).add(num);
            if (reverseCountMap.size() == 2 && reverseCountMap.values().stream().map(Set::size).anyMatch(s -> s == 1)) {
                if (reverseCountMap.containsKey(1) && reverseCountMap.get(1).size() == 1) {
                    max = Math.max(max, i + 1);
                } else {
                    Iterator<Map.Entry<Integer, Set<Integer>>> it = reverseCountMap.entrySet().iterator();
                    Map.Entry<Integer, Set<Integer>> entryA = it.next();
                    Map.Entry<Integer, Set<Integer>> entryB = it.next();
                    if (entryA.getKey() < entryB.getKey()) {
                        Map.Entry<Integer, Set<Integer>> entryC = entryA;
                        entryA = entryB;
                        entryB = entryC;
                    }
                    if (entryA.getValue().size() == 1 && entryA.getKey() - entryB.getKey() == 1) {
                        max = Math.max(max, i + 1);
                    }
                }
            } else if (reverseCountMap.size() == 1) {
                if (reverseCountMap.containsKey(1) || reverseCountMap.values().iterator().next().size() == 1) {
                    max = Math.max(max, i + 1);
                }
            }

        }

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.maxEqualFreq(new int[] {1,1,1,2,2,2}));
        // 7
        System.out.println(s.maxEqualFreq(new int[] {2,2,1,1,5,3,3,5}));
        // 13
        System.out.println(s.maxEqualFreq(new int[] {1,1,1,2,2,2,3,3,3,4,4,4,5}));
    }
}