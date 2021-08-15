#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1945-sum-of-digits-of-string-after-convert.py
# @Date   : 2021/08/15
# @Author : Yuvv <yuvv_th@outlook.com>


class Solution:
    def getLucky(self, s: str, k: int) -> int:
        s = ''.join([str(ord(c) - 96) for c in s])

        for i in range(k):
            num = sum([int(c) for c in s])
            s = str(num)
        return int(s)


if __name__ == '__main__':
    s = Solution()
    # 36
    print(s.getLucky('iiii', 1))
    # 6
    print(s.getLucky('leetcode', 2))
    # 8
    print(s.getLucky('zbax', 2))
