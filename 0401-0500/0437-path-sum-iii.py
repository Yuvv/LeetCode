# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    def __str__(self):
        return f'<TreeNode:{self.val}>'


class Solution:
    sum_key = 'sum'

    def pathSum(self, root: TreeNode, _sum: int) -> int:
        """
        求二叉树中和等于期望数的路径
        :param root: 根节点
        :param _sum: 期望数
        :return: 满足条件的路径的数目
        """
        stack = [root]
        total = 0
        while len(stack) > 0:
            node = stack.pop()
            if node is not None:
                total += self.getPathSum(node, _sum)
                stack.append(node.right)
                stack.append(node.left)
        return total

    def getPathSum(self, root: TreeNode, _sum: int) -> int:
        setattr(root, self.sum_key, root.val)
        stack = [root]
        total = 1 if root is not None and root.val == _sum else 0
        while len(stack) > 0:
            node = stack.pop()
            if node is None:
                continue
            if node.right is not None:
                setattr(node.right, self.sum_key,
                        node.right.val + getattr(node, self.sum_key, 0))
                if getattr(node.right, self.sum_key) == _sum:
                    total += 1
                stack.append(node.right)
            if node.left is not None:
                setattr(node.left, self.sum_key,
                        node.left.val + getattr(node, self.sum_key, 0))
                if getattr(node.left, self.sum_key) == _sum:
                    total += 1
                stack.append(node.left)
        return total


if __name__ == '__main__':
    root = TreeNode(10)
    root.left = TreeNode(5)
    root.left.left = TreeNode(3)
    root.left.right = TreeNode(2)
    root.left.left.left = TreeNode(3)
    root.left.left.right = TreeNode(-2)
    root.left.right.right = TreeNode(1)
    root.right = TreeNode(-3)
    root.right.right = TreeNode(11)

    s = Solution()
    print(s.pathSum(root, 8))   # 3 expected

    root.left.right.right.val = 8
    print(s.pathSum(root, 8))   # 3 expected

    root.val = 1
    print(s.pathSum(root, 8))   # 4 expected
