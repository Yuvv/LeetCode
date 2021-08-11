#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0653-two-sum-iv-input-is-a-bst.py
# @Date   : 2021/08/11
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        stack = [root]
        num_set = set()
        while len(stack) > 0:
            node = stack.pop()
            if node is None:
                continue
            target = k - node.val
            if target in num_set:
                return True

            num_set.add(node.val)

            if node.left:
                stack.append(node.left)
            if node.right:
                stack.append(node.right)

        return False


if __name__ == '__main__':
    s = Solution()
    # true
    print(s.findTarget(TreeNode(5, TreeNode(3), TreeNode(6)), 9))
    # false
    print(s.findTarget(TreeNode(5, TreeNode(3, TreeNode(2)), TreeNode(6)), 28))
