#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1539-kth-missing-positive-number.py
# @Date   : 2021/03/28
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        arr_len = len(arr)
        arr = sorted(arr)
        i = 0
        c = 1
        while k > 0:
            while i < arr_len and arr[i] == c:
                c += 1
                i += 1
            c += 1
            k -= 1
        return c - 1


if __name__ == '__main__':
    s = Solution()
    # 9
    print(s.findKthPositive([2, 3, 4, 7, 11], 5))
    # 6
    print(s.findKthPositive([1, 2, 3, 4], 2))
