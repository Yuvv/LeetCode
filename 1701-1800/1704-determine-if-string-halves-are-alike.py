#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1704-determine-if-string-halves-are-alike.py
# @Date   : 2021/01/24
# @Author : Yuvv <yuvv_th@outlook.com>


class Solution:
    VOWELS = set(('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'))

    def halvesAreAlike(self, s: str) -> bool:
        s_len = len(s)
        half_len = s_len // 2
        vowel_count = 0
        for i, c in enumerate(s):
            if c not in Solution.VOWELS:
                continue
            if i < half_len:
                vowel_count += 1
            else:
                vowel_count -= 1
        return vowel_count == 0


if __name__ == "__main__":
    s = Solution()
    # true
    print(s.halvesAreAlike('book'))
    # true
    print(s.halvesAreAlike('AbCdEfGh'))
    # false
    print(s.halvesAreAlike('MerryChristmas'))
