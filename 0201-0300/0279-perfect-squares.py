#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0279-perfect-squares.py
# @Date   : 2021/08/09
# @Author : Yuvv <yuvv_th@outlook.com>

import math


class Solution:
    MEM = {}

    def numSquares(self, n: int) -> int:
        if n in Solution.MEM:
            return Solution.MEM[n]

        if n < 4:
            Solution.MEM[n] = n
            return n

        mn = 1e9
        for i in range(2, int(math.sqrt(n)) + 1):
            j = i * i
            cnt = n // j + self.numSquares(n % j)
            if cnt < mn:
                mn = cnt
        Solution.MEM[n] = mn
        return mn


if __name__ == '__main__':
    s = Solution()
    # 3
    print(s.numSquares(12))
    # 2
    print(s.numSquares(13))
    # 4
    print(s.numSquares(9999))
    # 4
    print(s.numSquares(9471))
