#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0605-can-place-flowers.py
# @Date   : 2021/07/22
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        f_len = len(flowerbed)
        for i, e in enumerate(flowerbed):
            if e == 0:
                if i == 0:
                    if i + 1 < f_len:
                        if flowerbed[i + 1] == 0:
                            flowerbed[i] = 1
                            n -= 1
                    else:
                        flowerbed[i] = 1
                        n -= 1
                elif i == f_len - 1:
                    if flowerbed[i - 1] == 0:
                        flowerbed[i] = 1
                        n -= 1
                else:
                    if flowerbed[i - 1] == 0 and flowerbed[i + 1] == 0:
                        flowerbed[i] = 1
                        n -= 1
        return n <= 0


if __name__ == '__main__':
    s = Solution()
    # true
    print(s.canPlaceFlowers([1, 0, 0, 0, 1], 1))
    # false
    print(s.canPlaceFlowers([0, 1, 0, 0, 0, 1], 2))
    # true
    print(s.canPlaceFlowers([0, 0, 1, 0, 0, 0, 1], 2))
    # false
    print(s.canPlaceFlowers([1, 0, 0, 0, 1], 2))
    # false
    print(s.canPlaceFlowers([1, 0, 0, 0, 1, 0], 2))
    # true
    print(s.canPlaceFlowers([1, 0, 0, 0, 1, 0, 0], 2))
