#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 2114-maximum-number-of-words-found-in-sentences.py
# @Author : Yuvv (yuvv_th@outlook.com)
# @Date   : 2021-12-26


from typing import List

class Solution:
    def mostWordsFound(self, sentences: List[str]) -> int:
        # return max(map(lambda s: len(s.split(' ')), sentences))
        return max(map(lambda s: s.count(' '), sentences)) + 1


if __name__ == '__main__':
    s = Solution()
    # 6
    print(s.mostWordsFound(["alice and bob love leetcode", "i think so too", "this is great thanks very much"]))
    # 3
    print(s.mostWordsFound(["please wait", "continue to fight", "continue to win"]))
