#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0572-subtree-of-another-tree.py
# @Date   : 2021/07/17
# @Author : Yuvv <yuvv_th@outlook.com>


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def check_sub_tree(self, root_s: TreeNode, root_t: TreeNode) -> bool:
        if root_s is None and root_t is None:
            return True
        elif root_s is None or root_t is None:
            return False
        if root_s.val != root_t.val:
            return False
        if not self.check_sub_tree(root_s.left, root_t.left):
            return False
        if not self.check_sub_tree(root_s.right, root_t.right):
            return False
        return True

    def isSubtree(self, root: TreeNode, subRoot: TreeNode) -> bool:
        stack = [root]
        while len(stack) > 0:
            node = stack.pop()
            if node.val == subRoot.val:
                if self.check_sub_tree(node, subRoot):
                    return True
            if node.left:
                stack.append(node.left)
            if node.right:
                stack.append(node.right)
        return False


if __name__ == '__main__':
    s = Solution()
    # true
    root_s = TreeNode(3, TreeNode(4, TreeNode(1), TreeNode(2)), TreeNode(5))
    root_t = TreeNode(4, TreeNode(1), TreeNode(2))
    print(s.isSubtree(root_s, root_t))
