#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1497-check-if-array-pairs-are-divisible-by-k.py
# @Date   : 2021/04/07
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def canArrange(self, arr: List[int], k: int) -> bool:
        m = dict()
        for each in arr:
            each %= k
            m[each] = m.get(each, 0) + 1
        while len(m) > 0:
            key, value = m.popitem()
            otherKey = (k - key) % k
            if otherKey == key and value % 2 == 0:
                continue
            if otherKey not in m:
                return False
            otherValue = m.pop(otherKey)
            if otherValue != value:
                return False
        return True


if __name__ == '__main__':
    s = Solution()
    # true
    print(s.canArrange([1, 2, 3, 4, 5, 10, 6, 7, 8, 9], 5))
    # true
    print(s.canArrange([1, 2, 3, 4, 5, 6], 7))
    # false
    print(s.canArrange([
        1,
        2,
        3,
        4,
        5,
    ], 10))
