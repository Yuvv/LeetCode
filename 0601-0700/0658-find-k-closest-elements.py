#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0658-find-k-closest-elements.py
# @Date   : 2021/07/02
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        arr_len = len(arr)
        # finx index of x
        beg, end = 0, arr_len - 1
        i_of_x = -1
        if x < arr[0]:
            i_of_x = 0
        elif x > arr[end]:
            i_of_x = end
        else:
            while end >= beg:
                mid = (beg + end) // 2
                if arr[mid] > x:
                    end = mid - 1
                elif arr[mid] < x:
                    beg = mid + 1
                else:
                    i_of_x = mid
                    break
            diff_1 = arr[beg] - x
            diff_2 = x - arr[end]
            if diff_2 <= diff_1:
                i_of_x = end
            else:
                i_of_x = beg
        # get boundary
        beg = max(0, i_of_x - k)
        end = min(arr_len - 1, i_of_x + k)
        while end < arr_len and arr[end] == x:
            end += 1
        while beg > 0 and arr[beg] == x:
            beg -= 1
        end = min(arr_len - 1, end)
        beg = max(0, beg)

        # shrink range
        while end - beg + 1 > k:
            diff_beg = x - arr[beg]
            diff_end = arr[end] - x
            if diff_beg <= diff_end:
                end -= 1
            else:
                beg += 1
        return arr[beg:end + 1]


if __name__ == '__main__':
    s = Solution()
    # [1,2,3,4]
    print(s.findClosestElements([1, 2, 3, 4, 5], 4, 3))
    # [1,2,3,4]
    print(s.findClosestElements([1, 2, 3, 4, 5], 4, -1))
    # [2,3,3,3]
    print(s.findClosestElements([1, 2, 3, 3, 3, 4, 4, 5], 4, 3))
    # [3,3,4,4,4]
    print(s.findClosestElements([1, 2, 3, 3, 3, 4, 4, 4, 5], 5, 4))
    # [10]
    print(s.findClosestElements([1, 1, 1, 10, 10, 10], 1, 9))
    # [1,1]
    print(s.findClosestElements([1, 1, 1, 10, 10, 10], 2, 3))
