#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1903-largest-odd-number-in-string.py
# @Author : yuweiwei7 (yuweiwei3@jd.com)
# @Date   : 2021-06-21


class Solution:
    def largestOddNumber(self, num: str) -> str:
        num_len = len(num)
        j = num_len - 1
        while j >= 0:
            if ord(num[j]) % 2 != 0:
                break
            j -= 1
        return num[0:j+1]


if __name__ == '__main__':
    s = Solution()
    # 5
    print(s.largestOddNumber('52'))
    # ''
    print(s.largestOddNumber('4206'))
    # 35427
    print(s.largestOddNumber('35427'))
