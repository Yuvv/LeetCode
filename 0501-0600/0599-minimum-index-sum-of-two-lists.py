#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0599-minimum-index-sum-of-two-lists.py
# @Date   : 2021/04/13
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def findRestaurant(self, list1: List[str], list2: List[str]) -> List[str]:
        m1 = dict()
        for i, s in enumerate(list1):
            m1[s] = i
        mn_sum = len(list1) + len(list2)
        m2 = dict()
        for i, s in enumerate(list2):
            if s not in m1:
                continue
            v = m1.get(s) + i
            m2[s] = v
            if v < mn_sum:
                mn_sum = v

        r = list()
        for k, v in m2.items():
            if v == mn_sum:
                r.append(k)
        return r


if __name__ == '__main__':
    s = Solution()
    # ["KFC","Burger King","Tapioca Express","Shogun"]
    print(
        s.findRestaurant(["Shogun", "Tapioca Express", "Burger King", "KFC"],
                         ["KFC", "Burger King", "Tapioca Express", "Shogun"]))
    # ["Shogun"]
    print(
        s.findRestaurant(["Shogun", "Tapioca Express", "Burger King", "KFC"],
                         ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]))
