#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0501-find-mode-in-binary-search-tree.py
# @Date   : 2021/07/09
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def findMode(self, root: TreeNode) -> List[int]:
        stack = [root]
        cnt_map = dict()
        mx_cnt = 0
        while len(stack) > 0:
            node = stack.pop()
            cnt = cnt_map.get(node.val, 0) + 1
            if cnt > mx_cnt:
                mx_cnt = cnt
            cnt_map[node.val] = cnt

            if node.left:
                stack.append(node.left)
            if node.right:
                stack.append(node.right)

        return [k for k, v in cnt_map.items() if v == mx_cnt]


if __name__ == '__main__':
    s = Solution()
    # [2]
    print(s.findMode(TreeNode(1, right=TreeNode(2, TreeNode(2)))))
    # [0]
    print(s.findMode(TreeNode(0)))