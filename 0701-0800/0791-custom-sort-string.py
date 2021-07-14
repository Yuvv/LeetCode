#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0791-custom-sort-string.py
# @Date   : 2021/07/14
# @Author : Yuvv <yuvv_th@outlook.com>


class Solution:
    def customSortString(self, order: str, string: str) -> str:
        sort_key = {e: i for i, e in enumerate(order)}
        return ''.join(sorted(string, key=lambda x: sort_key.get(x, ord(x))))


if __name__ == '__main__':
    s = Solution()
    # 'cbad'
    print(s.customSortString('cba', 'abcd'))
