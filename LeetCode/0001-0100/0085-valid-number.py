class Solution:
    """
    判断数字是否合法（省懒了）
    https://leetcode.com/problems/valid-number/description/
    """
    def isNumber(self, s):
        """
        :type s: str
        :rtype: bool
        """
        try:
            float(s)
        except ValueError:
            return False
        else:
            return True
