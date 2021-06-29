#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0414-third-maximum-number.py
# @Date   : 2021/06/29
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        a, b, c = None, None, None
        for num in nums:
            if a is None:
                a = num
            elif num > a:
                a, b, c = num, a, b
            elif num == a:
                continue
            elif b is None:
                b = num
            elif num > b:
                b, c = num, b
            elif num == b:
                continue
            elif c is None or num > c:
                c = num
        if c is None or b is None:
            return a
        return c


if __name__ == '__main__':
    s = Solution()
    # 1
    print(s.thirdMax([3, 2, 1]))
    # 2
    print(s.thirdMax([1, 2]))
    # 1
    print(s.thirdMax([2, 2, 3, 1]))
