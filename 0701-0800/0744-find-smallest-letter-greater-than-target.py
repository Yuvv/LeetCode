#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0744-find-smallest-letter-greater-than-target.py
# @Date   : 2021/08/27
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        for e in letters:
            if e > target:
                return e
        return letters[0]


if __name__ == '__main__':
    s = Solution()
    # 'c'
    print(s.nextGreatestLetter(['c', 'f', 'j'], 'a'))
    # 'c'
    print(s.nextGreatestLetter(['c', 'f', 'j'], 'j'))
    # 'f'
    print(s.nextGreatestLetter(['c', 'f', 'j'], 'd'))
    # 'j'
    print(s.nextGreatestLetter(['c', 'f', 'j'], 'g'))
