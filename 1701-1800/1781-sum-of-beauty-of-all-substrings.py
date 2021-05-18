#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1781-sum-of-beauty-of-all-substrings.py
# @Date   : 2021/05/18
# @Author : Yuvv <yuvv_th@outlook.com>


class Solution:
    def beautySum(self, s: str) -> int:
        s_len = len(s)
        result = 0
        # build prefix dict arr
        prefix_dict_arr = []
        prefix_dict = {}
        for i in s:
            prefix_dict = dict(prefix_dict)
            prefix_dict[i] = prefix_dict.get(i, 0) + 1
            prefix_dict_arr.append(prefix_dict)

        # iter each substring & calculate beauty sum
        for i in range(3, s_len + 1):
            for j in range(i - 1, s_len):
                mx = 0
                mn = 1000000
                j_dict = prefix_dict_arr[j]
                if j - i < 0:
                    i_dict = {}
                else:
                    i_dict = prefix_dict_arr[j - i]
                for k, v in j_dict.items():
                    v -= i_dict.get(k, 0)
                    if v > mx:
                        mx = v
                    if v > 0 and v < mn:
                        mn = v
                result += mx - mn

        return result


if __name__ == '__main__':
    s = Solution()
    # 5
    print(s.beautySum('aabcb'))
    # 17
    print(s.beautySum('aabcbaa'))
    # 77
    print(s.beautySum('aabcbabacabd'))
    # 104
    print(s.beautySum("aabcbabacabda"))
    # 131
    print(s.beautySum('aabcbabacabdac'))
    # 271
    print(s.beautySum('aabcbabacabdacbacd'))
    # 423
    print(s.beautySum('aabcbabacabdacbacdaba'))
