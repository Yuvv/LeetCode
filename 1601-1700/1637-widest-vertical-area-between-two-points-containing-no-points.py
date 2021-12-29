#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1637-widest-vertical-area-between-two-points-containing-no-points.py
# @Author : Yuvv (yuvv_th@outlook.com)
# @Date   : 2021-12-29

from typing import List


class Solution:
    def maxWidthOfVerticalArea(self, points: List[List[int]]) -> int:
        mx = 0
        prev = None
        for i, it in enumerate(sorted(map(lambda a: a[0], points))):
             if i > 0:
                 mx = max(mx, it - prev)
             prev = it
        return mx


if __name__ == '__main__':
    s = Solution()
    # 1
    print(s.maxWidthOfVerticalArea([[8,7],[9,9],[7,4],[9,7]]))
    # 3
    print(s.maxWidthOfVerticalArea( [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]))
