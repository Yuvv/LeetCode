# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    """
    https://leetcode.com/problems/range-sum-of-bst/
    找出二叉搜索树中两个数之间的数的和
    """
    def rangeSumBST(self, root: TreeNode, L: int, R: int) -> int:
        stack = [root]
        result = 0
        while len(stack):
            node = stack.pop()
            if node is None:
                continue
            if L <= node.val <= R:
                result += node.val
            if node.val < R:
                stack.append(node.right)
            if node.val > L:
                stack.append(node.left)

        return result


if __name__ == "__main__":
    s = Solution()
    node = TreeNode(10)
    node.left = TreeNode(5)
    node.right = TreeNode(15)
    node.left.left = TreeNode(3)
    node.left.right = TreeNode(7)
    node.right.right = TreeNode(18)
    print(s.rangeSumBST(node, 7, 17))   # 32 expected