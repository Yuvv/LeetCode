#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1662-check-if-two-string-arrays-are-equivalent.py
# @Date   : 2021/08/23
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def arrayStringsAreEqual(self, word1: List[str], word2: List[str]) -> bool:
        w1_len = len(word1)
        w2_len = len(word2)
        i1, i2 = 0, 0
        j1, j2 = 0, 0
        while i1 < w1_len and i2 < w2_len:
            if word1[i1][j1] != word2[i2][j2]:
                return False

            j1 += 1
            if j1 >= len(word1[i1]):
                i1 += 1
                j1 = 0

            j2 += 1
            if j2 >= len(word2[i2]):
                i2 += 1
                j2 = 0

        return i1 == w1_len and i2 == w2_len


if __name__ == '__main__':
    s = Solution()
    # true
    print(s.arrayStringsAreEqual(['ab', 'c'], ['a', 'bc']))
    # false
    print(s.arrayStringsAreEqual(['a', 'cb'], ['ab', 'c']))
    # true
    print(s.arrayStringsAreEqual(['abc', 'd', 'defg'], ['abcddefg']))
