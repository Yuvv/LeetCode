#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 2169-count-operations-to-obtain-zero.py
# @Author : Yuvv (yuvv_th@outlook.com)
# @Date   : 2022-02-14


class Solution:
    def countOperations(self, num1: int, num2: int) -> int:
        cnt = 0
        while num1 > 0 and num2 > 0:
            if num1 >= num2:
                num1 -= num2
            else:
                num2 -= num1
            cnt += 1

        return cnt


if __name__ == '__main__':
    s = Solution()
    # 3
    print(s.countOperations(2, 3))
    # 1
    print(s.countOperations(10, 10))
