#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0453-minimum-moves-to-equal-array-elements.py
# @Date   : 2021/06/30
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def minMoves(self, nums: List[int]) -> int:
        return sum(nums) - min(nums) * len(nums)


if __name__ == '__main__':
    s = Solution()
    # 3
    print(s.minMoves([1, 2, 3]))
    # 0
    print(s.minMoves([1, 1, 1]))
    # 5
    print(s.minMoves([1, 2, 3, 3]))
