#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0563-binary-tree-tilt.py
# @Date   : 2021/07/16
# @Author : Yuvv <yuvv_th@outlook.com>


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def findTilt(self, root: TreeNode) -> int:
        if root is None:
            return 0
        _, tilt_sum = self.buildTiltTree(root)
        return tilt_sum

    def buildTiltTree(self, node: TreeNode) -> (int, int):
        left_sum, left_tilt_sum = 0, 0
        if node.left:
            left_sum, left_tilt_sum = self.buildTiltTree(node.left)
        right_sum, right_tilt_sum = 0, 0
        if node.right:
            right_sum, right_tilt_sum = self.buildTiltTree(node.right)
        cur_sum = node.val + left_sum + right_sum
        node.val = abs(left_sum - right_sum)
        cur_tilt_sum = left_tilt_sum + right_tilt_sum + node.val
        return cur_sum, cur_tilt_sum


if __name__ == '__main__':
    s = Solution()
    # 1
    print(s.findTilt(TreeNode(1, TreeNode(2), TreeNode(3))))
    # 15
    print(s.findTilt(TreeNode(4, TreeNode(2, TreeNode(3), TreeNode(5)), TreeNode(9, right=TreeNode(7)))))
