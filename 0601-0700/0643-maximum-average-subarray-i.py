#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0643-maximum-average-subarray-i.py
# @Date   : 2021/08/10
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        sa_sum = sum(nums[:k])
        mx_sum = sa_sum
        for i in range(len(nums) - k):
            sa_sum = sa_sum - nums[i] + nums[i + k]
            if sa_sum > mx_sum:
                mx_sum = sa_sum

        return mx_sum / k


if __name__ == '__main__':
    s = Solution()
    # 12.75000
    print(s.findMaxAverage([1, 12, -5, -6, 50, 3], 4))
    # 5.00000
    print(s.findMaxAverage([5], 1))
