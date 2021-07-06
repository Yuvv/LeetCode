#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1338-reduce-array-size-to-the-half.py
# @Date   : 2021/07/06
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def minSetSize(self, arr: List[int]) -> int:
        arr_len = len(arr)
        half_arr_len = arr_len / 2
        cnt_map = {}
        for e in arr:
            cnt_map[e] = cnt_map.get(e, 0) + 1
        cnt_values = sorted(cnt_map.values(), reverse=True)
        sum_val = 0
        for i, e in enumerate(cnt_values):
            sum_val += e
            if sum_val >= half_arr_len:
                return i + 1
        return 0


if __name__ == '__main__':
    s = Solution()
    # 2
    print(s.minSetSize([3, 3, 3, 3, 5, 5, 5, 2, 2, 7]))
    # 1
    print(s.minSetSize([7, 7, 7, 7, 7, 7]))
    # 1
    print(s.minSetSize([1, 9]))
    # 1
    print(s.minSetSize([100, 100, 3, 7]))
