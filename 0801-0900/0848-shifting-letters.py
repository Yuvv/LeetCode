#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0848-shifting-letters.py
# @Date   : 2021/04/14
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def shiftingLetters(self, S: str, shifts: List[int]) -> str:
        s_len = len(S)
        i = s_len - 1
        cum_sum = 0
        rl = list()
        a_val = ord('a')
        while i >= 0:
            cum_sum += shifts[i]
            cum_sum %= 26
            c = chr((ord(S[i]) + cum_sum - a_val) % 26 + a_val)
            rl.append(c)
            i -= 1

        rl.reverse()
        return ''.join(rl)


if __name__ == '__main__':
    s = Solution()
    # rpl
    print(s.shiftingLetters('abc', [3, 5, 9]))
