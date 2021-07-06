#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0495-teemo-attacking.py
# @Date   : 2021/07/06
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def findPoisonedDuration(self, timeSeries: List[int], duration: int) -> int:
        # last one must poisoned for `duration` seconds
        cnt = duration
        for i in range(1, len(timeSeries)):
            if timeSeries[i - 1] + duration > timeSeries[i]:
                cnt += timeSeries[i] - timeSeries[i - 1]
            else:
                cnt += duration
        return cnt


if __name__ == '__main__':
    s = Solution()
    # 4
    print(s.findPoisonedDuration([1, 4], 2))
    # 3
    print(s.findPoisonedDuration([1, 2], 2))
