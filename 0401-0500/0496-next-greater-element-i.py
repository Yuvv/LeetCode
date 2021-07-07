#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0496-next-greater-element-i.py
# @Date   : 2021/07/07
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    # 这一题用单调栈更好，逆序遍历nums2，构建一个栈，确保栈顶是大于当前元素
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        idx_d = {}
        nxt_idx = [-1] * len(nums2)
        to_process_set = set()
        for i, e in enumerate(nums2):
            idx_d[e] = i
            if len(to_process_set) > 0:
                to_del = []
                for j in to_process_set:
                    if nums2[j] < nums2[i]:
                        nxt_idx[j] = nums2[i]
                        to_del.append(j)
                for j in to_del:
                    to_process_set.remove(j)

            # add
            to_process_set.add(i)
        return [nxt_idx[idx_d[e]] for e in nums1]


if __name__ == '__main__':
    s = Solution()
    # [-1,3,-1]
    print(s.nextGreaterElement([4, 1, 2], [1, 3, 4, 2]))
    # [3,-1]
    print(s.nextGreaterElement([2, 4], [1, 2, 3, 4]))
