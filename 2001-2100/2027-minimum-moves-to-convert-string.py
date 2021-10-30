#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 2027-minimum-moves-to-convert-string.py
# @Author : Yuvv (yuvv_th@outlook.com)
# @Date   : 2021-10-30


class Solution:
    def minimumMoves(self, s: str) -> int:
        s_len = len(s)
        cnt = 0
        i = 0
        while i < s_len:
            while i < s_len and s[i] == 'O':
                i += 1
            if i < s_len:
                cnt += 1
                i += 3
        return cnt



if __name__ == '__main__':
    s = Solution()
    # 1
    print(s.minimumMoves('XXX'))
    # 2
    print(s.minimumMoves('XXOX'))
    # 0
    print(s.minimumMoves('OOOO'))
    # 3
    print(s.minimumMoves('OOXOOXXXXXX'))
    # 3
    print(s.minimumMoves('OOOXOXXXXXX'))
