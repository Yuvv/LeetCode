#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0037-sudoku-solver.py
# @Date   : 2019/07/13
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        self.recursiveSolve(board)

    def recursiveSolve(self, board: List[List[str]]) -> bool:
        index = self.next_unsolved(board)
        if index is None:
            return True

        ri, ci = index
        for each in map(str, range(1, 10)):
            if self.is_ok(board, ri, ci, each):
                board[ri][ci] = each
                res = self.recursiveSolve(board)
                if res:
                    return True
                board[ri][ci] = '.'
        return False

    def next_unsolved(self, board: List[List[str]]) -> tuple:
        for ri in range(9):
            for ci in range(9):
                if board[ri][ci] == '.':
                    return (ri, ci)
        return None

    def is_ok(self, board: List[List[str]], ri: int, ci: int, value: str) -> bool:
        for cur_ri in range(9):
            if cur_ri != ri and board[cur_ri][ci] == value:
                return False
        for cur_ci in range(9):
            if cur_ci != ci and board[ri][cur_ci] == value:
                return False
        cur99_min_ri = ri // 3 * 3
        cur99_min_ci = ci // 3 * 3
        for cur_ri in range(cur99_min_ri, cur99_min_ri + 3):
            for cur_ci in range(cur99_min_ci, cur99_min_ci + 3):
                if cur_ri != ri and cur_ci != ci and board[cur_ri][cur_ci] == value:
                    return False
        return True



if __name__ == "__main__":
    s = Solution()
    board = [["5", "3", ".", ".", "7", ".", ".", ".", "."],
             ["6", ".", ".", "1", "9", "5", ".", ".", "."],
             [".", "9", "8", ".", ".", ".", ".", "6", "."],
             ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
             ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
             ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
             [".", "6", ".", ".", ".", ".", "2", "8", "."],
             [".", ".", ".", "4", "1", "9", ".", ".", "5"],
             [".", ".", ".", ".", "8", ".", ".", "7", "9"]]
    s.solveSudoku(board)
    for row in board:
        print(row)  # solved expected

    print('==>')
    board = [[".", ".", "9", "7", "4", "8", ".", ".", "."],
             ["7", ".", ".", ".", ".", ".", ".", ".", "."],
             [".", "2", ".", "1", ".", "9", ".", ".", "."],
             [".", ".", "7", ".", ".", ".", "2", "4", "."],
             [".", "6", "4", ".", "1", ".", "5", "9", "."],
             [".", "9", "8", ".", ".", ".", "3", ".", "."],
             [".", ".", ".", "8", ".", "3", ".", "2", "."],
             [".", ".", ".", ".", ".", ".", ".", ".", "6"],
             [".", ".", ".", "2", "7", "5", "9", ".", "."]]
    s.solveSudoku(board)
    for row in board:
        print(row)  # solved expected
