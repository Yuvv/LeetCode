#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0367-valid-perfect-square.py
# @Date   : 2021/06/28
# @Author : Yuvv <yuvv_th@outlook.com>


class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        beg, end = 0, num // 2 + 1
        while end >= beg:
            mid = (end + beg) // 2
            power_of_mid = mid * mid
            if power_of_mid == num:
                return True
            elif power_of_mid < num:
                beg = mid + 1
            else:
                end = mid - 1
        return False


if __name__ == '__main__':
    s = Solution()
    # true
    print(s.isPerfectSquare(16))
    # false
    print(s.isPerfectSquare(14))
    # true
    print(s.isPerfectSquare(1))
