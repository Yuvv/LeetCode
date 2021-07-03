#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0463-island-perimeter.py
# @Date   : 2021/07/03
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        perimeter = 0
        for i, row in enumerate(grid):
            for j, col in enumerate(row):
                if col == 1:
                    perimeter += 4
                    if j > 0 and row[j - 1] == 1:
                        perimeter -= 2
                    if i > 0 and grid[i - 1][j] == 1:
                        perimeter -= 2
        return perimeter


if __name__ == '__main__':
    s = Solution()
    # 4
    print(s.islandPerimeter([[1]]))
    # 16
    print(s.islandPerimeter([[0, 1, 0, 0], [1, 1, 1, 0], [0, 1, 0, 0], [1, 1, 0, 0]]))
    # 4
    print(s.islandPerimeter([[1, 0]]))
