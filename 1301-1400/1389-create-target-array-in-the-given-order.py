#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1389-create-target-array-in-the-given-order.py
# @Date   : 2020/09/18
# @Author : Yuvv <yuvv_th@outlook.com>

from tpying import List


class Solution:
    def createTargetArray(self, nums: List[int], index: List[int]) -> List[int]:
        if len(nums) == 0:
            return []
        rlist = [[nums[index[0]]]]
        for i in range(1, len(nums)):
            l = rlist[-1][:]
            l.insert(index[i], nums[i])
            rlist.append(l)
        return rlist[-1]


if __name__ == "__main__":
    s = Solution()

    # [0,1,2,3,4]
    print(s.createTargetArray([1, 2, 3, 4, 0], [0, 1, 2, 3, 0]))
