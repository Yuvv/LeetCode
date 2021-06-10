#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1844-replace-all-digits-with-characters.py
# @Date   : 2021/06/10
# @Author : Yuvv <yuvv_th@outlook.com>


class Solution:
    def replaceDigits(self, s: str) -> str:
        rl = [c for c in s]
        rl_len = len(rl)
        for i in range(1, rl_len, 2):
            rl[i] = chr(ord(rl[i - 1]) + ord(rl[i]) - 48)
        return ''.join(rl)


if __name__ == '__main__':
    s = Solution()
    # abcdef
    print(s.replaceDigits('a1c1e1'))
    # abbdcfdhe
    print(s.replaceDigits('a1b2c3d4e'))
