// 回文数字，不能使用额外空间
// https://leetcode.com/problems/palindrome-number/description/

class Solution {
    public boolean isPalindrome(int x) {
        return new StringBuilder("" + x).reverse().toString().equals("" + x);
    }
}