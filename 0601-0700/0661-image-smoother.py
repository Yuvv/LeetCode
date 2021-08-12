#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0661-image-smoother.py
# @Date   : 2021/08/12
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def imageSmoother(self, img: List[List[int]]) -> List[List[int]]:
        res = []
        n_row = len(img)
        n_col = len(img[0])
        for i, row in enumerate(img):
            nr = []
            for j in range(n_col):
                cur_sum = 0
                cur_cnt = 0
                beg_j = max(0, j - 1)
                end_j = min(n_col, j + 2)
                if i > 0:
                    cur_sum += sum(img[i - 1][beg_j:end_j])
                    cur_cnt += end_j - beg_j
                cur_sum += sum(img[i][beg_j:end_j])
                cur_cnt += end_j - beg_j
                if i < n_row - 1:
                    cur_sum += sum(img[i + 1][beg_j:end_j])
                    cur_cnt += end_j - beg_j

                nr.append(cur_sum // cur_cnt)

            res.append(nr)
        return res


if __name__ == '__main__':
    s = Solution()
    # [[0,0,0],[0,0,0],[0,0,0]]
    print(s.imageSmoother([[1, 1, 1], [1, 0, 1], [1, 1, 1]]))
    # [[137,141,137],[141,138,141],[137,141,137]]
    print(s.imageSmoother([[100, 200, 100], [200, 50, 200], [100, 200, 100]]))
