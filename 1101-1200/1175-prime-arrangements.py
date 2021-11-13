#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1175-prime-arrangements.py
# @Author : Yuvv (yuvv_th@outlook.com)
# @Date   : 2021-11-13

import math


class Solution:
    MOD = 1000000007

    def is_prime(self, n):
        for i in range(2, int(math.sqrt(n)) + 1):
            if n % i == 0:
                return False
        return True

    def fac(self, n):
        res = 1
        for i in range(2, n + 1):
            res *= i
            res %= Solution.MOD

        return res

    def numPrimeArrangements(self, n: int) -> int:
        prime_cnt = 0
        for i in range(2, n + 1):
            if self.is_prime(i):
                prime_cnt += 1

        rem_cnt = n - prime_cnt

        return self.fac(rem_cnt) * self.fac(prime_cnt) % Solution.MOD



if __name__ == '__main__':
    s = Solution()
    # 12
    print(s.numPrimeArrangements(5))
    # 682289015
    print(s.numPrimeArrangements(100))
