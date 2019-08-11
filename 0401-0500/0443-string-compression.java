/*
 * Filename: 0443-string-compression.java
 * Created: 2019-08-11
 * Author: Yuvv
 */
class Solution {
    private int writeNum(char[] chars, int fromIndex, int value) {
        String str = "" + value;
        int i = 0;
        while (i < str.length()) {
            chars[fromIndex] = str.charAt(i);
            fromIndex++;
            i++;
        }
        return str.length();
    }

    public int compress(char[] chars) {
        if (chars.length <= 1) {
            return 1;
        }
        int i = 0, j = 1;
        int writePos = 0;
        int dis;
        while (j < chars.length) {
            if (chars[j] != chars[i]) {
                chars[writePos] = chars[i];
                writePos++;

                dis = j - i;
                if (dis > 1) {
                    writePos += writeNum(chars, writePos, dis);
                }
                i = j;
            }
            j++;
        }
        chars[writePos] = chars[i];
        writePos++;
        dis = j - i;
        if (dis > 1) {
            writePos += writeNum(chars, writePos, dis);
        }
        return writePos;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.compress("aabbccc", 7));    // 6 expected
        System.out.println(s.compress("a", 1));        // 1 expected
        System.out.println(s.compress("abbbbbbbbbbb", 12));    // 4 expected
        System.out.println(s.compress("abbbbbbbbbbc", 12));    // 5 expected
        System.out.println(s.compress("aaaaa", 5));    // 2 expected

    }
}