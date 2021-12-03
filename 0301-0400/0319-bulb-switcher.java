
/*
 * 0319-bulb-switcher.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/03
 */
public class Solution {
    public int bulbSwitch(int n) {
        int a = (int) Math.sqrt(n);
        return a;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.bulbSwitch(3));
        // 0
        System.out.println(s.bulbSwitch(0));
        // 1
        System.out.println(s.bulbSwitch(1));
        // 6
        System.out.println(s.bulbSwitch(45));
        // 9
        System.out.println(s.bulbSwitch(96));
    }
}