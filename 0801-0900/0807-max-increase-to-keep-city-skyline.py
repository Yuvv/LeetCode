from typing import List


class Solution:
    """
    https://leetcode.com/problems/max-increase-to-keep-city-skyline/
    求一组楼房最多加盖的高度
    """
    def maxIncreaseKeepingSkyline(self, grid: List[List[int]]) -> int:
        row_max = []   # 水平方向
        col_max = [i for i in grid[0]]  # 垂直方向
        for row in grid:
            cur_row_max = row[0]
            for i, col  in enumerate(row):
                if col > cur_row_max:
                    cur_row_max = col
                if col > col_max[i]:
                    col_max[i] = col
            row_max.append(cur_row_max)

        total = 0
        for i, row in enumerate(grid):
            for j, col in enumerate(row):
                total += min(col_max[j], row_max[i]) - col
        return total


if __name__ == "__main__":
    s = Solution()
    print(s.maxIncreaseKeepingSkyline(
        [[3, 0, 8, 4, 1], [2, 4, 11, 7, 1], [9, 2, 6, 3, 1], [0, 3, 1, 0, 1]]))
    # 36 expected

