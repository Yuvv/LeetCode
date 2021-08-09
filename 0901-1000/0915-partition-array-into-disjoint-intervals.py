#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0915-partition-array-into-disjoint-intervals.py
# @Date   : 2021/07/22
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def partitionDisjoint(self, nums: List[int]) -> int:
        nums_len = len(nums)
        # get min
        right_min = [0] * nums_len
        cur_min = nums[-1]
        for i in range(nums_len - 1, -1, -1):
            if nums[i] < cur_min:
                cur_min = nums[i]
            right_min[i] = cur_min

        # iter from left to right and calculate max
        cur_max = nums[0]
        for i, e in enumerate(nums):
            cur_max = max(cur_max, e)
            if cur_max <= right_min[i + 1]:
                return i + 1
        return -1


if __name__ == '__main__':
    s = Solution()
    # 3
    print(s.partitionDisjoint([5, 0, 3, 8, 6]))
    # 4
    print(s.partitionDisjoint([1, 1, 1, 0, 6, 12]))
    # 1
    print(s.partitionDisjoint([1, 1, 1]))
