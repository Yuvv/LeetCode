#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0883-projection-area-of-3d-shapes.py
# @Date   : 2019/06/29
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def projectionArea(self, grid: List[List[int]]) -> int:
        xy = 0  # from top
        xz = 0  # form front
        yz = 0  # from side
        row_count = len(grid)
        if row_count == 0:
            return 0
        col_count = len(grid[0])
        ci_max_list = grid[0]
        for ri in range(row_count):
            ri_max = grid[ri][0]
            for ci in range(col_count):
                if grid[ri][ci] > 0:
                    xy += 1
                if grid[ri][ci] > ri_max:
                    ri_max = grid[ri][ci]
                if grid[ri][ci] > ci_max_list[ci]:
                    ci_max_list[ci] = grid[ri][ci]
            yz += ri_max
        xz = sum(ci_max_list)
        return xy + xz + yz


if __name__ == "__main__":
    s = Solution()
    print(s.projectionArea([[2]]))  # 5 expected
    print(s.projectionArea([[1, 2], [3, 4]]))  # 17 expected
    print(s.projectionArea([[1, 1, 1], [1, 0, 1], [1, 1, 1]]))  # 14 expected
    print(s.projectionArea([[1, 0], [0, 2]]))  # 8 expected
    print(s.projectionArea([[2, 2, 2], [2, 1, 2], [2, 2, 2]]))  # 21 expected
