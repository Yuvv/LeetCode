/**
 * 2483-minimum-penalty-for-a-shop.java
 * 
 * @date 2024/1/15
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    public int bestClosingTime(String customers) {
        int yc = 0;
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                yc++;
            }
        }
        int nc = 0;
        int min = yc + nc;
        int minIdx = 0;
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'N') {
                nc++;
            } else {
                yc--;
            }
            if (nc + yc < min) {
                min = nc + yc;
                minIdx = i+1;
            }
        }
        return minIdx;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.bestClosingTime("YYNY"));
        // 0
        System.out.println(s.bestClosingTime("NNNNN"));
        // 4
        System.out.println(s.bestClosingTime("YYYY"));
    }
}
