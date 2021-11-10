#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 2062-count-vowel-substrings-of-a-string.py
# @Author : Yuvv (yuvv_th@outlook.com)
# @Date   : 2021-11-10


class Solution:
    def countVowelSubstrings(self, word: str) -> int:
        word_len = len(word)
        cnt = 0
        i = 0
        vowel = ('a', 'e', 'i', 'o', 'u')
        while i < word_len:
            if word[i] in vowel:
                j = i
                vs = set()
                # simple and brute-force
                while j < word_len and word[j] in vowel:
                    vs.add(word[j])
                    if len(vs) == 5:
                        cnt += 1
                    j += 1
            i += 1

        return cnt


if __name__ == '__main__':
    s = Solution()
    # 2
    print(s.countVowelSubstrings('aeiouu'))
    # 0
    print(s.countVowelSubstrings('unicornarihan'))
    # 7
    print(s.countVowelSubstrings('cuaieuouac'))
    # 0
    print(s.countVowelSubstrings('bbaeixoubb'))
