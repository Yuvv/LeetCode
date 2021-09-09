import java.util.*;

/*
 * 0830-positions-of-large-groups.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/09
 */
public class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> resultList = new ArrayList<>();
        int i = 0;
        int j;
        for (j = 1; j < s.length(); j++) {
            if (s.charAt(i) != s.charAt(j)) {
                if (j - i >= 3) {
                    resultList.add(Arrays.asList(i, j - 1));
                }
                i = j;
            }
        }
        if (j - i >= 3) {
            resultList.add(Arrays.asList(i, j - 1));
        }

        return resultList;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[3,6]]
        System.out.println(s.largeGroupPositions("abbxxxxzzy"));
        // []
        System.out.println(s.largeGroupPositions("abc"));
        // [[3,5],[6,9],[12,14]]
        System.out.println(s.largeGroupPositions("abcdddeeeeaabbbcd"));
        // []
        System.out.println(s.largeGroupPositions("aba"));
    }
}