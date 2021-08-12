#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1391-check-if-there-is-a-valid-path-in-a-grid.py
# @Date   : 2021/08/12
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def hasValidPath(self, grid: List[List[int]]) -> bool:
        init_val = grid[0][0]
        if init_val == 1 or init_val == 6:
            return self.walk_to_end(grid, 2)
        elif init_val == 2 or init_val == 3:
            return self.walk_to_end(grid, 4)
        elif init_val == 4:
            return self.walk_to_end(grid, 2) or self.walk_to_end(grid, 4)
        return False

    def walk_to_end(self, grid: List[List[int]], direction: int) -> bool:
        pos_set = set()
        n_row = len(grid)
        n_col = len(grid[0])
        if n_row == 1 and n_col == 1:
            return True

        # lalala
        flag = False
        i, j = 0, 0
        _left, _right, _up, _down = 1, 2, 3, 4
        if direction == _right:
            j = 1
        elif direction == _down:
            i = 1
        while True:
            if i >= n_row or j >= n_col:
                break
            v = grid[i][j]
            pos_val = i * n_col + j
            if pos_val in pos_set:
                # 成环了
                break
            else:
                pos_set.add(pos_val)

            if direction == _left:
                if v == 1:
                    j -= 1
                elif v == 4:
                    i += 1
                    direction = _down
                elif v == 6:
                    i -= 1
                    direction = _up
                else:
                    flag = False
                    break
            elif direction == _right:
                if v == 1:
                    j += 1
                elif v == 3:
                    i += 1
                    direction = _down
                elif v == 5:
                    i -= 1
                    direction = _up
                else:
                    flag = False
                    break
            elif direction == _up:
                if v == 2:
                    i -= 1
                elif v == 3:
                    j -= 1
                    direction = _left
                elif v == 4:
                    j += 1
                    direction = _right
                else:
                    flag = False
                    break
            elif direction == _down:
                if v == 2:
                    i += 1
                elif v == 5:
                    j -= 1
                    direction = _left
                elif v == 6:
                    j += 1
                    direction = _right
                else:
                    flag = False
                    break
            # visit
            if flag:
                break
            if i == n_row - 1 and j == n_col - 1:
                flag = True

        return flag


if __name__ == '__main__':
    s = Solution()
    # false
    print(s.hasValidPath([[1, 1, 2]]))
    # true
    print(s.hasValidPath([[2, 4, 3], [6, 5, 2]]))
    # false
    print(s.hasValidPath([[1, 2, 1], [1, 2, 1]]))
    # true
    print(s.hasValidPath([[1, 1, 1, 1, 1, 1, 3]]))
    # true
    print(s.hasValidPath([[4, 1, 3], [6, 1, 5]]))
    # true
    print(s.hasValidPath([[4, 1], [6, 1]]))
