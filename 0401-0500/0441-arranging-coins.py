#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0441-arranging-coins.py
# @Date   : 2021/06/30
# @Author : Yuvv <yuvv_th@outlook.com>

import math


class Solution:
    def arrangeCoins(self, n: int) -> int:
        # k*(k+1)/2 = n
        return int((math.sqrt(1 + 8 * n) - 1) / 2)


if __name__ == '__main__':
    s = Solution()
    # 2
    print(s.arrangeCoins(5))
    # 3
    print(s.arrangeCoins(8))
    # 2
    print(s.arrangeCoins(3))
    # 4
    print(s.arrangeCoins(10))
    # 4
    print(s.arrangeCoins(11))
