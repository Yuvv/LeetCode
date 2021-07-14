#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0551-student-attendance-record-i.py
# @Date   : 2021/07/14
# @Author : Yuvv <yuvv_th@outlook.com>


class Solution:
    def checkRecord(self, s: str) -> bool:
        a_cnt = 0
        for i, c in enumerate(s):
            if c == 'A':
                a_cnt += 1
            if a_cnt >= 2:
                return False
            if c == 'L' and i >= 2:
                if s[i - 1] == 'L' and s[i - 2] == 'L':
                    return False

        return True


if __name__ == '__main__':
    s = Solution()
    # True
    print(s.checkRecord('PPALLP'))
    # False
    print(s.checkRecord('PPALLL'))
