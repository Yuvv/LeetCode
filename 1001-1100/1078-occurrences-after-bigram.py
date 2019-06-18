from typing import List


class Solution:
    """
    https://leetcode.com/problems/occurrences-after-bigram/
    找出在 first 和 second 之后出现的第三个词
    """

    def findOcurrences(self, text: str, first: str, second: str) -> List[str]:
        text_arr = list(filter(lambda x: x, text.split(' ')))
        result = list()
        upper_bound = len(text_arr) - 1
        idx = 1
        while idx < upper_bound:
            if text_arr[idx - 1] == first and text_arr[idx] == second:
                result.append(text_arr[idx + 1])
            idx += 1
        return result


if __name__ == "__main__":
    s = Solution()
    # ["girl","student"]  expected
    print(
        s.findOcurrences('alice is a good girl she is a good student', 'a',
                         'good'))
    # ["we","rock"] expected
    print(s.findOcurrences('we will we will rock you', 'we', 'will'))
