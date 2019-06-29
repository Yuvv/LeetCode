#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0412-fizz-buzz.py
# @Date   : 2019/06/29
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def fizzBuzz(self, n: int) -> List[str]:
        result = []
        for i in range(1, n+1):
            mod_3 = i % 3 == 0
            mod_5 = i % 5 == 0
            if mod_3 and mod_5:
                result.append('FizzBuzz')
            elif mod_3:
                result.append('Fizz')
            elif mod_5:
                result.append('Buzz')
            else:
                result.append(str(i))
        return result


if __name__ == "__main__":
    s = Solution()
    print(s.fizzBuzz(15))
