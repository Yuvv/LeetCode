/**
 * 2515-shortest-distance-to-target-string-in-a-circular-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2026/04/18
 */
public class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                int dis = Math.abs(i - startIndex);
                dis = Math.min(dis, words.length - dis);
                minDis = Math.min(minDis, dis);
            }
        }
        if (minDis != Integer.MAX_VALUE) {
            return minDis;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.closestTarget(new String[]{"hello", "i", "am", "leetcode", "hello"}, "hello", 1));
        // 1
        System.out.println(s.closestTarget(new String[]{"a", "b", "leetcode"}, "leetcode", 0));
        // -1
        System.out.println(s.closestTarget(new String[]{"i", "eat", "leetcode"}, "ate", 0));
    }
}