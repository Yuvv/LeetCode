import java.util.*;
/**
 * 2418-sort-the-people.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/07/22
 */
public class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Object[][] objs = new Object[names.length][2];
        for (int i = 0; i < names.length; i++) {
            objs[i] = new Object[]{names[i], heights[i]};
        }
        Arrays.sort(objs, (a, b) -> {
            return (Integer)((Object[])b)[1] - (Integer)((Object[])a)[1];
        });
        String[] res = new String[names.length];
        for (int i = 0; i < objs.length; i++) {
            res[i] = (String)objs[i][0];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // ["Mary", "Emma", "John"]
        System.out.println(s.sortPeople(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165,170}));
    }
}
