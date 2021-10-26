#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1846-maximum-element-after-decreasing-and-rearranging.py
# @Author : Yuvv (yuvv_th@outlook.com)
# @Date   : 2021-10-26


from typing import List


class Solution:
    def maximumElementAfterDecrementingAndRearranging(self, arr: List[int]) -> int:
        x = 0
        for e in sorted(arr):
            if abs(e - x) > 1:
                x += 1
            else:
                x = e
        return x


if __name__ == "__main__":
    s = Solution()
    # 2
    print(s.maximumElementAfterDecrementingAndRearranging([2, 2, 1, 2, 1]))
    # 3
    print(s.maximumElementAfterDecrementingAndRearranging([100, 1, 1000]))
    # 5
    print(s.maximumElementAfterDecrementingAndRearranging([1, 2, 3, 4, 5]))
    # 13
    print(
        s.maximumElementAfterDecrementingAndRearranging(
            [1, 4, 5, 6, 8, 5, 66, 5, 555, 54, 34, 32, 32, 2, 2, 3, 2, 3, 2, 2]
        )
    )
