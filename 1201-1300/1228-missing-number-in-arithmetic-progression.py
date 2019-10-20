#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1228-missing-number-in-arithmetic-progression.py
# @Date   : 2019/10/20
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def missingNumber(self, arr: List[int]) -> int:
        arr_len = len(arr)
        diff = (arr[-1] - arr[0]) // arr_len
        i = 1
        while i < arr_len:
            if arr[i] - arr[i - 1] != diff:
                return arr[i - 1] + diff
            i += 1
        return arr[0] - diff



if __name__ == "__main__":
    s = Solution()
    # 9
    print(s.missingNumber([5, 7, 11, 13]))
    # 14
    print(s.missingNumber([15, 13, 12]))
