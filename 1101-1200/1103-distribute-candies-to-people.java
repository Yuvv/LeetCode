/**
 * 1103-distribute-candies-to-people.java
 *
 * @date 2024/1/29
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int x = 1;
        int i = 0;
        while (x < candies) {
            res[i % num_people] += x;
            i++;
            candies -= x;
            x++;
        }
        res[i % num_people] += candies;
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,2,3,1]
        System.out.println(java.util.Arrays.toString(s.distributeCandies(7, 4)));
        // [5,2,3]
        System.out.println(java.util.Arrays.toString(s.distributeCandies(10, 3)));
        // [5,2,3]
        System.out.println(java.util.Arrays.toString(s.distributeCandies(1000000000, 1000)));
    }
}
