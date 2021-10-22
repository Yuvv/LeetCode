/*
 * 1946-largest-number-after-mutating-substring.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/10/22
 */
public class Solution {
    public String maximumNumber(String num, int[] change) {
        int i = 0;
        while (i < num.length()) {
            int val = num.charAt(i) - '0';
            if (val < change[val]) {
                break;
            }
            i++;
        }
        if (i >= num.length()) {
            return num;
        }

        StringBuilder sb = new StringBuilder(num.substring(0, i));
        while (i < num.length()) {
            int val = num.charAt(i) - '0';
            if (val > change[val]) {
                break;
            }
            sb.append(change[val]);
            i++;
        }
        sb.append(num.substring(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "974676"
        System.out.println(s.maximumNumber("214010", new int[] {6,7,9,7,4,0,3,4,4,7}));
        // "832"
        System.out.println(s.maximumNumber("132", new int[] {9,8,5,0,3,6,4,2,6,8}));
        // "934"
        System.out.println(s.maximumNumber("021", new int[] {9,4,3,5,7,2,1,9,0,6}));
        // "5"
        System.out.println(s.maximumNumber("5", new int[] {1,4,7,5,3,2,5,6,9,4}));
    }
}