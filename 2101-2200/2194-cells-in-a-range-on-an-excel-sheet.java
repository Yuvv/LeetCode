import java.util.*;

/*
 * 2194-cells-in-a-range-on-an-excel-sheet.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/13
 */
public class Solution {
    public List<String> cellsInRange(String s) {
        List<String> res = new ArrayList<>();
        // since `s.length == 5`
        char c1 = s.charAt(0);
        char r1 = s.charAt(1);
        char c2 = s.charAt(3);
        char r2 = s.charAt(4);
        for (char c = c1; c <= c2; c++) {
            for (char r = r1; r <= r2; r++) {
                res.add("" + c + "" + r);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // ["K1","K2","L1","L2"]
        System.out.println(s.cellsInRange("K1:L2"));
        // ["A1","B1","C1","D1","E1","F1"]
        System.out.println(s.cellsInRange("A1:F1"));
    }
}