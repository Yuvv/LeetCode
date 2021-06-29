#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0404-sum-of-left-leaves.py
# @Date   : 2021/06/29
# @Author : Yuvv <yuvv_th@outlook.com>


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def sumOfLeftLeaves(self, root: TreeNode) -> int:
        stack = [root]
        result = 0
        while len(stack) > 0:
            node = stack.pop()
            if node.right:
                stack.append(node.right)
            if node.left:
                if node.left.left is None and node.left.right is None:
                    # leaf
                    result += node.left.val
                else:
                    stack.append(node.left)

        return result


if __name__ == '__main__':
    s = Solution()
    # 24
    root = TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))
    print(s.sumOfLeftLeaves(root))
