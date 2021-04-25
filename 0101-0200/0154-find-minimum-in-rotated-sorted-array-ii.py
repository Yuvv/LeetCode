#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0153-find-minimum-in-rotated-sorted-array-ii.py
# @Date   : 2021/04/21
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:
        b, e = 0, len(nums) - 1

        # rotated
        while e > b:
            if nums[e] > nums[b]:
                # ascending
                return nums[b]

            # deduplicate
            while e > b and nums[e] == nums[b]:
                b += 1

            mid = (b + e) // 2
            if e - b == 1:
                return min(nums[b], nums[e])
            elif nums[mid] >= nums[b]:
                if nums[b] > nums[e]:
                    b = mid
                else:
                    e = mid
            elif nums[mid] <= nums[e]:
                e = mid
            else:
                print('err')

        return nums[b]


if __name__ == '__main__':
    s = Solution()
    # 1
    print(s.findMin([10, 1, 10, 10, 10]) == 1)
    # 0
    print(s.findMin([2, 0, 1, 1, 1]) == 0)
    # 1
    print(s.findMin([1, 3, 5]) == 1)
    # 1
    print(s.findMin([3, 1, 1]) == 1)
    # 0
    print(s.findMin([0, 1, 1, 0]) == 0)
    # 0
    print(s.findMin([2, 2, 2, 0, 1]) == 0)
    # 0
    print(s.findMin([2, 2, 2, 0, 1, 2, 2]) == 0)
    # 0
    print(s.findMin([2, 2, 2, 0, 0, 1, 2, 2]) == 0)
    # 0
    print(s.findMin([2, 2, 2, 2, 0]) == 0)
    # 0
    print(s.findMin([0, 2, 2, 2, 2]) == 0)
    # 3
    print(s.findMin([3, 3, 3, 3, 3]) == 3)
