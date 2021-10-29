#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0994-rotting-oranges.py
# @Author : Yuvv (yuvv_th@outlook.com)
# @Date   : 2021-10-29

from typing import List


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        cnt = 0
        has_fresh = True
        while has_fresh:
            has_fresh = False
            to_change_pair = []
            for i, row in enumerate(grid):
                for j, col in enumerate(row):
                    if col == 1:
                        has_fresh = True
                        vs = set()
                        if i > 0:
                            vs.add(grid[i - 1][j])
                        if j > 0:
                            vs.add(grid[i][j - 1])
                        if i < len(grid) - 1:
                            vs.add(grid[i + 1][j])
                        if j < len(grid[0]) - 1:
                            vs.add(grid[i][j + 1])

                        if 2 in vs:
                            to_change_pair.append((i, j))

            if len(to_change_pair) == 0:
                if has_fresh:
                    return -1
                break
            for i, j in to_change_pair:
                grid[i][j] = 2

            cnt += 1

        return cnt


if __name__ == "__main__":
    s = Solution()
    # 4
    print(s.orangesRotting([[2, 1, 1], [1, 1, 0], [0, 1, 1]]))
    # -1
    print(s.orangesRotting([[2, 1, 1], [0, 1, 1], [1, 0, 1]]))
    # 0
    print(s.orangesRotting([[0, 2]]))
    # -1
    print(s.orangesRotting([[1]]))
