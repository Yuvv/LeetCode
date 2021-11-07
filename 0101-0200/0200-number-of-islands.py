#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0200-number-of-islands.py
# @Author : Yuvv (yuvv_th@outlook.com)
# @Date   : 2021-11-07


from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        cnt = 0
        for i, row in enumerate(grid):
            for j, cell in enumerate(row):
                if cell == '1':
                    cnt += 1
                    self.markAsWater(grid, i, j)
        return cnt

    def markAsWater(self, grid: List[List[str]], x: int, y: int):
        if x < 0 or y < 0:
            return
        if x >= len(grid):
            return
        if y >= len(grid[x]):
            return

        if grid[x][y] != '1':
            return

        grid[x][y] = '0'
        # recursive
        self.markAsWater(grid, x - 1, y)
        self.markAsWater(grid, x, y - 1)
        self.markAsWater(grid, x + 1, y)
        self.markAsWater(grid, x, y + 1)


if __name__ == "__main__":
    s = Solution()
    # 1
    print(
        s.numIslands(
            [
                ["1", "1", "1", "1", "0"],
                ["1", "1", "0", "1", "0"],
                ["1", "1", "0", "0", "0"],
                ["0", "0", "0", "0", "0"],
            ]
        )
    )
    # 3
    print(
        s.numIslands(
            [
                ["1", "1", "0", "0", "0"],
                ["1", "1", "0", "0", "0"],
                ["0", "0", "1", "0", "0"],
                ["0", "0", "0", "1", "1"],
            ]
        )
    )
