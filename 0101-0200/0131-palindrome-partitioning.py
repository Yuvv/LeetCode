#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0131-palindrome-partitioning.py
# @Date   : 2021/07/09
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def is_palindrome(self, s: str) -> bool:
        i, j = 0, len(s) - 1
        while i <= j:
            if s[i] != s[j]:
                return False
            i += 1
            j -= 1
        return True

    # backtracking
    def partition(self, s: str) -> List[List[str]]:
        s_len = len(s)
        if s_len == 0:
            return [[]]
        res = []
        for i in range(1, s_len + 1):
            cur_lst = []
            if self.is_palindrome(s[:i]):
                cur_lst.append(s[:i])
                dfs_res = self.partition(s[i:])
                if len(dfs_res) > 0:
                    for e in dfs_res:
                        res.append(cur_lst + e)

        return res


if __name__ == '__main__':
    s = Solution()
    # [["a","a","b"],["aa","b"]]
    print(s.partition('aab'))
    # [["a","b","c","d","c","d","c","b","a"],["a","b","cdc","d","c","b","a"],
    #  ["a","b","c","dcd","c","b","a"],["a","b","c","d","cdc","b","a"],["a","b","cdcdc","b","a"],
    #  ["a","bcdcdcb","a"],["abcdcdcba"]]
    print(s.partition('abcdcdcba'))
    # [["a","a","a","b"],["a","aa","b"],["aa","a","b"],["aaa","b"]]
    print(s.partition('aaab'))
