# 这一题使用 java 会有坑爹的数值范围问题，
# case：n=2126753390, target=1702766719，
# 超过 int 表示范围，但接口却只有 int 型

# The isBadVersion API is already defined for you.
# @param version, an integer
# @return a bool
# def isBadVersion(version):

class Solution(object):
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        left, right = 1, n
        while left < right:
            mid = (left + right) // 2
            if isBadVersion(mid):
                right = mid - 1
            else:
                left = mid + 1
        
        return left if isBadVersion(left) else left + 1
        