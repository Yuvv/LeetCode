#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0455-assign-cookies.py
# @Date   : 2021/07/02
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        s_g = sorted(g)
        s_s = sorted(s)

        gi = len(s_g) - 1
        si = len(s_s) - 1
        cnt = 0
        while gi >= 0 and si >= 0:
            if s_s[si] >= s_g[gi]:
                cnt += 1
                gi -= 1
                si -= 1
            else:
                gi -= 1
        return cnt


if __name__ == '__main__':
    s = Solution()
    # 1
    print(s.findContentChildren([1, 2, 3], [1, 1]))
    # 2
    print(s.findContentChildren([1, 2], [1, 2, 3]))
