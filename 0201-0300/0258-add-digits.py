#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0258-add-digits.py
# @Date   : 2021/06/27
# @Author : Yuvv <yuvv_th@outlook.com>


class Solution:
    def addDigits(self, num: int) -> int:
        while num > 9:
            digit_sum = 0
            while num > 0:
                digit_sum += num % 10
                num //= 10
            num = digit_sum
        return num


if __name__ == '__main__':
    s = Solution()
    # 2
    print(s.addDigits(38))
    # 0
    print(s.addDigits(0))
