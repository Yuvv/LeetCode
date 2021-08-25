#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0733-flood-fill.py
# @Date   : 2021/08/25
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        n_rows = len(image)
        n_cols = len(image[0])
        origin_val = image[sr][sc]
        if newColor == origin_val:
            return image
        image[sr][sc] = newColor
        if sr > 0 and image[sr - 1][sc] == origin_val:
            self.floodFill(image, sr - 1, sc, newColor)
        if sr < n_rows - 1 and image[sr + 1][sc] == origin_val:
            self.floodFill(image, sr + 1, sc, newColor)
        if sc > 0 and image[sr][sc - 1] == origin_val:
            self.floodFill(image, sr, sc - 1, newColor)
        if sc < n_cols - 1 and image[sr][sc + 1] == origin_val:
            self.floodFill(image, sr, sc + 1, newColor)

        return image


if __name__ == '__main__':
    s = Solution()
    # [[2,2,2],[2,2,0],[2,0,1]]
    print(s.floodFill([[1, 1, 1], [1, 1, 0], [1, 0, 1]], 1, 1, 2))
    # [[2,2,2],[2,2,2]]
    print(s.floodFill([[0, 0, 0], [0, 0, 0]], 0, 0, 2))
    # [[0, 0, 0], [0, 1, 1]]
    print(s.floodFill([[0, 0, 0], [0, 1, 1]], 1, 1, 1))
