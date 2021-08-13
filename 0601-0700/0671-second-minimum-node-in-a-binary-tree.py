#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0671-second-minimum-node-in-a-binary-tree.py
# @Date   : 2021/08/13
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import Optional, Tuple


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def findSecondMinimumValue(self, root: Optional[TreeNode]) -> int:
        first, second = -1, -1
        stack = [root]
        while len(stack) > 0:
            node = stack.pop()
            if first == -1 or node.val < first:
                first, second = node.val, first
            elif (second == -1 or node.val < second) and node.val > first:
                second = node.val
            # push left and right node
            if node.left:
                stack.append(node.left)
            if node.right:
                stack.append(node.right)
        return second


if __name__ == '__main__':
    s = Solution()
    # 5
    print(s.findSecondMinimumValue(TreeNode(2, TreeNode(2), TreeNode(5, TreeNode(5), TreeNode(7)))))
    # -1
    print(s.findSecondMinimumValue(TreeNode(2, TreeNode(2), TreeNode(2))))
