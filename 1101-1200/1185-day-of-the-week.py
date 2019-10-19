#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1185-day-of-the-week.py
# @Date   : 2019/10/19
# @Author : Yuvv <yuvv_th@outlook.com>


class Solution:
    DAYS_CUM = [0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334]
    WEEKDAYS = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"]

    def dayOfTheWeek(self, day: int, month: int, year: int) -> str:
        # 2000年1月1日是周六
        y0, m0, d0 = 2000, 1, 1
        # 计算 diff 值
        diff_days = day - d0
        diff_months = month - m0
        diff_years = year - y0
        if year >= y0:
            total_diff_days = diff_days + Solution.DAYS_CUM[diff_months] + diff_years * 365
        else:
            diff_years = -diff_years
            total_diff_days = diff_years * 365 - Solution.DAYS_CUM[diff_months] - diff_days
        # 处理闰年的情况
        if year > y0 or (year == y0 and diff_months >= 2):
            # 2000 年也是闰年，需要加上 2 月多出来的一天
            total_diff_days += 1
        if year > y0 and month <= 2:
            if year % 4 == 0 and year % 100 != 0 or year % 400 == 0:
                # 当年是闰年的话需要减去 1，因为后面会重复计算
                total_diff_days -= 1
        if year < y0 and month > 2:
            if year % 4 == 0 and year % 100 != 0 or year % 400 == 0:
                # 当年是闰年的话需要减去 1，因为后面会重复计算
                total_diff_days -= 1
        total_diff_days += diff_years // 4
        total_diff_days -= diff_years // 100
        total_diff_days += diff_years // 400

        if year >= y0:
            return Solution.WEEKDAYS[total_diff_days % 7 - 1]
        else:
            return Solution.WEEKDAYS[6 - total_diff_days % 7]


if __name__ == "__main__":
    s = Solution()
    # Tuesday
    print(s.dayOfTheWeek(15, 4, 2008))
    # Sunday
    print(s.dayOfTheWeek(21, 12, 1980))
    # Saturday
    print(s.dayOfTheWeek(21, 2, 1976))
    # Monday
    print(s.dayOfTheWeek(29, 2, 2016))
    # Monday
    print(s.dayOfTheWeek(31, 1, 2000))
    # Wednesday
    print(s.dayOfTheWeek(1, 3, 2000))
    # Saturday
    print(s.dayOfTheWeek(31, 8, 2019))
    # Friday
    print(s.dayOfTheWeek(31, 12, 1999))
    # Sunday
    print(s.dayOfTheWeek(18, 7, 1999))
    # Sunday
    print(s.dayOfTheWeek(15, 8, 1993))
    # Tuesday
    print(s.dayOfTheWeek(1, 1, 1970))
