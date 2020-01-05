#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0849-maximize-distance-to-closest-person.py
# @Date   : 2020/01/05
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def maxDistToClosest(self, seats: List[int]) -> int:
        """
        https://leetcode.com/problems/maximize-distance-to-closest-person/
        求最远距离
        """
        seats_count = len(seats)
        max_dis = -1
        begin_np_index = 0
        cur_p_index = 0
        # 初始化第一个位置索引
        if seats[0] == 0:
            while cur_p_index < seats_count and seats[cur_p_index] == 0:
                cur_p_index += 1
            max_dis = cur_p_index

        # 中间部分
        while cur_p_index < seats_count:
            # 每次到了这里 cur_p_index 对应位置一定为 1
            while cur_p_index < seats_count and seats[cur_p_index] == 1:
                cur_p_index += 1
            # 得到第一个 0 的位置
            begin_np_index = cur_p_index
            while cur_p_index < seats_count and seats[cur_p_index] == 0:
                cur_p_index += 1
            # 此时 cur_p_index 对应位置一定为 1

            cur_dis = (cur_p_index - begin_np_index) // 2 + (cur_p_index - begin_np_index) % 2
            if cur_dis > max_dis:
                max_dis = cur_dis

        # 末尾部分
        if seats[-1] == 0:
            cur_dis = cur_p_index - begin_np_index
            if cur_dis > max_dis:
                max_dis = cur_dis

        return max_dis


if __name__ == "__main__":
    s = Solution()
    # 2 expected
    print(s.maxDistToClosest([1, 0, 0, 0, 1, 0, 1]))
    # 3 expected
    print(s.maxDistToClosest([1, 0, 0, 0]))
    # 3 expected
    print(s.maxDistToClosest([1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0]))
    # 3 expected
    print(s.maxDistToClosest([0, 0, 0, 1]))
    # 1 expected
    print(s.maxDistToClosest([1, 0, 0, 1, 0, 1]))
