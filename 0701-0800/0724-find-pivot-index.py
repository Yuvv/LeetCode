#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0724-find-pivot-index.py
# @Date   : 2021/08/24
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        cum_sum = [0]
        for num in nums:
            cum_sum.append(cum_sum[-1] + num)
        total = cum_sum[-1]
        for i in range(1, len(cum_sum)):
            if cum_sum[i - 1] == (total - nums[i - 1]) / 2:
                return i - 1
        return -1


if __name__ == '__main__':
    s = Solution()
    # 0
    print(s.pivotIndex([2, 1, -1]))
    # 3
    print(s.pivotIndex([1, 7, 3, 6, 5, 6]))
    # -1
    print(s.pivotIndex([1, 2, 3]))
