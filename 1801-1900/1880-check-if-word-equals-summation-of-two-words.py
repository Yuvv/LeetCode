#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1880-check-if-word-equals-summation-of-two-words.py
# @Date   : 2021/06/09
# @Author : Yuvv <yuvv_th@outlook.com>


class Solution:
    def to_int(self, word: str) -> int:
        r = 0
        for c in word:
            r = r * 10 + ord(c) - 97
        return r

    def isSumEqual(self, firstWord: str, secondWord: str, targetWord: str) -> bool:
        return self.to_int(firstWord) + self.to_int(secondWord) == self.to_int(targetWord)


if __name__ == '__main__':
    s = Solution()
    # true
    print(s.isSumEqual('acb', 'cba', 'cdb'))
    # false
    print(s.isSumEqual('aaa', 'a', 'aab'))