#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1287-element-appearing-more-than-25-in-sorted-array.py
# @Date   : 2021/05/17
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def get_range_len(self, arr: List[int], bi, i, ei):
        """
        get end point
        """
        # get real bi
        tmp = i
        while arr[bi] < arr[i]:
            m = (bi + tmp) // 2
            if m > 0 and arr[m] == arr[i] and arr[m - 1] < arr[i]:
                bi = m
                break
            if arr[m] == arr[i]:
                tmp = m - 1
            elif arr[m] < arr[i]:
                bi = m + 1

        # get real ei
        tmp = i
        while arr[i] < arr[ei]:
            m = (ei + tmp) // 2
            if m < ei and arr[m] == arr[i] and arr[m + 1] > arr[i]:
                ei = m
                break
            if arr[m] == arr[i]:
                tmp = m + 1
            elif arr[m] > arr[i]:
                ei = m - 1

        return ei - bi + 1

    def findSpecialInteger(self, arr: List[int]) -> int:
        arr_len = len(arr)
        ai = int(arr_len * 0.25)
        bi = int(arr_len * 0.5)
        ci = int(arr_len * 0.75)
        l_ai = self.get_range_len(arr, 0, ai, bi)
        if l_ai > ai:
            return arr[ai]
        l_bi = self.get_range_len(arr, ai, bi, ci)
        if l_bi > ai:
            return arr[bi]
        l_ci = self.get_range_len(arr, bi, ci, arr_len - 1)
        if l_ci > ai:
            return arr[ci]
        return arr[ci + 1]


if __name__ == '__main__':
    s = Solution()
    # 6
    print(s.findSpecialInteger([1, 2, 2, 6, 6, 6, 6, 7, 10]))
    # 1
    print(s.findSpecialInteger([1, 1]))
    # 1
    print(s.findSpecialInteger([1, 1, 2, 3, 4, 5, 6]))
    # 3
    print(s.findSpecialInteger([1, 2, 3, 3, 4, 5, 6]))
    # 5
    print(s.findSpecialInteger([1, 2, 3, 4, 5, 5, 6]))
    # 6
    print(s.findSpecialInteger([1, 2, 3, 4, 5, 6, 6]))
