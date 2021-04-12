#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0941-valid-mountain-array.py
# @Date   : 2021/04/12
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def validMountainArray(self, arr: List[int]) -> bool:
        arr_len = len(arr)
        if arr_len < 3:
            return False

        sort = 0
        i = 1
        # ase
        while i < arr_len and arr[i] > arr[i - 1]:
            i += 1
            sort |= 1
        # desc
        while i < arr_len and arr[i] < arr[i - 1]:
            i += 1
            sort |= 2

        return i >= arr_len and sort == 3


if __name__ == '__main__':
    s = Solution()
    # false
    print(s.validMountainArray([1, 2]))
    # false
    print(s.validMountainArray([2, 5, 5]))
    # true
    print(s.validMountainArray([1, 2, 1]))
    # false
    print(s.validMountainArray([1, 2, 3, 3, 5, 2, 1]))
    # false
    print(s.validMountainArray([1, 2, 3, 5, 2, 5, 1]))
    # false
    print(s.validMountainArray([1, 2, 3, 4, 5]))
    # false
    print(s.validMountainArray([5, 4, 3, 2, 1]))
