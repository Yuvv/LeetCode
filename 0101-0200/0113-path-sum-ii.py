#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0113-path-sum-ii.py
# @Date   : 2021/03/09
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        result_list = []
        self.path_sum(root, targetSum, result_list, [])
        return result_list

    def path_sum(self, c_node: TreeNode, t_sum: int, r_list: List[List[int]], c_list: List[int]):
        if c_node is None:
            return
        if c_node.left is None and c_node.right is None and c_node.val == t_sum:
            cl = [e for e in c_list]
            cl.append(c_node.val)
            r_list.append(cl)
            return
        c_list.append(c_node.val)
        if c_node.left is not None:
            self.path_sum(c_node.left, t_sum - c_node.val, r_list, c_list)
        if c_node.right is not None:
            self.path_sum(c_node.right, t_sum - c_node.val, r_list, c_list)
        c_list.pop()


if __name__ == '__main__':
    s = Solution()
    # [[1,2]] expected
    print(s.pathSum(TreeNode(1, TreeNode(2), TreeNode(3)), 3))
