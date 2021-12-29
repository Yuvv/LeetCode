#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 2094-finding-3-digit-even-numbers.py
# @Author : Yuvv (yuvv_th@outlook.com)
# @Date   : 2021-12-29

from typing import List


class Solution:
    def add(self, res: List[int], a: int, b: int, c: int):
        if a == 0:
            return
        if c % 2 == 1:
            return
        x = a * 100 + b * 10 + c
        res.add(x)

    def findEvenNumbers(self, digits: List[int]) -> List[int]:
        res = set()
        d_len = len(digits)
        for i in range(d_len - 2):
            a = digits[i]
            for j in range(i + 1, d_len - 1):
                b = digits[j]
                for k in range(j + 1, d_len):
                    c = digits[k]
                    self.add(res, a, b, c)
                    self.add(res, a, c, b)
                    self.add(res, b, a, c)
                    self.add(res, b, c, a)
                    self.add(res, c, b, a)
                    self.add(res, c, a, b)

        return list(sorted(res))


if __name__ == "__main__":
    s = Solution()
    # [102,120,130,132,210,230,302,310,312,320]
    print(s.findEvenNumbers([2, 1, 3, 0]))
    # [222,228,282,288,822,828,882]
    print(s.findEvenNumbers([2, 2, 8, 8, 2]))
    # []
    print(s.findEvenNumbers([3, 7, 5]))
