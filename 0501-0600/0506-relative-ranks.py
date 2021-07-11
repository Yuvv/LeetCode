#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0506-relative-ranks.py
# @Date   : 2021/07/11
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def findRelativeRanks(self, score: List[int]) -> List[str]:
        d = {e: i for i, e in enumerate(sorted(score, reverse=True))}
        m = {0: 'Gold Medal', 1: 'Silver Medal', 2: 'Bronze Medal'}
        return [m.get(d[e], str(d[e] + 1)) for e in score]


if __name__ == '__main__':
    s = Solution()
    # ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
    print(s.findRelativeRanks([5, 4, 3, 2, 1]))
    # ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
    print(s.findRelativeRanks([10, 3, 8, 9, 4]))
