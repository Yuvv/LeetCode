#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0552-student-attendance-record-ii.py
# @Date   : 2021/07/14
# @Author : Yuvv <yuvv_th@outlook.com>


class Solution:
    def checkRecord(self, n: int) -> int:
        """
        fna(1) = 2, fna(2) = 4, fna(3) = 7
        fna(n) = fna(n-1) + fna(n-2) + fna(n-3)

        fa(1) = 1, fa(2) = 4, fa(3) = 12
        fa(n) = fna(n-1) + fa(n-1) + fna(n-2) + fa(n-2) + fna(n-3) + fa(n-3)

        f(n) = 2*fna(n-1) + fa(n-1) + 2fna(n-2) + fa(n-2) + 2fna(n-3) + fa(n-3)
        """
        res = 0
        if n == 1:
            return 3
        elif n == 2:
            return 8
        elif n == 3:
            return 19
        else:
            i = 4
            fna_i_3, fna_i_2, fna_i_1 = 2, 4, 7
            fa_i_3, fa_i_2, fa_i_1 = 1, 4, 12

            res = 0
            while i <= n:
                fa_i = 2 * fna_i_1 + fa_i_1 + 2 * fna_i_2 + fa_i_2 + 2 * fna_i_3 + fa_i_3
                res = fa_i % 1000000007

                fna_i = fna_i_1 + fna_i_2 + fna_i_3
                fna_i %= 1000000007
                fa_i = fna_i_1 + fa_i_1 + fna_i_2 + fa_i_2 + fna_i_3 + fa_i_3
                fa_i %= 1000000007

                fna_i_3, fna_i_2, fna_i_1 = fna_i_2, fna_i_1, fna_i
                fa_i_3, fa_i_2, fa_i_1 = fa_i_2, fa_i_1, fa_i

                i += 1

            return res


if __name__ == '__main__':
    s = Solution()
    # 3
    print(s.checkRecord(1))
    # 8
    print(s.checkRecord(2))
    # 19
    print(s.checkRecord(3))
    # 43
    print(s.checkRecord(4))
    # 79891199
    print(s.checkRecord(45))
    # 183236316
    print(s.checkRecord(10101))
    # 749184020
    print(s.checkRecord(100000))
