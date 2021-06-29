#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0409-longest-palindrome.py
# @Date   : 2021/06/29
# @Author : Yuvv <yuvv_th@outlook.com>


class Solution:
    def longestPalindrome(self, s: str) -> int:
        d = {}
        for c in s:
            d[c] = d.get(c, 0) + 1

        result = 0
        has_single = False
        for v in d.values():
            if v % 2 == 0:
                result += v
            else:
                result += v - 1
                has_single = True
        if has_single:
            result += 1
        return result


if __name__ == '__main__':
    s = Solution()
    # 7
    print(s.longestPalindrome('abccccdd'))
    # 1
    print(s.longestPalindrome('a'))
    # 2
    print(s.longestPalindrome('bb'))
