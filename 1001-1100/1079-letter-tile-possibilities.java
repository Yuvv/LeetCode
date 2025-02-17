import java.util.*;
/**
 * 1079-letter-tile-possibilities.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/02/18
 */
public class Solution {
    static int[] pArr = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320};

    private int perm(List<Character> lst) {
        Map<Character, Integer> cntMap = new HashMap<>();
        for (char c : lst) {
            cntMap.put(c, cntMap.getOrDefault(c, 0) + 1);
        }
        int x = pArr[lst.size()];
        for (int v : cntMap.values()) {
            x /= pArr[v];
        }
        return x;
    }
    public int numTilePossibilities(String tiles) {
        int cnt = 0;
        char[] nums = tiles.toCharArray();
        List<List<Character>> result = new ArrayList<>(); // all unique subset
        result.add(new ArrayList<>(0));

        // sorted is needed
        Arrays.sort(nums);
        // store duplicated number's last result size
        Map<Character, Integer> numSizeMap = new HashMap<>();
        // iteration
        for (char num : nums) {
            int lastSize = result.size();
            int beginSize = numSizeMap.getOrDefault(num, 0);
            for (int i = beginSize; i < lastSize; i++) {
                List<Character> curList = new ArrayList<>(result.get(i));
                curList.add(num);
                cnt += perm(curList);
                result.add(curList);
            }
            numSizeMap.put(num, lastSize);
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 8
        System.out.println(s.numTilePossibilities("AAB"));
        // 188
        System.out.println(s.numTilePossibilities("AAABBC"));
        // 1
        System.out.println(s.numTilePossibilities("V"));
    }

}
