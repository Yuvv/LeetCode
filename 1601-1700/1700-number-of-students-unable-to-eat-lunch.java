import java.util.*;

/**
 * 1700-number-of-students-unable-to-eat-lunch.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/04/08
 */
public class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        LinkedList<Integer> queue = new LinkedList<>();
        int j = 0;
        for (int i = 0; i < students.length; i++) {
            if (sandwiches[j] == students[i]) {
                j++;
            } else {
                queue.addLast(students[i]);
            }
        }
        int lastSize = 0;
        while (lastSize != queue.size()) {
            lastSize = queue.size();
            int size = queue.size();
            while (size > 0) {
                int x = queue.pollFirst();
                if (x == sandwiches[j]) {
                    j++;
                } else {
                    queue.addLast(x);
                }
                size--;
            }
        }
        return queue.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0
        System.out.println(s.countStudents(new int[]{1,1,0,0}, new int[]{0,1,0,1}));
        // 3
        System.out.println(s.countStudents(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1}));
    }
}