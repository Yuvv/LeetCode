#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0081-search-in-rotated-sorted-array-ii.py
# @Date   : 2021/03/10
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        nums_len = len(nums)
        begin = 0
        end = nums_len - 1
        while end >= begin:
            mid = (begin + end) // 2
            if nums[mid] == target:
                return True
            if nums[mid] == nums[begin]:
                begin += 1
                continue
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
        return False


if __name__ == "__main__":
    s = Solution()
    print(s.search([1, 3], 3))  # true expected
    print(s.search([3, 1], 1))  # true expected
    print(s.search([4, 5, 6, 7, 8, 1, 2, 3], 8))  # true expected
    print(s.search([4, 5, 6, 7, 0, 1, 2, 3], 0))  # true expected
    print(s.search([7, 8, 9, 11, 13, 1, 3, 5], 6))  # false expected
    print(s.search([7, 8, 9, 11, 13, 1, 3, 5], 1))  # true expected
    print(s.search([7, 8, 9, 11, 1, 3, 5], 7))  # true expected
    print(s.search([7, 8, 9, 11, 1, 3, 5, 6], 6))  # true expected
    print(s.search([1, 0, 1, 1, 1], 0))  # true expected
    print(s.search([1, 1, 1, 0, 1], 0))  # true expected
