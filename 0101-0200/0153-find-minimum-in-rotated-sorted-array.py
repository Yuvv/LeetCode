#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0153-find-minimum-in-rotated-sorted-array.py
# @Date   : 2021/04/21
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:
        b, e = 0, len(nums) - 1
        # ascending
        if nums[e] >= nums[b]:
            return nums[b]

        # rotated
        while e > b:
            mid = (b + e) // 2
            if nums[mid] < nums[e]:
                e = mid
            elif nums[mid] >= nums[b]:
                b = mid + 1
            elif nums[mid] > nums[e]:
                # reversed
                b = e
        return nums[b]


if __name__ == '__main__':
    s = Solution()
    # 1
    print(s.findMin([5, 1, 2, 3, 4]))
    # 0
    print(s.findMin([4, 5, 6, 7, 8, 0, 1, 2]))
    # 11
    print(s.findMin([11, 13, 15, 17]))
    # 2
    print(s.findMin([5, 4, 3, 2]))
