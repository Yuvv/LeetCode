#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0303-range-sum-query-immutable.py
# @Date   : 2019/07/27
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class NumArray:
    def __init__(self, nums: List[int]):
        self.nums = nums

    def sumRange(self, i: int, j: int) -> int:
        return sum(self.nums[i:j + 1])


if __name__ == "__main__":
    s = NumArray([-2, 0, 3, -5, 2, -1])
    print(s.sumRange(0, 2))  # 1 expected
    print(s.sumRange(2, 5))  # -1 expected
    print(s.sumRange(0, 5))  # -3 expected
    print(s.sumRange(0, 10))  # -3 expected
