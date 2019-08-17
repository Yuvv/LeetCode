#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0049-group-anagrams.py
# @Date   : 2019/08/17
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        d = dict()
        for s in strs:
            sorted_s = ''.join(sorted(s))
            if sorted_s not in d:
                d[sorted_s] = []
            d[sorted_s].append(s)
        result = list()
        for v in d.values():
            result.append(v)
        return result


if __name__ == "__main__":
    s = Solution()
    print(s.groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))
    print(s.groupAnagrams(['abab', 'baba', 'abba', 'ababa', 'babab', 'abbaa', '', '']))
    print(s.groupAnagrams(["tao", "pit", "cam", "aid", "pro", "dog"]))
