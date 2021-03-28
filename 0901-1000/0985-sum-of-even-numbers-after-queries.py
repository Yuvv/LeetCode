#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0985-sum-of-even-numbers-after-queries.py
# @Date   : 2021/03/28
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def sumEvenAfterQueries(self, A: List[int], queries: List[List[int]]) -> List[int]:
        r = sum(e for e in A if (e & 1) == 0)
        rl = list()
        for q in queries:
            if (A[q[1]] & 1) == 0:
                r -= A[q[1]]

            A[q[1]] += q[0]
            if (A[q[1]] & 1) == 0:
                r += A[q[1]]
            rl.append(r)

        return rl


if __name__ == '__main__':
    s = Solution()
    # [8,6,2,4]
    print(s.sumEvenAfterQueries([1, 2, 3, 4], [[1, 0], [-3, 1], [-4, 0], [2, 3]]))
