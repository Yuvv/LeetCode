#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0598-range-addition-ii.py
# @Date   : 2021/07/21
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def maxCount(self, m: int, n: int, ops: List[List[int]]) -> int:
        mn_m = m
        mn_n = n
        for i, j in ops:
            mn_m = min(mn_m, i)
            mn_n = min(mn_n, j)
        return mn_m * mn_n


if __name__ == '__main__':
    s = Solution()
    # 4
    print(s.maxCount(3, 3, [[2, 2], [3, 3]]))
    # 4
    print(
        s.maxCount(3, 3,
                   [[2, 2], [3, 3], [3, 3], [3, 3], [2, 2], [3, 3], [3, 3], [3, 3], [2, 2], [3, 3], [3, 3], [3, 3]]))
    # 9
    print(s.maxCount(3, 3, []))
