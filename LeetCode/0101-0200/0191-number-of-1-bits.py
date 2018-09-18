class Solution(object):
    """
    求整数中有多少 1
    https://leetcode.com/problems/number-of-1-bits/description/
    """
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        count = 0;
        while n > 0:
            if (n & 1) > 0:
                count += 1
            n >>= 1
        return count
