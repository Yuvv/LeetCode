#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0606-construct-string-from-binary-tree.py
# @Date   : 2021/08/09
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def tree2str(self, root: Optional[TreeNode]) -> str:
        if root is None:
            return ''
        if root.left is None and root.right is None:
            return f'{root.val}'

        if root.right:
            right = self.tree2str(root.right)
            left = self.tree2str(root.left)
            return f'{root.val}({left})({right})'

        if root.left:
            left = self.tree2str(root.left)
            return f'{root.val}({left})'
        else:
            return f'{root.val}'


if __name__ == '__main__':
    s = Solution()
    # "1(2(4))(3)"
    print(s.tree2str(TreeNode(1, TreeNode(2, TreeNode(4)), TreeNode(3))))
    # "1(2()(4))(3)"
    print(s.tree2str(TreeNode(1, TreeNode(2, right=TreeNode(4)), TreeNode(3))))
