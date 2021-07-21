#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0838-push-dominoes.py
# @Date   : 2021/07/21
# @Author : Yuvv <yuvv_th@outlook.com>


class Solution:
    def pushDominoes(self, dominoes: str) -> str:
        res = [c for c in dominoes]
        i = 0
        dominoes_len = len(res)
        while i < dominoes_len:
            if res[i] == '.':
                j = i
                while i < dominoes_len and res[i] == '.':
                    i += 1
                if i < dominoes_len and res[i] == 'L':
                    while j < i:
                        res[j] = 'L'
                        j += 1
            elif res[i] == 'R':
                while i < dominoes_len and res[i] == 'R':
                    i += 1
                j = i
                if i < dominoes_len and res[i] == '.':
                    while i < dominoes_len and res[i] == '.':
                        i += 1
                    if i < dominoes_len:
                        if res[i] == 'L':
                            k = i - 1
                            while j < k:
                                res[j] = 'R'
                                res[k] = 'L'
                                j += 1
                                k -= 1
                            while i < dominoes_len and res[i] == 'L':
                                i += 1
                        else:
                            while j < i:
                                res[j] = 'R'
                                j += 1
                    else:
                        while j < i:
                            res[j] = 'R'
                            j += 1
            else:
                i += 1
        return ''.join(res)


if __name__ == '__main__':
    s = Solution()
    # "RR.L"
    print(s.pushDominoes("RR.L"))
    # "RRR.L"
    print(s.pushDominoes("R.R.L"))
    # "LL.RR.LLRRLL.."
    print(s.pushDominoes(".L.R...LR..L.."))
    # "LL.RR.LLRR.LL.."
    print(s.pushDominoes(".L.R...LR...L.."))
    # "LL.RR.LLRRLL..RRR"
    print(s.pushDominoes(".L.R...LR..L..R.."))
