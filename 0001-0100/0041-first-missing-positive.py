#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0041-first-missing-positive.py
# @Date   : 2019/07/30
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def firstMissingPositive_on_on(self, nums: List[int]) -> int:
        s = set()
        maybe = 1
        for num in nums:
            if num > 0:
                s.add(num)
                if num == maybe:
                    while maybe in s:
                        maybe += 1
        return maybe

    def firstMissingPositive(self, nums: List[int]) -> int:
        """
        time: O(n), space: O(1)
        """
        n_len = len(nums)
        idx = 0
        while idx < n_len:
            if nums[idx] <= 0 or nums[idx] == idx + 1:
                # <= 0 或者已经满足条件的数直接跳过
                idx += 1
                continue
            if nums[idx] > n_len:
                # 比长度还大了，那肯定不是目标结果，先变成负数，作为空位
                nums[idx] = -nums[idx]
                idx += 1
            elif nums[idx] == nums[nums[idx] - 1]:
                # 当前值和目标位置的值已经想等了（有重复元素并且位置是对的，需要淘汰一个值，淘汰后面的）
                if nums[idx] - 1 > idx:
                    nums[nums[idx] - 1] = -nums[nums[idx] - 1]
                else:
                    nums[idx] = -nums[idx]
            else:
                # 否则就把当前位置和目标位置交换就行
                origin = nums[nums[idx] - 1]
                nums[nums[idx] - 1] = nums[idx]
                nums[idx] = origin

        # get first
        target = 1
        for num in nums:
            if target != num:
                break
            target += 1
        return target


if __name__ == "__main__":
    s = Solution()
    print(s.firstMissingPositive([1]))  # 2 expected
    print(s.firstMissingPositive([1, 2, 0]))  # 3 expected
    print(s.firstMissingPositive([3, 4, -1, 1]))  # 2 expected
    print(s.firstMissingPositive([7, 8, 9, 11, 12]))  # 1 expected
    print(s.firstMissingPositive([-2, -1, 3, 8, 5, 4, 1, 5]))  # 2 expected
