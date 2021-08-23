#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0717-1-bit-and-2-bit-characters.py
# @Date   : 2021/08/23
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def isOneBitCharacter(self, bits: List[int]) -> bool:
        b_len = len(bits)
        i = 0
        flag = False
        while i < b_len:
            if bits[i] == 0:
                i += 1
                flag = i == b_len
            elif bits[i] == 1:
                i += 1
                if i >= b_len:
                    return False
                if bits[i] != 0 and bits[i] != 1:
                    return False
                i += 1
            else:
                return False
        return flag


if __name__ == '__main__':
    s = Solution()
    # true
    print(s.isOneBitCharacter([1, 0, 0]))
    # false
    print(s.isOneBitCharacter([1, 1, 1, 0]))
