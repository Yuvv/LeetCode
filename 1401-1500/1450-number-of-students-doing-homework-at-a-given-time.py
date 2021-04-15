#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1450-number-of-students-doing-homework-at-a-given-time.py
# @Date   : 2021/04/15
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def busyStudent(self, startTime: List[int], endTime: List[int], queryTime: int) -> int:
        cnt = 0
        for each in zip(startTime, endTime):
            if each[0] <= queryTime <= each[1]:
                cnt += 1

        return cnt


if __name__ == '__main__':
    s = Solution()
    # 1
    print(s.busyStudent([1, 2, 3], [3, 2, 7], 4))
    # 1
    print(s.busyStudent([4], [4], 4))
    # 0
    print(s.busyStudent([1, 1, 1, 1], [1, 3, 2, 4], 7))
    # 5
    print(s.busyStudent([9, 8, 7, 6, 5, 4, 3, 2, 1], [10, 10, 10, 10, 10, 10, 10, 10, 10], 5))
