# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    """
    合并二叉树
    https://leetcode.com/problems/merge-two-binary-trees/submissions/
    """
    def mergeTrees(self, t1: TreeNode, t2: TreeNode) -> TreeNode:
        if t1 is None:
            return t2
        if t2 is None:
            return t1

        s1 = [t1]
        s2 = [t2]
        while len(s2) > 0:
            tn1 = s1.pop()
            tn2 = s2.pop()

            if tn2 is None:
                # tn2 为 None时，tn1左右子都不需要处理
                continue

            # 程序保证 tn1 不可能为None
            tn1.val += tn2.val
            if tn1.right is None:
                if tn2.right is not None:
                    # tn1 右子为空 tn2 右子不为空时，直接将 tn2 右子作为 tn1 的右子
                    tn1.right = tn2.right
            elif tn2.right is not None:
                # tn1 右子不为空 tn2 右子也不为空时，正常添加二者的右子到栈中
                s1.append(tn1.right)
                s2.append(tn2.right)

            if tn1.left is None:
                if tn2.left is not None:
                    # tn1 左子为空 tn2 左子不为空时，直接将 tn2 左子作为 tn1 的左子
                    tn1.left = tn2.left
            elif tn2.left is not None:
                # tn1 左子不为空 tn2 左子也不为空时，正常添加二者的左子到栈中
                s1.append(tn1.left)
                s2.append(tn2.left)

        return t1
