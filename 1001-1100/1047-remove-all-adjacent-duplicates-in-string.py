class Solution:
    """
    https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
    递归删除相邻的元素
    """
    def removeDuplicates(self, S: str) -> str:
        stack = list()
        for c in S:
            if len(stack) > 0:
                if c == stack[-1]:
                    stack.pop()
                else:
                    stack.append(c)
            else:
                stack.append(c)
        return ''.join(stack)


if __name__ == "__main__":
    s = Solution()
    print(s.removeDuplicates('abbaca'))   # `ca`  expected
    print(s.removeDuplicates('baaaccddccaababa'))  # `bababa`  expected
