#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0459-repeated-substring-pattern.py
# @Date   : 2021/07/02
# @Author : Yuvv <yuvv_th@outlook.com>


class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
        s_len = len(s)
        end = s_len - 1
        i = 0
        while i < s_len // 2:
            if s[i] == s[end]:
                sub_s = s[:i + 1]
                rep = True
                for j in range(i + 1, s_len, i + 1):
                    if s[j:j + i + 1] != sub_s:
                        rep = False
                        break
                if rep:
                    return True
            # else
            i += 1

        return False


if __name__ == '__main__':
    s = Solution()
    # true
    print(s.repeatedSubstringPattern('abab'))
    # false
    print(s.repeatedSubstringPattern('aba'))
    # true
    print(s.repeatedSubstringPattern('abcabcabcabc'))
