#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1961-check-if-string-is-a-prefix-of-array.py
# @Date   : 2021/08/15
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def isPrefixString(self, s: str, words: List[str]) -> bool:
        s_len = len(s)
        i = 0
        for word in words:
            word_len = len(word)
            if word != s[i:i + word_len]:
                return False
            i += word_len
            if i >= s_len:
                break
        return i >= s_len


if __name__ == '__main__':
    s = Solution()
    # true
    print(s.isPrefixString('iloveleetcode', ["i", "love", "leetcode", "apples"]))
    # false
    print(s.isPrefixString('iloveleetcode', ["apples", "i", "love", "leetcode"]))
    # false
    print(s.isPrefixString('iloveleetcode', ["i", "love", "leetcod", "apples"]))
    # false
    print(s.isPrefixString('iloveleetcode', ["i", "love", "leetcod"]))
