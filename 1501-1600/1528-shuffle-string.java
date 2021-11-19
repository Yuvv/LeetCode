/*
 * 1528-shuffle-string.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/19
 */
public class Solution {
    public String restoreString(String s, int[] indices) {
        char[] chArr = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            chArr[indices[i]] = s.charAt(i);
        }
        return new String(chArr);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "leetcode"
        System.out.println(s.restoreString("codeleet", new int[] {4,5,6,7,0,2,1,3}));
        // "abc"
        System.out.println(s.restoreString("abc", new int[] {0,1,2}));
        // "arigatou"
        System.out.println(s.restoreString("aaiougrt", new int[] {4,0,2,6,7,3,1,5}));

    }
}