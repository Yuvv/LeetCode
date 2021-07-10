#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0132-palindrome-partitioning-ii.py
# @Date   : 2021/07/10
# @Author : Yuvv <yuvv_th@outlook.com>


# TLE -> can optimaze space
class SolutionDpTopDown:
    def is_palindrome(self, s: str, i: int, j: int) -> bool:
        if self.dp_palindrome[i][j] is not None:
            return self.dp_palindrome[i][j]

        origin_i = i
        origin_j = j
        while i <= j:
            if s[i] != s[j]:
                self.dp_palindrome[origin_i][origin_j] = False
                return False
            i += 1
            j -= 1

        while origin_i <= origin_j:
            self.dp_palindrome[origin_i][origin_j] = True
            self.dp_min_cut[origin_j][origin_j] = 0
            origin_i += 1
            origin_j -= 1
        return True

    def get_min_cut(self, s: str, i: int, j: int) -> int:
        if self.dp_min_cut[i][j] is not None:
            return self.dp_min_cut[i][j]

        if self.is_palindrome(s, i, j):
            self.dp_min_cut[i][j] = 0
            return 0

        mn_cut = j - i
        for x in range(i, j):
            if self.is_palindrome(s, i, x):
                mn_cut = min(mn_cut, 1 + self.get_min_cut(s, x + 1, j))

        self.dp_min_cut[i][j] = mn_cut
        return mn_cut

    # dp-top-down  -> TLE
    def minCut(self, s: str) -> int:
        s_len = len(s)
        # init dp
        self.dp_palindrome = [[None for i in range(s_len)] for j in range(s_len)]
        self.dp_min_cut = [[None for i in range(s_len)] for j in range(s_len)]

        return self.get_min_cut(s, 0, s_len - 1)


# AC -> can optimaze space
class SolutionDpBottomUp:
    def build_palindrome_dp(self, s: str, n: int):
        for end in range(len(s)):
            for beg in range(end + 1):
                if s[beg] == s[end]:
                    if end - beg <= 2 or self.dp_palindrome[beg + 1][end - 1]:
                        self.dp_palindrome[beg][end] = True

    # dp-bottom-up  -> AC
    def minCut(self, s: str) -> int:
        s_len = len(s)
        # init dp
        self.dp_palindrome = [[None for i in range(s_len)] for j in range(s_len)]
        self.dp_min_cut = [None for i in range(s_len)]
        # build dp
        self.build_palindrome_dp(s, s_len)
        # get min
        for end in range(s_len):
            mn_cut = end
            for beg in range(end + 1):
                if self.dp_palindrome[beg][end]:
                    if beg == 0:
                        mn_cut = 0
                    else:
                        mn_cut = min(mn_cut, 1 + self.dp_min_cut[beg - 1])

            self.dp_min_cut[end] = mn_cut

        return self.dp_min_cut[s_len - 1]


# AC
class Solution:
    def get_min_cut(self, s: str, i: int, j: int):
        beg = i
        end = j
        while beg >= 0 and end < len(s) and s[beg] == s[end]:
            new_cut = 0 if beg == 0 else self.dp_min_cut[beg - 1] + 1
            self.dp_min_cut[end] = min(self.dp_min_cut[end], new_cut)
            beg -= 1
            end += 1

    # expand around the center  -> AC
    def minCut(self, s: str) -> int:
        s_len = len(s)
        # init dp
        self.dp_min_cut = [i for i in range(s_len)]

        # get min
        for mid in range(s_len):
            self.get_min_cut(s, mid, mid)
            self.get_min_cut(s, mid - 1, mid)

        return self.dp_min_cut[s_len - 1]


if __name__ == '__main__':
    s = Solution()
    # 1
    print(s.minCut("aab"))
    # 1
    print(s.minCut("ab"))
    # 5
    print(s.minCut('backahhhahahahah'))
    # 2
    print(s.minCut('edefedefedfefde'))
    # 0
    print(s.minCut("ababababababababababababcbabababababababababababa"))
