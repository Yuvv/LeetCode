#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0217-contains-duplicate.py
# @Date   : 2019/07/14
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        s = set()
        for num in nums:
            if num in s:
                return True
            s.add(num)
        return False


if __name__ == "__main__":
    s = Solution()
    print(s.containsDuplicate([1, 2, 3, 1]))
