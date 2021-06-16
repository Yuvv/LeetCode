#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1897-redistribute-characters-to-make-all-strings-equal.py
# @Date   : 2021/06/16
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def makeEqual(self, words: List[str]) -> bool:
        words_len = len(words)
        if words_len == 1:
            return True
        d = {}
        for word in words:
            for c in word:
                d[c] = d.get(c, 0) + 1

        for v in d.values():
            if v < words_len:
                return False
            if v % words_len != 0:
                return False
        return True


if __name__ == '__main__':
    s = Solution()
    # true
    print(s.makeEqual(["abc", "aabc", "bc"]))
    # false
    print(s.makeEqual(["ab", "a"]))
    # true
    print(s.makeEqual(["a"]))
    # true
    print(s.makeEqual(["abc", "cba"]))
    # false
    print(s.makeEqual(["a", "b"]))
    # true
    print(
        s.makeEqual([
            "caaaaa", "aaaaaaaaa", "a", "bbb", "bbbbbbbbb", "bbb", "cc", "cccccccccccc", "ccccccc", "ccccccc", "cc",
            "cccc", "c", "cccccccc", "c"
        ]))
    # false
    print(s.makeEqual(["aa", "abaab"]))
