#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1784-check-if-binary-string-has-at-most-one-segment-of-ones.py
# @Date   : 2021/03/08
# @Author : Yuvv <yuvv_th@outlook.com>


class Solution:
    def checkOnesSegment(self, s: str) -> bool:
        i = 0
        s_len = len(s)
        while i < s_len and s[i] == '1':
            i += 1
        if i >= s_len:
            return True
        while i < s_len and s[i] == '0':
            i += 1
        if i >= s_len:
            return True
        return False


if __name__ == '__main__':
    s = Solution()
    # false
    print(s.checkOnesSegment('1001'))
    # true
    print(s.checkOnesSegment('110'))
