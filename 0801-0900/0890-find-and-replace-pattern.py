from typing import List


class Solution:
    """
    字符串模式匹配
    https://leetcode.com/problems/find-and-replace-pattern/
    """
    def findAndReplacePattern(self, words: List[str], pattern: str) -> List[str]:
        p_encoded = self.encode(pattern)
        result = []
        for word in words:
            if len(word) != len(pattern):
                continue
            if self.encode(word) == p_encoded:
                result.append(word)
        return result

    def encode(self, word):
        d = {}
        num = 0
        result = []
        for c in word:
            if c not in d:
                d[c] = num
                num += 1
            result.append(str(d[c]))
        return ''.join(result)


if __name__ == "__main__":
    s = Solution()
    # `mee`, `aqq` expected
    print(s.findAndReplacePattern(["abc", "deq", "mee", "aqq", "dkd", "ccc"], 'abb'))
