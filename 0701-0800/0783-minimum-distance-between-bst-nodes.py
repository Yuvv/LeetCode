#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0783-minimum-distance-between-bst-nodes.py
# @Date   : 2021/07/13
# @Author : Yuvv <yuvv_th@outlook.com>


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def minDiffInBST(self, root: TreeNode) -> int:
        self.pre_val = None
        self.min_diff = 1000000000

        self.dfs(root)

        return self.min_diff

    def dfs(self, node: TreeNode):
        # left node
        if node.left:
            self.dfs(node.left)

        # current node
        if self.pre_val is not None:
            self.min_diff = min(self.min_diff, node.val - self.pre_val)
        self.pre_val = node.val

        # right node
        if node.right:
            self.dfs(node.right)


if __name__ == '__main__':
    s = Solution()
    # 2
    print(s.minDiffInBST(TreeNode(6, TreeNode(2, TreeNode(0), TreeNode(4)), TreeNode(9))))
    # 1
    print(s.minDiffInBST(TreeNode(1, TreeNode(0), TreeNode(48, TreeNode(12), TreeNode(49)))))