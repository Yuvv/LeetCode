#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0033-search-in-rotated-sorted-array.py
# @Date   : 2019/07/01
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        nums_len = len(nums)
        begin = 0
        end = nums_len - 1
        while end >= begin:
            mid = (begin + end) // 2
            if nums[mid] == target:
                return mid
            if nums[mid] >= nums[begin]:
                # 从 begin 到 mid 为递增
                if nums[begin] <= target and nums[mid] > target:
                    end = mid - 1
                else:
                    begin = mid + 1
            else:
                # 从 mid 到 end 为递增
                if nums[end] >= target and nums[mid] < target:
                    begin = mid + 1
                else:
                    end = mid - 1
        return -1


if __name__ == "__main__":
    s = Solution()
    print(s.search([1, 3], 3))  # 1 expected
    print(s.search([3, 1], 1))  # 1 expected
    print(s.search([4, 5, 6, 7, 8, 1, 2, 3], 8))  # 4 expected
    print(s.search([4, 5, 6, 7, 0, 1, 2, 3], 0))  # 4 expected
    print(s.search([7, 8, 9, 11, 13, 1, 3, 5], 6))  # -1 expected
    print(s.search([7, 8, 9, 11, 13, 1, 3, 5], 1))  # 5 expected
    print(s.search([7, 8, 9, 11, 1, 3, 5], 7))  # 0 expected
    print(s.search([7, 8, 9, 11, 1, 3, 5, 6], 6))  # 7 expected
