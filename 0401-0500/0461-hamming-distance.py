class Solution(object):
    """
    https://leetcode.com/problems/hamming-distance/
    汉明距离
    """
    def hammingDistance(self, x, y):
        """
        :type x: int
        :type y: int
        :rtype: int
        """
        dis = 0
        while x > 0 and y > 0:
            dis += (x & 1) ^ (y & 1)
            x >>= 1
            y >>= 1
        while x > 0:
            dis += x & 1
            x >>= 1
        while y > 0:
            dis += y & 1
            y >>= 1
        return dis


if __name__ == "__main__":
    s = Solution()
    print(s.hammingDistance(1, 4))    # 2 expected
    print(s.hammingDistance(4, 1))    # 2 expected