#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1742-maximum-number-of-balls-in-a-box.py
# @Date   : 2021/03/07
# @Author : Yuvv <yuvv_th@outlook.com>


class Solution:
    def countBalls(self, lowLimit: int, highLimit: int) -> int:
        m = dict()
        for i in range(lowLimit, highLimit + 1):
            s = 0
            while i > 0:
                s += i % 10
                i //= 10
            m[s] = m.get(s, 0) + 1

        return max(m.values())


if __name__ == '__main__':
    s = Solution()
    # 2 expected
    print(s.countBalls(1, 10))
    # 2 expected
    print(s.countBalls(5, 15))
    # 2 expected
    print(s.countBalls(19, 28))
