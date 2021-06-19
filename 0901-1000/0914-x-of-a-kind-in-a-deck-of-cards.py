#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0914-x-of-a-kind-in-a-deck-of-cards.py
# @Date   : 2021/06/19
# @Author : Yuvv <yuvv_th@outlook.com>

import math

from typing import List


class Solution:
    def hasGroupsSizeX(self, deck: List[int]) -> bool:
        d = {}
        for e in deck:
            d[e] = d.get(e, 0) + 1

        s = list(set(d.values()))
        s_gcd = s[0]
        for e in s[1:]:
            s_gcd = math.gcd(s_gcd, e)
        return s_gcd >= 2
