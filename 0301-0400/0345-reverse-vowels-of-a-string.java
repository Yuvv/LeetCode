class Solution {
    /**
     * 翻转元音字母
     * https://leetcode.com/problems/reverse-vowels-of-a-string/
     *
     * @param s 待翻转字符串
     * @return 翻转后结果
     */
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        Set<Character> vowels = new HashSet(5);
        Collections.addAll(vowels, 'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U');

        int begin = 0, end = arr.length - 1;
        char tmp;
        while (begin < end) {
            while (begin < end && !vowels.contains(arr[begin])) {
                begin++;
            }
            while (begin < end && !vowels.contains(arr[end])) {
                end--;
            }
            if (begin < end) {
                tmp = arr[begin];
                arr[begin] = arr[end];
                arr[end] = tmp;
                begin++;
                end--;
            }
        }
        return new String(arr);
    }
}