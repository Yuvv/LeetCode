#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0122-best-time-to-buy-and-sell-stock-ii.py
# @Date   : 2019/06/30
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        cur_max = 0
        last_val = None
        for p in prices:
            if last_val is not None:
                if p > last_val:
                    cur_max += p - last_val
            last_val = p

        return cur_max


if __name__ == "__main__":
    s = Solution()
    print(s.maxProfit([7, 1, 5, 3, 6, 4]))  # 7 expected
    print(s.maxProfit([1, 2, 3, 4, 5]))  # 4 expected
    print(s.maxProfit([7, 6, 4, 3, 1]))  # 0 expected
