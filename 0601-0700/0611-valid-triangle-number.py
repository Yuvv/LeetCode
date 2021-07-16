#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0611-valid-triangle-number.py
# @Date   : 2021/07/15
# @Author : Yuvv <yuvv_th@outlook.com>

from itertools import combinations
from typing import List


class Solution:
    def is_valid_triangle(self, a: int, b: int, c: int) -> bool:
        return a + b > c and a + c > b and b + c > a

    # TLE
    def triangleNumber_brute_force(self, nums: List[int]) -> int:
        cnt = 0
        for a, b, c in combinations(nums, 3):
            if self.is_valid_triangle(a, b, c):
                cnt += 1
        return cnt

    def binary_search(self, nums: List[int], beg: int, end: int, target) -> int:
        while beg <= end and end < len(nums):
            mid = (beg + end) // 2
            if nums[mid] >= target:
                # find most left index of target
                end = mid - 1
            else:
                beg = mid + 1

        return beg

    def triangleNumber(self, nums: List[int]) -> int:
        nums = sorted(nums)
        nums_len = len(nums)
        cnt = 0
        for i, a in enumerate(nums):
            if a <= 0 or i >= nums_len - 2:
                continue
            k = i + 2
            for j in range(i + 1, nums_len - 1):
                b = nums[j]
                if b <= 0:
                    continue
                # abs(a-b) < c < a + b
                k = self.binary_search(nums, k, nums_len - 1, a + b)
                cnt += k - j - 1

        return cnt


if __name__ == '__main__':
    s = Solution()
    # 3
    print(s.triangleNumber([2, 2, 3, 4]))
    # 4
    print(s.triangleNumber([4, 2, 3, 4]))
    # 2617
    print(
        s.triangleNumber([
            4, 2, 12, 3, 4, 5, 6, 7, 8, 4, 23, 2, 54, 6, 7, 78, 8, 9, 5, 4, 3, 32, 2, 2, 4, 54, 6, 7, 8, 9, 0, 4, 4, 5,
            6, 6
        ]))
