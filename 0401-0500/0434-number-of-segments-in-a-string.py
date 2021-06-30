#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0434-number-of-segments-in-a-string.py
# @Date   : 2021/06/30
# @Author : Yuvv <yuvv_th@outlook.com>


class Solution:
    def countSegments(self, s: str) -> int:
        return len(list(filter(lambda x: len(x) > 0, s.split(' '))))


if __name__ == '__main__':
    s = Solution()
    # 1
    print(s.countSegments('Hello'))
    # 4
    print(s.countSegments('love live! mu\'sic forever'))
    # 0
    print(s.countSegments(''))
    # 6
    print(s.countSegments(', , , ,        a, eaefa'))
