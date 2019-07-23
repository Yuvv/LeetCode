#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0977-squares-of-a-sorted-array.py
# @Date   : 2019/07/24
# @Author : Yuvv <yuvv_th@outlook.com>


from typing import List


class Solution:
    def sortedSquares(self, A: List[int]) -> List[int]:
        if len(A) == 0:
            return A
        it = iter(A)
        val = next(it)
        cur_min = val * val
        cur_max = cur_min
        result = [cur_min]
        while True:
            try:
                val = next(it)
                val = val * val
                if val > cur_max:
                    result.append(val)
                    cur_max = val
                elif val < cur_min:
                    result.insert(0, val)
                    cur_min = val
                else:
                    begin, end = 0, len(result) - 1
                    while begin < end:
                        mid = (begin + end) // 2
                        if result[mid] > val:
                            end = mid - 1
                        elif result[mid] < val:
                            begin = mid + 1
                        else:
                            begin = end = mid
                    if result[begin] < val:
                        result.insert(begin + 1, val)
                    else:
                        result.insert(begin, val)
            except StopIteration:
                break
        return result


if __name__ == "__main__":
    s = Solution()
    # [0,1,9,16,100] expected
    print(s.sortedSquares([-4, -1, 0, 3, 10]))
    # [4,9,9,49,121] expected
    print(s.sortedSquares([-7, -3, 2, 3, 11]))
    # [1,4,16,25,25] expected
    print(s.sortedSquares([-5, -4, 1, 2, 5]))
