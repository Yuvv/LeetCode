#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0806-number-of-lines-to-write-string.py
# @Date   : 2020/01/05
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def numberOfLines(self, widths: List[int], txt: str) -> List[int]:
        line_count = 1
        cur_line_width = 0
        for c in txt:
            # ord('a') == 97
            c_width = widths[ord(c) - 97]
            cur_line_width += c_width
            if cur_line_width > 100:
                cur_line_width = c_width
                line_count += 1

        return [line_count, cur_line_width]


if __name__ == "__main__":
    s = Solution()
    # [3, 60] expected
    print(
        s.numberOfLines(
            [10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10],
            "abcdefghijklmnopqrstuvwxyz"))
    # [2, 4]
    print(
        s.numberOfLines(
            [4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10],
            "bbbcccdddaaa"))
