#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0042-trapping-rain-water.py
# @Date   : 2019/07/30
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        height_len = len(height)
        if height_len == 0:
            return 0
        left_max_i = 0
        total = 0
        for i in range(1, height_len):
            if height[i] > height[left_max_i]:
                left_max_i = i
            else:
                total += height[left_max_i] - height[i]
        right_max_j = height_len - 1
        for j in range(right_max_j, left_max_i, -1):
            if height[j] < height[right_max_j]:
                total -= height[left_max_i] - height[right_max_j]
            else:
                total -= height[left_max_i] - height[j]
                right_max_j = j
        return total


if __name__ == "__main__":
    s = Solution()
    # 6 expcted
    print(s.trap([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]))
    # 0 expcted
    print(s.trap([1, 2, 3, 4, 3, 1]))
    # 26 expcted
    print(s.trap([0, 1, 0, 3, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1, 5, 0, 3, 1, 4]))
