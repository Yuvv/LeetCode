#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1768-merge-strings-alternately.py
# @Date   : 2021/03/07
# @Author : Yuvv <yuvv_th@outlook.com>


class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        result = ''
        wl1 = len(word1)
        wl2 = len(word2)
        i = 0
        while i < wl1 and i < wl2:
            result += word1[i] + word2[i]
            i += 1
        if wl1 > wl2:
            result += word1[i:]
        elif wl2 > wl1:
            result += word2[i:]

        return result


if __name__ == '__main__':
    s = Solution()
    # aqbwce expected
    print(s.mergeAlternately('abc', 'qwe'))
    # aqbwcert expected
    print(s.mergeAlternately('abc', 'qwert'))
