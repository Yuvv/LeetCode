#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1773-count-items-matching-a-rule.py
# @Date   : 2021/03/07
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def countMatches(self, items: List[List[str]], ruleKey: str, ruleValue: str) -> int:
        # [type, color, name]
        idx = 0
        if ruleKey == 'color':
            idx = 1
        elif ruleKey == 'name':
            idx = 2

        return len([x for x in items if x[idx] == ruleValue])


if __name__ == '__main__':
    s = Solution()
    # 1 expected
    print(
        s.countMatches([["phone", "blue", "pixel"], ["computer", "silver", "lenovo"], ["phone", "gold", "iphone"]],
                       'color', 'silver'))
