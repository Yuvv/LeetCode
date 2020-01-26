#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1331-rank-transform-of-an-array.py
# @Date   : 2020/01/26
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        numbers = {}
        for i, it in enumerate(sorted(set(arr))):
            numbers[it] = i + 1

        return [numbers[it] for it in arr]


if __name__ == "__main__":
    s = Solution()
    # [4,1,2,3] expected
    print(s.arrayRankTransform([40, 10, 20, 30]))
    # [5,3,4,2,8,6,7,1,1,3] expected
    print(s.arrayRankTransform([37, 12, 28, 9, 100, 56, 80, 5, 5, 12]))
