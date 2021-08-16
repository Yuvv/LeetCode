#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1877-minimize-maximum-pair-sum-in-array.py
# @Date   : 2021/08/16
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def minPairSum(self, nums: List[int]) -> int:
        i, j = 0, len(nums) - 1
        mx = 0
        nums = sorted(nums)
        while i < j:
            mx = max(mx, nums[i] + nums[j])
            i += 1
            j -= 1

        return mx


if __name__ == '__main__':
    s = Solution()
    # 7
    print(s.minPairSum([3, 5, 2, 3]))
    # 8
    print(s.minPairSum([3, 5, 4, 2, 4, 6]))
