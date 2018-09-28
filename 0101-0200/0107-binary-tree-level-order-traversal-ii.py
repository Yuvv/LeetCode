# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    """
    树的层级遍历
    https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
    """
    def levelOrderBottom(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        result = list()
        queue = list()
        queue.append([root])
        while len(queue) > 0:
            level_list = queue[0]
            r_list = list()
            n_list = list()
            for node in level_list:
                if node is not None:
                    r_list.append(node.val)
                    n_list.append(node.left)
                    n_list.append(node.right)
            if r_list:
                result.insert(0, r_list)
            if n_list:
                queue.append(n_list)

            del queue[0]

        return result
