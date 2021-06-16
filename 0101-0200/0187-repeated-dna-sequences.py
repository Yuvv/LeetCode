#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0187-repeated-dna-sequences.py
# @Date   : 2021/06/16
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        s_len = len(s)
        if s_len <= 10:
            return []

        d = {}
        for i in range(s_len - 9):
            ss = s[i:i + 10]
            d[ss] = d.get(ss, 0) + 1
        return [e[0] for e in filter(lambda x: x[1] > 1, d.items())]


if __name__ == '__main__':
    s = Solution()
    # ["AAAAACCCCC","CCCCCAAAAA"]
    print(s.findRepeatedDnaSequences('AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT'))
    # ["AAAAAAAAAA"]
    print(s.findRepeatedDnaSequences('AAAAAAAAAAAAA'))
