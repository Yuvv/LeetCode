import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * 0952-largest-component-size-by-common-factor.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/24
 */
public class Solution {
    public int largestComponentSize(int[] nums) {
        Map<Integer, Integer> primeGroupMap = new HashMap<>();
        Map<Integer, Set<Integer>> groupPrimeMap = new HashMap<>();
        for (int num : nums) {
            int originNum = num;
            Set<Integer> primeFactor = new HashSet<>();
            primeFactor.add(originNum);
            Integer group = null;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    primeFactor.add(i);
                    if (group == null) {
                        group = primeGroupMap.get(i);
                    }
                    while (num % i == 0) {
                        num /= i;
                    }
                }
            }
            if (num >= 2) {
                primeFactor.add(num);
                if (group == null) {
                    group = primeGroupMap.get(num);
                }
            }

            if (group == null) {
                group = originNum;
            }
            if (groupPrimeMap.containsKey(group)) {
                groupPrimeMap.get(group).addAll(primeFactor);
            } else {
                groupPrimeMap.put(group, primeFactor);
            }
            for (Integer prime : primeFactor) {
                Integer originGroup = primeGroupMap.put(prime, group);
                if (originGroup != null && !originGroup.equals(group) && groupPrimeMap.containsKey(originGroup)) {
                    Set<Integer> pfs = groupPrimeMap.get(group);
                    for (Integer val : groupPrimeMap.remove(originGroup)) {
                        primeGroupMap.put(val, group);
                        pfs.add(val);
                    }
                }
            }
        }
        Map<Integer, Integer> groupMap = new HashMap<>(nums.length);
        for (int num : nums) {
            Integer group = primeGroupMap.get(num);
            groupMap.put(group, groupMap.getOrDefault(group, 0) + 1);
        }

        return groupMap.values().stream()
                .max(Comparator.comparingInt(Integer::intValue))
                .orElse(1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.largestComponentSize(new int[] {4,6,15,35}));
        // 2
        System.out.println(s.largestComponentSize(new int[] {20,50,9,63}));
        // 8
        System.out.println(s.largestComponentSize(new int[] {2,3,6,7,4,12,21,39}));
        // 1
        System.out.println(s.largestComponentSize(new int[] {1,2,3,5,7,11,13}));
        // 14
        System.out.println(s.largestComponentSize(new int[] {2,4,3,5,67,8,541,35,54,6,34,2354,24,24345,435,2543}));
        // 16
        System.out.println(s.largestComponentSize(new int[] {2,4,3,5,67,8,541,35,54,6,34,2354,24,24345,435,2543,23,43,234,37,87}));
    }
}