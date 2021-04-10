#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1791-find-center-of-star-graph.py
# @Date   : 2021/04/09
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def findCenter(self, edges: List[List[int]]) -> int:
        n = 1
        m = dict()
        for edge in edges:
            if edge[0] > n:
                n = edge[0]
            m[edge[0]] = m.get(edge[0], 0) + 1
            if edge[1] > n:
                n = edge[1]
            m[edge[1]] = m.get(edge[1], 0) + 1

        for k, v in m.items():
            if v == n - 1:
                return k
        return None


if __name__ == '__main__':
    s = Solution()
    # 2
    print(s.findCenter([[1, 2], [2, 3], [4, 2]]))
    # 1
    print(s.findCenter([[1, 2], [5, 1], [1, 3], [1, 4]]))
