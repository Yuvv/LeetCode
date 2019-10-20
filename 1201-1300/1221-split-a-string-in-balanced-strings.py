#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1221-split-a-string-in-balanced-strings.py
# @Date   : 2019/10/20
# @Author : Yuvv <yuvv_th@outlook.com>


class Solution:
    def balancedStringSplit(self, s: str) -> int:
        total = 0
        r_count = 0
        l_count = 0
        for c in s:
            if c == 'R':
                r_count += 1
            elif c == 'L':
                l_count += 1
            if r_count == l_count:
                total += 1

        return total


if __name__ == "__main__":
    s = Solution()
    # 4
    print(s.balancedStringSplit('RLRRLLRLRL'))
    # 3
    print(s.balancedStringSplit('RLLLLRRRLR'))
    # 1
    print(s.balancedStringSplit('LLLLRRRR'))
