#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0575-distribute-candies.py
# @Date   : 2021/03/25
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def distributeCandies(self, candyType: List[int]) -> int:
        return min(len(set(candyType)), len(candyType) // 2)


if __name__ == '__main__':
    s = Solution()
    # 3
    print(s.distributeCandies([1, 1, 2, 2, 3, 3]))
