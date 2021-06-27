#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0292-nim-game.py
# @Date   : 2021/06/27
# @Author : Yuvv <yuvv_th@outlook.com>


class Solution:
    def canWinNim(self, n: int) -> bool:
        return n % 4 != 0


if __name__ == '__main__':
    s = Solution()
    # False
    print(s.canWinNim(4))
    # True
    print(s.canWinNim(6))