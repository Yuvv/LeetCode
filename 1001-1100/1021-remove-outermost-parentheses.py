class Solution:
    """
    https://leetcode.com/problems/remove-outermost-parentheses/
    移除每个括号组最外层的括号
    """
    def removeOuterParentheses(self, S: str) -> str:
        result_list = []
        left, right = 0, 0
        for c in S:
            if '(' == c:
                if left > 0:
                    result_list.append(c)
                left += 1
            elif ')' == c:
                right += 1
                if right == left:
                    left, right = 0, 0
                else:
                    result_list.append(c)

        return ''.join(result_list)


if __name__ == "__main__":
    s = Solution()
    print(s.removeOuterParentheses('(()())(())'))    # ()()()  expected
    print(s.removeOuterParentheses('(()())(())(()(()))'))  # ()()()()(())  expected
