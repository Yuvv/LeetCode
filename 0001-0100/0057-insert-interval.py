#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0057-insert-interval.py
# @Date   : 2020/09/18
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        intervals.append(newInterval)
        if len(intervals) <= 1:
            return intervals
        intervals = sorted(intervals, key=lambda xi: xi[0])
        r_list = [intervals[0]]
        for each in intervals:
            last = r_list[-1]
            if last[0] <= each[0] <= last[1]:
                if each[1] > last[1]:
                    last[1] = each[1]
            else:
                r_list.append(each)

        return r_list


if __name__ == "__main__":
    s = Solution()

    # [[1,5],[6,9]]
    print(s.insert([[1, 3], [6, 9]], [2, 5]))
    # [[1,2],[3,10],[12,16]]
    print(s.insert([[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]], [4, 8]))
    # [[4,8]]
    print(s.insert([], [4, 8]))
    # [[4,8]]
    print(s.insert([[4, 8]], [4, 8]))
    # [[1,8]]
    print(s.insert([[1, 5]], [2, 8]))
