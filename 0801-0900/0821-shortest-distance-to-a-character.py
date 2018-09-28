class Solution:
    def shortestToChar(self, S, C):
        """
        :type S: str
        :type C: str
        :rtype: List[int]
        """
        pos = list()
        for i, s in enumerate(S):
            if s == C:
                pos.append(i)
        k = 0
        res = list()
        for i, s in enumerate(S):
            if k == 0:
                res.append(pos[k] - i)
            elif k == len(pos):
                res.append(i - pos[k - 1])
            else:
                res.append(min(pos[k] - i, i - pos[k - 1]))
            if k < len(pos) and i == pos[k]:
                k += 1
        return res