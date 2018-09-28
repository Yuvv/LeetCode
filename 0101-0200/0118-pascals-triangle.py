class Solution:
    """
    帕斯卡三角形
    https://leetcode.com/problems/pascals-triangle/description/
    """
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        result = list()
        result.append([1])
        result.append([1, 1])
        if numRows < 3:
            return result[:numRows]
        else:
            for r in range(2, numRows):
                row = list()
                row.append(1)
                for c in range(1, r):
                    row.append(result[r - 1][c - 1] + result[r - 1][c])
                row.append(1)
                result.append(row)
        return result