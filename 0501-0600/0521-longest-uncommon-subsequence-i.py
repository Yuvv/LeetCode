#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0521-longest-uncommon-subsequence-i.py
# @Date   : 2021/07/12
# @Author : Yuvv <yuvv_th@outlook.com>


class Solution:
    def findLUSlength(self, a: str, b: str) -> int:
        a_len = len(a)
        b_len = len(b)
        if a_len != b_len:
            return max(a_len, b_len)
        for i in range(a_len):
            if a[i] != b[i]:
                return a_len - i
        return -1


if __name__ == '__main__':
    s = Solution()
    # 3
    print(s.findLUSlength('aba', 'cdc'))
    # 3
    print(s.findLUSlength('aaa', 'bbb'))
    # -1
    print(s.findLUSlength('aaa', 'aaa'))
