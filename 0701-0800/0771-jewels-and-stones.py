import functools


class Solution:
    """
    https://leetcode.com/problems/jewels-and-stones/
    查找一个字符串中字符在另一个字符串中出现的次数
    """
    def numJewelsInStones(self, J: str, S: str) -> int:
        jewels = set(c for c in J)
        return sum(1 for _ in filter(lambda x: x in jewels, (c for c in S)))
