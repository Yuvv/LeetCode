/*
 * 0299-bulls-and-cows.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/06/12
 */
public class Solution {
    public String getHint(String secret, String guess) {
        int[] secNumCount = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            secNumCount[secret.charAt(i) - '0']++;
        }
        int ac = 0;
        int bc = 0;
        for (int i = 0; i < secret.length(); i++) {
            int x = guess.charAt(i) - '0';
            if (guess.charAt(i) == secret.charAt(i)) {
                ac++;
                secNumCount[x]--;
            }
        }
        for (int i = 0; i < secret.length(); i++) {
            int x = guess.charAt(i) - '0';
            if (guess.charAt(i) != secret.charAt(i) && secNumCount[x] > 0) {
                bc++;
                secNumCount[x]--;
            }
        }

        return ac + "A" + bc + "B";
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "1A3B"
        System.out.println(s.getHint("1807", "7810"));
        // "1A1B"
        System.out.println(s.getHint("1123", "0111"));
        // "4A6B"
        System.out.println(s.getHint("1123124243223", "0111234231343"));
    }
}