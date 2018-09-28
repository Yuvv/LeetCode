class Solution:
    """
    爬楼梯，每次只能爬1或2步（顺序递推）
    https://leetcode.com/problems/climbing-stairs/description/
    """
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        result_list = [0, 1, 2]
        if n < 3:
            return result_list[n]
        for i in range(3, n):
            result_list.append(result_list[i - 1] + result_list[i - 2])

        return result_list[n - 1] + result_list[n - 2]