#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0123-best-time-to-buy-and-sell-stock-iii.py
# @Date   : 2021/07/11
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        p_len = len(prices)
        # build dp
        dp_sell_1 = []
        mn_val = prices[0]
        for i in range(p_len):
            mn_val = min(prices[i], mn_val)
            dp_sell_1.append(max(0, prices[i] - mn_val))
        # build dp
        dp_buy_2 = [0 for i in range(p_len)]
        i = p_len - 1
        mx_val = prices[-1]
        while i >= 0:
            mx_val = max(prices[i], mx_val)
            dp_buy_2[i] = max(0, mx_val - prices[i])
            i -= 1
        # build post max
        dp_post_mx = [0 for i in range(p_len)]
        i = p_len - 1
        mx_val = dp_buy_2[-1]
        while i >= 0:
            mx_val = max(mx_val, dp_buy_2[i])
            dp_post_mx[i] = mx_val
            i -= 1
        # only one transaction
        dp_post_mx.append(0)

        # get max value
        mx_val = 0
        for i in range(p_len):
            cur_val = dp_sell_1[i] + dp_post_mx[i + 1]
            mx_val = max(cur_val, mx_val)

        return mx_val


if __name__ == "__main__":
    s = Solution()
    # 7
    print(s.maxProfit([3, 2, 6, 5, 0, 3]))
    # 6 expected
    print(s.maxProfit([3, 3, 5, 0, 0, 3, 1, 4]))
    # 4 expected
    print(s.maxProfit([1, 2, 3, 4, 5]))
    # 0 expected
    print(s.maxProfit([7, 6, 4, 3, 1]))
    # 0 expected
    print(s.maxProfit([7]))
