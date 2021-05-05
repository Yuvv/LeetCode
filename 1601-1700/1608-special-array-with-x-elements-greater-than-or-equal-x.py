#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1608-special-array-with-x-elements-greater-than-or-equal-x.py
# @Date   : 2021/05/05
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def specialArray(self, nums: List[int]) -> int:
        n_len = len(nums)

        if n_len == 0:
            return -1

        nums = sorted(nums)
        if nums[0] >= n_len:
            return n_len

        for x in range(n_len):
            r_idx = n_len - x - 1
            if nums[r_idx] < x:
                if x > 0:
                    if nums[r_idx + 1] < x:
                        return -1
                return x
        return -1


if __name__ == '__main__':
    s = Solution()
    # 2
    r = s.specialArray([3, 5])
    print(2 == r, r)
    # -1
    r = s.specialArray([0, 0])
    print(-1 == r, r)
    # 3
    r = s.specialArray([0, 4, 3, 0, 4])
    print(3 == r, r)
    # -1
    r = s.specialArray([3, 6, 7, 7, 0])
    print(-1 == r, r)
