#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1232-check-if-it-is-a-straight-line.py
# @Date   : 2019/10/20
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def checkStraightLine(self, coordinates: List[List[int]]) -> bool:
        c_len = len(coordinates)
        if c_len <= 2:
            return True
        a = coordinates[1][1] - coordinates[0][1]
        b = coordinates[1][0] - coordinates[0][0]
        slope = a / b if b != 0 else None
        i = 2
        while i < c_len:
            a = coordinates[i][1] - coordinates[i - 1][1]
            b = coordinates[i][0] - coordinates[i - 1][0]
            cur_slope = a / b if b != 0 else None
            if slope is None:
                if cur_slope is not None:
                    return False
            else:
                if cur_slope is None:
                    return False
                if abs(slope - cur_slope) > 1e-6:
                    return False
            i += 1
        return True


if __name__ == "__main__":
    s = Solution()
    # true
    print(s.checkStraightLine([[1, 2], [2, 3], [3, 4], [4, 5], [5, 6], [6, 7]]))
    # true
    print(s.checkStraightLine([[1, 1], [2, 2], [3, 4], [4, 5], [5, 6], [7, 7]]))
