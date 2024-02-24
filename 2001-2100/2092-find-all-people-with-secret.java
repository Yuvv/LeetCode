import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * 2092-find-all-people-with-secret.java
 *
 * @date 2024/2/24
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // sort by time
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        // us
        int[] unionset = new int[n];
        Arrays.fill(unionset, -1);
        unionset[0] = 0;
        unionset[firstPerson] = 0;
        //
        int i = 0;
        Set<Integer> cs = new HashSet<>(); // current time persions
        while (i < meetings.length) {
            cs.clear();
            int time = meetings[i][2];
            while (i < meetings.length && meetings[i][2] == time) {
                unionFind(unionset, meetings[i][0], meetings[i][1], cs);
                i++;
            }
            // reset non-zero group
            for (Integer v : cs) {
                if (unionset[v] > 0) {
                    unionset[v] = -1;
                }
            }
        }
        List<Integer> resList = new ArrayList<>();
        for (i = 0; i < unionset.length; i++) {
            if (unionset[i] == 0) {
                resList.add(i);
            }
        }
        return resList;
    }

    public void unionFind(int[] unionset, int x, int y, Set<Integer> cs) {
        if (unionset[x] < 0 && unionset[y] < 0) {
            int min = Math.min(x, y);
            unionset[x] = min;
            unionset[y] = min;
        } else if (unionset[x] >= 0 && unionset[y] < 0) {
            unionset[y] = unionset[x];
        } else if (unionset[y] >= 0 && unionset[x] < 0) {
            unionset[x] = unionset[y];
        } else { // both x&y >= 0
            if (unionset[x] != unionset[y]) {
                int min = Math.min(unionset[x], unionset[y]);
                int max = Math.max(unionset[x], unionset[y]);
                for (Integer v : cs) {
                    if (unionset[v] == max) {
                        unionset[v] = min; // join group
                    }
                }
            } // else do nothing
        }
        if (unionset[x] == 0) {
            cs.remove(x); // don't need to check any ZERO-group values
        } else {
            cs.add(x);
        }
        if (unionset[y]  == 0) {
            cs.remove(y);
        } else {
            cs.add(y);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [0,1,2,3,5]
        System.out.println(s.findAllPeople(6, new int[][] { { 1, 2, 5 }, { 2, 3, 8 }, { 1, 5, 10 } }, 1));
        // [0,1,3]
        System.out.println(s.findAllPeople(4, new int[][] { { 3, 1, 3 }, { 1, 2, 2 }, { 0, 3, 3 } }, 3));
        // [0,1,2,3,4]
        System.out.println(s.findAllPeople(5, new int[][] { { 3, 4, 2 }, { 1, 2, 1 }, { 2, 3, 1 } }, 1));
    }
}
