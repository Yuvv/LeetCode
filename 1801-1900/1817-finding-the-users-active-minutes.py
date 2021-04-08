#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1817-finding-the-users-active-minutes.py
# @Date   : 2021/04/09
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def findingUsersActiveMinutes(self, logs: List[List[int]], k: int) -> List[int]:
        m = dict()
        for each in logs:
            s = m.get(each[0], set())
            s.add(each[1])
            m[each[0]] = s
        mm = dict()
        for v in m.values():
            mm[len(v)] = mm.get(len(v), 0) + 1
        return [mm.get(i, 0) for i in range(1, k + 1)]


if __name__ == '__main__':
    s = Solution()
    # [0,2,0,0,0]
    print(s.findingUsersActiveMinutes([[0, 5], [1, 2], [0, 2], [0, 5], [1, 3]], k=5))
