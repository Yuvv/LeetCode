#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0852-peak-index-in-a-mountain-array.py
# @Date   : 2021/03/16
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def peakIndexInMountainArray(self, arr: List[int]) -> int:
        arr_len = len(arr)
        for i in range(1, arr_len - 1):
            if arr[i - 1] < arr[i] > arr[i + 1]:
                return i

        return -1


if __name__ == '__main__':
    s = Solution()
    # 1
    print(s.peakIndexInMountainArray([0, 1, 0]))
    # 1
    print(s.peakIndexInMountainArray([0, 2, 1, 0]))
