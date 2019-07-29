#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0041-first-missing-positive.py
# @Date   : 2019/07/30
# @Author : Yuvv <yuvv_th@outlook.com>


from typing import List


class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        s = set()
        maybe = 1
        for num in nums:
            if num > 0:
                s.add(num)
                if num == maybe:
                    while maybe in s:
                        maybe += 1
        return maybe


if __name__ == "__main__":
    s = Solution()
    print(s.firstMissingPositive([1, 2, 0]))  # 3 expected
    print(s.firstMissingPositive([3, 4, -1, 1]))  # 2 expected
    print(s.firstMissingPositive([7, 8, 9, 11, 12]))  # 1 expected
