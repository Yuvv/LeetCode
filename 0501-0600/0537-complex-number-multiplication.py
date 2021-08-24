#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0537-complex-number-multiplication.py
# @Date   : 2021/08/24
# @Author : Yuvv <yuvv_th@outlook.com>


class Solution:
    def complexNumberMultiply(self, num1: str, num2: str) -> str:
        r1, i1 = num1.split('+')
        r1 = int(r1)
        i1 = int(i1[:-1])
        r2, i2 = num2.split('+')
        r2 = int(r2)
        i2 = int(i2[:-1])

        return f'{r1*r2-i1*i2}+{r1*i2+r2*i1}i'


if __name__ == '__main__':
    s = Solution()
    # "0+2i"
    print(s.complexNumberMultiply('1+1i', '1+1i'))
    # "0+-2i"
    print(s.complexNumberMultiply('1+-1i', '1+-1i'))
