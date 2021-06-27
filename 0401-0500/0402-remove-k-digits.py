#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0402-remove-k-digits.py
# @Date   : 2021/06/27
# @Author : Yuvv <yuvv_th@outlook.com>


class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        num_len = len(num)
        target_rl_len = num_len - k
        if target_rl_len <= 0:
            return '0'

        rl = []
        i = 0
        while k > 0 and i < num_len - k:
            j = i + 1
            end_j = i + k + 1
            while j < end_j and num[j] >= num[i]:
                j += 1

            if j < end_j:
                k -= j - i
                i = j
            else:
                rl.append(num[i])
                i += 1

        # add others
        if len(rl) < target_rl_len:
            rl.append(num[i:])

        return str(int(''.join(rl)))


if __name__ == '__main__':
    s = Solution()
    # 1219
    print(s.removeKdigits('1432219', 3))
    # 200
    print(s.removeKdigits('10200', 1))
    # 0
    print(s.removeKdigits('10', 2))
    # 1
    print(s.removeKdigits('450213', 4))
    # 185
    print(s.removeKdigits('361985', 3))
