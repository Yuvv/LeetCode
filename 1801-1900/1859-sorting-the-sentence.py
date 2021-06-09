#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1859-sorting-the-sentence.py
# @Date   : 2021/06/09
# @Author : Yuvv <yuvv_th@outlook.com>


class Solution:
    def sortSentence(self, s: str) -> str:
        return ' '.join(map(lambda x: x[:-1], sorted(s.split(' '), key=lambda x: x[-1])))


if __name__ == '__main__':
    s = Solution()
    # "This is a sentence"
    print(s.sortSentence("is2 sentence4 This1 a3"))
    # "Me Myself and I"
    print(s.sortSentence("Myself2 Me1 I4 and3"))
