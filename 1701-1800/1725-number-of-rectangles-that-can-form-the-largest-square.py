#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1725-number-of-rectangles-that-can-form-the-largest-square.py
# @Date   : 2021/04/15
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def countGoodRectangles(self, rectangles: List[List[int]]) -> int:
        m = dict()
        mx = 0
        for e in rectangles:
            mm = min(e)
            m[mm] = m.get(mm, 0) + 1
            if mm > mx:
                mx = mm
        return m[mx]


if __name__ == '__main__':
    s = Solution()
    # 3
    print(s.countGoodRectangles([[5, 8], [3, 9], [5, 12], [16, 5]]))
    # 3
    print(s.countGoodRectangles([[2, 3], [3, 7], [4, 3], [3, 7]]))
