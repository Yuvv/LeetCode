#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 2057-smallest-index-with-equal-value.py
# @Author : Yuvv (yuvv_th@outlook.com)
# @Date   : 2021-11-05

from typing import List


class Solution:
    def smallestEqual(self, nums: List[int]) -> int:
        for i, v in enumerate(nums):
            if v == (i % 10):
                return i
        return -1


if __name__ == "__main__":
    s = Solution()
    # 0
    print(s.smallestEqual([0, 1, 2]))
    # 2
    print(s.smallestEqual([4, 3, 2, 1]))
    # -1
    print(s.smallestEqual([1, 2, 3, 4, 5, 6, 7, 8, 9, 0]))
    # 1
    print(s.smallestEqual([2, 1, 3, 5, 2]))
