#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0766-toeplitz-matrix.py
# @Date   : 2021/08/31
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def isToeplitzMatrix(self, matrix: List[List[int]]) -> bool:
        n_row = len(matrix)
        n_col = len(matrix[0])

        for i in range(n_row):
            origin = matrix[i][0]
            for j in range(1, min(n_row - i, n_col)):
                if matrix[i + j][j] != origin:
                    return False

        for i in range(1, n_col):
            origin = matrix[0][i]
            for j in range(min(n_row, n_col - i)):
                if matrix[j][i + j] != origin:
                    return False
        return True


if __name__ == '__main__':
    s = Solution()
    # true
    print(s.isToeplitzMatrix([[1, 2, 3, 4], [5, 1, 2, 3], [9, 5, 1, 2]]))
    # false
    print(s.isToeplitzMatrix([[1, 2], [2, 2]]))
    # false
    print(s.isToeplitzMatrix([[11, 74, 0, 93], [40, 11, 74, 7]]))
    # true
    print(s.isToeplitzMatrix([[11, 74, 0, 93], [40, 11, 74, 0]]))
