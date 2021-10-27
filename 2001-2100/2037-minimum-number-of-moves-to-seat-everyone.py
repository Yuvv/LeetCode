#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 2037-minimum-number-of-moves-to-seat-everyone.py
# @Author : Yuvv (yuvv_th@outlook.com)
# @Date   : 2021-10-28


from typing import List


class Solution:
    def minMovesToSeat(self, seats: List[int], students: List[int]) -> int:
        seats = sorted(seats)
        students = sorted(students)
        cnt = 0
        for seat, stu in zip(seats, students):
            cnt += abs(seat - stu)

        return cnt


if __name__ == "__main__":
    s = Solution()
    # 4
    print(s.minMovesToSeat([3, 1, 5], [2, 7, 4]))
    # 7
    print(s.minMovesToSeat([4, 1, 5, 9], [1, 3, 2, 6]))
    # 4
    print(s.minMovesToSeat([2, 2, 6, 6], [1, 3, 2, 6]))
