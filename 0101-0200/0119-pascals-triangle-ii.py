class Solution:
    def getRow(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        if rowIndex < 2:
            return [1] * (rowIndex + 1)
        last = [1, 1]
        for row in range(1, rowIndex + 1):
            cur = list()
            cur.append(1)
            for col in range(row - 1):
                cur.insert(col + 1, last[col] + last[col + 1])
            cur.append(1)
            last = cur

        return last