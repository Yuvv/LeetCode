#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1160-find-words-that-can-be-formed-by-characters.py
# @Date   : 2019/08/20
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def countCharacters(self, words: List[str], chars: str) -> int:
        cd = dict()
        for c in chars:
            cd[c] = cd.get(c, 0) + 1

        result = 0
        for word in words:
            wd = dict()
            for c in word:
                if c not in cd:
                    break
                c_count = wd.get(c, 0)
                if c_count >= cd[c]:
                    break
                wd[c] = c_count + 1
            else:
                result += len(word)
        return result


if __name__ == "__main__":
    s = Solution()
    # 6 expected
    print(s.countCharacters(["cat", "bt", "hat", "tree"], "atach"))
    # 10 expected
    print(s.countCharacters(["hello", "world", "leetcode"], "welldonehoneyr"))
