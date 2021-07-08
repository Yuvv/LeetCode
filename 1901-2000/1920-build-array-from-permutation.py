#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1920-build-array-from-permutation.py
# @Date   : 2021/07/08
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def buildArray(self, nums: List[int]) -> List[int]:
        res = []
        for i in range(len(nums)):
            res.append(nums[nums[i]])
        return res


if __name__ == '__main__':
    s = Solution()
    # [0,1,2,3,5,3]
    print(s.buildArray([0, 2, 1, 5, 3, 4]))
    # [4,5,0,1,2,3]
    print(s.buildArray([5, 0, 1, 2, 3, 4]))
