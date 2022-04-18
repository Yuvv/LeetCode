#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0121-best-time-to-buy-and-sell-stock.py
# @Date   : 2019/06/30
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        last_min = 1e100
        cur_max = 0
        # 循环数组，找出最小值与右边的值的diff的最大值
        for p in prices:
            cur_value = p - last_min
            if cur_max < cur_value:
                cur_max = cur_value
            if p < last_min:
                last_min = p
        return cur_max


if __name__ == "__main__":
    s = Solution()
    print(s.maxProfit([7, 1, 5, 3, 6, 4]))  # 5 expected
    print(s.maxProfit([7, 6, 4, 3, 1]))  # 0 expected
