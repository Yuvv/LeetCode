#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0674-longest-continuous-increasing-subsequence.py
# @Date   : 2021/08/16
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def findLengthOfLCIS(self, nums: List[int]) -> int:
        i, j = 0, 1
        mx_len = 1
        while j < len(nums):
            if nums[j] <= nums[j - 1]:
                cur_len = j - i
                i = j
                mx_len = max(mx_len, cur_len)
            j += 1

        mx_len = max(j - i, mx_len)

        return mx_len


if __name__ == '__main__':
    s = Solution()
    # 3
    print(s.findLengthOfLCIS([1, 3, 5, 4, 7]))
    # 1
    print(s.findLengthOfLCIS([2, 2, 2, 2, 2]))
    # 2
    print(s.findLengthOfLCIS([2, 2, 2, 2, 3]))
