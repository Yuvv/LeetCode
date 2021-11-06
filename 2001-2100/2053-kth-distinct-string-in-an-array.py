#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 2053-kth-distinct-string-in-an-array.PY
# @Author : Yuvv (yuvv_th@outlook.com)
# @Date   : 2021-11-06

from typing import List


class Solution:
    def kthDistinct(self, arr: List[str], k: int) -> str:
        d = {}
        for e in arr:
            d[e] = d.get(e, 0) + 1

        i = 0
        target = ""
        for s, c in d.items():
            if c == 1:
                i += 1
                if i == k:
                    target = s
                    break

        return target


if __name__ == "__main__":
    s = Solution()
    # 'a'
    print(s.kthDistinct(["d", "b", "c", "b", "c", "a"], 2))
    # 'aaa'
    print(s.kthDistinct(["aaa", "aa", "a"], 1))
    # ''
    print(s.kthDistinct(["a", "b", "a"], 3))
