#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1202-smallest-string-with-swaps.py
# @Date   : 2021/05/05
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List, Dict, Set


class Solution:
    '''
    这一题的解题思路：
    - 首先要搞清楚连通集。在这一题里，如果 [a, b] 能够交换，[b, c] 能够交换，[a, c] 也就能够交换
      abc 就在一个连通集里面。其它情况同理。
    - 然后我们要做的就是找到所有的连通集。
    - 再将连通集里面的字符按照字母顺序排序，填入各个位置即可
    '''
    def smallestStringWithSwaps(self, s: str, pairs: List[List[int]]) -> str:
        # build groups
        group_dict: Dict[int, Set[int]] = dict()
        groups: List[Set[int]] = []
        for u, v in pairs:
            if u in group_dict:
                group_dict[u].add(v)
                if v not in group_dict:
                    group_dict[v] = group_dict[u]
            elif v in group_dict:
                group_dict[v].add(u)
                if u not in group_dict:
                    group_dict[u] = group_dict[v]
            else:
                new_group = set([u, v])
                group_dict[u] = new_group
                group_dict[v] = new_group
                groups.append(new_group)

            # merge group
            ug, vg = group_dict[u], group_dict[v]
            if ug is not vg:
                if len(ug) < len(vg):
                    ug, vg = vg, ug
                groups.remove(vg)
                for e in vg:
                    ug.add(e)
                    group_dict[e] = ug

        # get new char arr
        c_arr = [i for i in s]
        for group in groups:
            for idx, value in zip(sorted(group), sorted([c_arr[i] for i in group])):
                c_arr[idx] = value

        # join
        return ''.join(c for c in c_arr)


if __name__ == '__main__':
    s = Solution()
    # bacd
    r = s.smallestStringWithSwaps('dcab', [[0, 3], [1, 2]])
    print('bacd' == r, r)
    # abcd
    r = s.smallestStringWithSwaps('dcab', [[0, 3], [1, 2], [0, 2]])
    print('abcd' == r, r)
    # abc
    r = s.smallestStringWithSwaps('cba', [[0, 1], [1, 2]])
    print('abc' == r, r)
    # ffkqttkv
    r = s.smallestStringWithSwaps('fqtvkfkt', [[2, 4], [5, 7], [1, 0], [0, 0], [4, 7], [0, 3], [4, 1], [1, 3]])
    print('ffkqttkv' == r, r)
