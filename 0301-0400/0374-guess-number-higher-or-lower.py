# The guess API is already defined for you.
# @param num, your guess
# @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
# def guess(num):

class Solution(object):
    """
    猜数
    https://leetcode.com/problems/guess-number-higher-or-lower/description/
    """
    def guessNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        begin = 1
        end = n
        while True:
            mid = (begin + end) // 2
            res = guess(mid)
            if res == 0:
                return mid
            elif res > 0:
                begin = mid + 1
            elif res < 0:
                end = mid - 1