#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0228-summary-ranges.py
# @Date   : 2021/06/21
# @Author : Yuvv <yuvv_th@outlook.com

from typing import List


class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        result = []
        nums_len = len(nums)
        if nums_len == 0:
            return result
        i = 0
        j = 1
        while j < nums_len:
            if nums[j] == nums[j - 1] + 1:
                j += 1
                continue
            else:
                if j - i == 1:
                    result.append(str(nums[i]))
                else:
                    result.append(f'{nums[i]}->{nums[j-1]}')
                i = j
            j += 1

        if j > i:
            if j - i == 1:
                result.append(str(nums[i]))
            else:
                result.append(f'{nums[i]}->{nums[j-1]}')
        return result


if __name__ == "__main__":
    s = Solution()
    # ["0->2","4->5","7"]
    print(s.summaryRanges([0, 1, 2, 4, 5, 7]))
    # ["0","2->4","6","8->9"]
    print(s.summaryRanges([0, 2, 3, 4, 6, 8, 9]))
