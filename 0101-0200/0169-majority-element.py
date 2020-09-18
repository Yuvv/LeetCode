#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0169-majority-element.py
# @Date   : 2020/09/18
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        d = dict()
        half = len(nums) // 2
        for each in nums:
            d[each] = d.get(each, 0) + 1
            if d[each] > half:
                return each
        return -1


if __name__ == "__main__":
    s = Solution()

    # 2
    print(s.majorityElement([2, 3, 2]))
