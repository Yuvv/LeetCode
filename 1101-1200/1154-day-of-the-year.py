#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1154-day-of-the-year.py
# @Date   : 2019/08/20
# @Author : Yuvv <yuvv_th@outlook.com>


class Solution:
    DAYS_CUM = [0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334]

    def dayOfYear(self, date: str) -> int:
        y_m_d = date.split('-')
        y = int(y_m_d[0])
        m = int(y_m_d[1])
        d = int(y_m_d[2])
        days = d + Solution.DAYS_CUM[m - 1]
        if y % 4 == 0 and y % 100 != 0 or y % 400 == 0:
            if m > 2:
                days += 1
        return days


if __name__ == "__main__":
    s = Solution()
    # 9 expected
    print(s.dayOfYear('2019-01-09'))
    # 41 expected
    print(s.dayOfYear('2019-02-10'))
    # 60 expected
    print(s.dayOfYear('2003-03-01'))
    # 61 expected
    print(s.dayOfYear('2004-03-01'))
    # 60 expected
    print(s.dayOfYear('2016-02-29'))
    # 257 expected
    print(s.dayOfYear('2000-09-13'))
