#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 2042-check-if-numbers-are-ascending-in-a-sentence.py
# @Author : Yuvv (yuvv_th@outlook.com)
# @Date   : 2021-10-25


class Solution:
    def areNumbersAscending(self, s: str) -> bool:
        v = -1
        for e in map(int, filter(lambda s : s and s.isdigit(), s.split(' '))):
            if e <= v:
                return False
            v = e
        return True


if __name__ == '__main__':
    s = Solution()
    # true
    print(s.areNumbersAscending('1 box has 3 blue 4 red 6 green and 12 yellow marbles'))
    # false
    print(s.areNumbersAscending('hello world 5 x 5'))
    # false
    print(s.areNumbersAscending('sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s'))
    # true
    print(s.areNumbersAscending('4 5 11 26'))
