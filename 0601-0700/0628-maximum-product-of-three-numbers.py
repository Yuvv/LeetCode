#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0628-maximum-product-of-three-numbers.py
# @Date   : 2021/04/19
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def maximumProduct(self, nums: List[int]) -> int:
        nLen = len(nums)
        # max 3
        a, b, c = sorted((nums[0], nums[1], nums[2]), reverse=True)
        # min 2
        d, e = c, b
        i = 3
        while i < nLen:
            if nums[i] > a:
                a, b, c = nums[i], a, b
            elif nums[i] > b:
                b, c = nums[i], b
            elif nums[i] > c:
                c = nums[i]

            if nums[i] < d:
                d, e = nums[i], d
            elif nums[i] < e:
                e = nums[i]
            i += 1

        if a > 0 and d < 0 and e < 0:
            mm = d * e
            nn = b * c
            if mm > nn:
                return a * mm

        return a * b * c


if __name__ == '__main__':
    s = Solution()
    # 6
    print(s.maximumProduct([1, 2, 3]))
    # 24
    print(s.maximumProduct([1, 2, 3, 4]))
    # -6
    print(s.maximumProduct([-1, -2, -3]))
    # 39200
    print(s.maximumProduct([-100, -98, -1, 2, 3, 4]))
    # 6
    print(s.maximumProduct([-1, -2, 1, 2, 3]))
    # 1120
    print(s.maximumProduct([-8, -7, -2, 10, 20]))
