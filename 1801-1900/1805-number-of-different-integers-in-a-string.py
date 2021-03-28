#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1805-number-of-different-integers-in-a-string.py
# @Date   : 2021/03/28
# @Author : Yuvv <yuvv_th@outlook.com>


class Solution:
    def numDifferentIntegers(self, word: str) -> int:
        word_len = len(word)
        num_set = set()
        i, last_i = 0, 0
        while i < word_len:
            while i < word_len and word[i] >= '0' and word[i] <= '9':
                i += 1
            if i > last_i:
                num_set.add(int(word[last_i:i]))
            while i < word_len and (word[i] < '0' or word[i] > '9'):
                i += 1
            last_i = i

        return len(num_set)


if __name__ == '__main__':
    s = Solution()
    # 3
    print(s.numDifferentIntegers('a123bc34d8ef34'))
    # 2
    print(s.numDifferentIntegers('leet1234code234'))
    # 1
    print(s.numDifferentIntegers('a1b01c001'))
