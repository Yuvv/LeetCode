#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1309-decrypt-string-from-alphabet-to-integer-mapping.py
# @Date   : 2020/01/18
# @Author : Yuvv <yuvv_th@outlook.com>


class Solution:
    def freqAlphabets(self, s: str) -> str:
        s_len = len(s)
        pos = s_len - 1
        result = []
        while pos >= 0:
            c = s[pos]
            if c == '#':
                pos -= 1
                c_1 = s[pos]
                pos -= 1
                c_2 = s[pos]
                # ord('a') == 97
                result.insert(0, chr(96 + ord(c_1) - 48 + (ord(c_2) - 48) * 10))
            else:
                result.insert(0, chr(96 + ord(c) - 48))
            pos -= 1

        return ''.join(result)



if __name__ == '__main__':
    s = Solution()
    # `jkab`  expected
    print(s.freqAlphabets('10#11#12'))
    # `acz`  expected
    print(s.freqAlphabets('1326#'))
    # `y`  expected
    print(s.freqAlphabets('25#'))
    # `abcdefghijklmnopqrstuvwxyz`  expected
    print(s.freqAlphabets('12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#'))
