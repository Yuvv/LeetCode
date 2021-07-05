#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0482-license-key-formatting.py
# @Date   : 2021/07/05
# @Author : Yuvv <yuvv_th@outlook.com>


class Solution:
    def licenseKeyFormatting(self, s: str, k: int) -> str:
        s_len = len(s)
        cnt = 0
        ch_list = list()
        for i in range(s_len - 1, -1, -1):
            if s[i] == '-':
                continue
            ch_list.append(s[i].upper())
            cnt += 1
            if cnt % k == 0:
                ch_list.append('-')

        if len(ch_list) > 0 and ch_list[-1] == '-':
            ch_list[-1] = ''

        return ''.join(reversed(ch_list))


if __name__ == '__main__':
    s = Solution()
    # 5F3Z-2E9W
    print(s.licenseKeyFormatting('5F3Z-2e-9-w', 4))
    # 2-5G-3J
    print(s.licenseKeyFormatting('2-5g-3-J', 2))
