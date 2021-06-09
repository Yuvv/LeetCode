#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1848-minimum-distance-to-the-target-element.py
# @Date   : 2021/06/09
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def getMinDistance(self, nums: List[int], target: int, start: int) -> int:
        nums_len = len(nums)
        i = start
        j = start
        while i >= 0 and j < nums_len:
            if nums[i] == target or nums[j] == target:
                return start - i
            i -= 1
            j += 1

        while i >= 0:
            if nums[i] == target:
                return start - i
            i -= 1

        while j < nums_len:
            if nums[j] == target:
                return j - start
            j += 1

        return -1


if __name__ == '__main__':
    s = Solution()
    # 1
    print(s.getMinDistance([1, 2, 3, 4, 5], 5, 3))
    # 0
    print(s.getMinDistance([1], 1, 0))
    # 0
    print(s.getMinDistance([1, 1, 1, 1, 1, 1, 1, 1, 1, 1], 1, 0))
