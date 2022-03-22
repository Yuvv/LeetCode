import java.util.Arrays;

/*
 * 0881-boats-to-save-people.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/22
 */
public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0;
        int i = 0, j = people.length - 1;
        while (i <= j) {
            res++;
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.numRescueBoats(new int[] {1,2}, 3));
        // 3
        System.out.println(s.numRescueBoats(new int[] {3,2,2,1}, 3));
        // 4
        System.out.println(s.numRescueBoats(new int[] {3,5,3,4}, 5));
    }
}