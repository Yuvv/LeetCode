import java.util.List;
import java.util.ArrayList;

/*
 * 1431-kids-with-the-greatest-number-of-candies.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/28
 */
public class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        List<Boolean> res = new ArrayList<>();
        for (int candy :candies) {
            res.add(candy + extraCandies >= max);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [true,true,true,false,true]
        System.out.println(s.kidsWithCandies(new int[] {2,3,5,1,3}, 3));
        // [true,false,false,false,false]
        System.out.println(s.kidsWithCandies(new int[] {4,2,1,1,2}, 1));
        // [true,false,true]
        System.out.println(s.kidsWithCandies(new int[] {12,1,12}, 10));
    }
}