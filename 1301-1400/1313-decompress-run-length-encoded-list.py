#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1313-decompress-run-length-encoded-list.py
# @Date   : 2020/01/18
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def decompressRLElist(self, nums: List[int]) -> List[int]:
        nums_len = len(nums)
        pos = 0
        result = []
        while pos < nums_len:
            freq = nums[pos]
            val = nums[pos + 1]
            for _ in range(freq):
                result.append(val)
            pos += 2

        return result

if __name__ == "__main__":
    s = Solution()
    # [2, 4, 4, 4] expected
    print(s.decompressRLElist([1, 2, 3, 4]))
