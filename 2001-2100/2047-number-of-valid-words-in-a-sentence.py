#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 2047-number-of-valid-words-in-a-sentence.py
# @Author : Yuvv (yuvv_th@outlook.com)
# @Date   : 2021-10-26


class Solution:
    def countValidWords(self, sentence: str) -> int:
        cnt = 0
        for word in sentence.split(' '):
            if not word:
                continue
            if word.isalpha():
                cnt += 1
            elif word in ('!', '.', ','):
                cnt += 1
            elif word.endswith('!') or word.endswith('.') or word.endswith(','):
                word = word[:-1]
                if word.isalpha():
                    cnt += 1
                else:
                    sep = word.split('-')
                    if len(sep) == 2 and sep[0].isalpha() and sep[1].isalpha():
                        cnt += 1
            elif word.find('-') >= 0:
                sep = word.split('-')
                if len(sep) == 2 and sep[0].isalpha() and sep[1].isalpha():
                    cnt += 1

        return cnt


if __name__ == '__main__':
    s = Solution()
    # 3
    print(s.countValidWords('cat and  dog'))
    # 0
    print(s.countValidWords('!this  1-s b8d!'))
    # 5
    print(s.countValidWords('alice and  bob are playing stone-game10'))
    # 6
    print(s.countValidWords('he bought 2 pencils, 3 erasers, and 1  pencil-sharpener.'))
