import java.util.LinkedList;

/*
 * 1376-time-needed-to-inform-all-employees.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/06/03
 */
public class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        boolean[] flags = new boolean[n];
        flags[headID] = true;
        int max = informTime[headID];
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            stack.push(i);
            while (!stack.isEmpty()) {
                int j = stack.peek();
                if (flags[j]) {
                    stack.pop();
                } else {
                    if (flags[manager[j]]) {
                        informTime[j] += informTime[manager[j]];
                        flags[j] = true;
                    } else {
                        stack.push(manager[j]);
                    }
                }
            }
            max = Math.max(max, informTime[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0
        System.out.println(s.numOfMinutes(
            1, 0, new int[] {-1}, new int[] {0}
        ));
        // 1
        System.out.println(s.numOfMinutes(
            6, 2, new int[] {2,2,-1,2,2,2}, new int[] {0,0,1,0,0,0}
        ));
        // 15
        System.out.println(s.numOfMinutes(
            6, 0, new int[] {-1,0,1,2,3,4}, new int[] {1,2,3,4,5,0}
        ));
    }
}